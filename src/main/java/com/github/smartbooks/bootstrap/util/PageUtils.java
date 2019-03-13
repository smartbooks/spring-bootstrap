package com.github.smartbooks.bootstrap.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 实用分页控价
 */
public class PageUtils {

    /**
     * 分页工具栏
     *
     * @param pageIndex    当前页码
     * @param pageSize     分页大小
     * @param sizeCount    记录总数
     * @param startPageNum 起始页码：默认1
     * @param pageOfNumber 每页页码个数：默认10
     * @param queryString  queryString查询参数
     * @return
     */
    public static String paging(
            long pageIndex,
            long pageSize,
            long sizeCount,
            long startPageNum,
            long pageOfNumber,
            String queryString) {


        //第一页，上一页 ... 5，6，7，8，9 ... 下一页，最后一页，转到{0}页，确定

        //计算出总页数
        long pageCount = sizeCount % pageSize == 0 ? sizeCount / pageSize : sizeCount / pageSize + 1;

        //如果只有一页不需要分页
        if (pageCount == 1) return "";

        StringBuilder pagedHtmlString = new StringBuilder();

        pagedHtmlString.append("<ul class='pagination'>");

        //第一页
        if (pageIndex > startPageNum) {
            pagedHtmlString.append(String.format("<li><a href='?pageindex=%s&pagesize=%s&%s' title='第一页'>第一页</a></li>",
                    startPageNum,
                    pageSize,
                    queryString));
        } else {
            pagedHtmlString.append("<li class='disabled'><a href='#' title='第一页'>第一页</a></li>");
        }

        //上一页
        if (pageIndex - 1 >= startPageNum && pageIndex - 1 <= pageCount) {
            pagedHtmlString.append(String.format("<li><a href='?pageindex=%s&pagesize=%s&%s' title='上一页'>上一页</a></li>",
                    pageIndex - 1,
                    pageSize,
                    queryString));
        } else {
            pagedHtmlString.append("<li class='disabled'><a href='#' title='上一页'>上一页</a></li>");
        }

        //当前页
        long pageItem = pageOfNumber - 1 >= startPageNum ? pageOfNumber - 1 : startPageNum;
        long pageStartIndex = pageIndex - pageItem / 2 >= startPageNum ? pageIndex - pageItem / 2 : startPageNum;
        long pageEndIndex = pageIndex + pageItem / 2 <= pageCount ? pageIndex + pageItem / 2 : pageCount;

        //尽量平均分配分页按钮的数量
        long offset = pageItem - (pageEndIndex - pageStartIndex);
        if (offset > 0) {
            boolean leftPatch = pageStartIndex - offset > startPageNum;
            if (leftPatch) {
                //向前扩展
                pageStartIndex = pageStartIndex - offset;
            } else {
                //向后扩展
                pageEndIndex = pageEndIndex + offset < pageCount ? pageEndIndex + offset : pageEndIndex;
            }
        }

        for (long i = pageStartIndex; i < pageEndIndex; i++) {
            if (i == pageIndex) {
                pagedHtmlString.append(String.format("<li class='active'><a href='#' title='当前页'>%s<span class='sr-only'>(current)</span></a></li>",
                        pageIndex + 1));
            } else {
                pagedHtmlString.append(String.format("<li><a href='?pageindex=%s&pagesize=%s&%s' title='第%s页'>%s</a></li>",
                        i,
                        pageSize,
                        queryString,
                        i,
                        i + 1));
            }
        }

        //下一页
        if (pageIndex + 1 >= startPageNum && pageIndex + 1 < pageCount) {
            pagedHtmlString.append(String.format("<li ><a href='?pageindex=%s&pagesize=%s&%s' title='下一页'>下一页</a></li>",
                    pageIndex + 1,
                    pageSize,
                    queryString));
        } else {
            pagedHtmlString.append("<li class='disabled'><a href='#' title='下一页'>下一页</a></li>");
        }

        //最后一页
        if (pageCount > pageIndex + 1) {
            pagedHtmlString.append(String.format("<li ><a href='?pageindex=%s&pagesize=%s&%s' title='最后一页'>最后一页</a></li>",
                    pageCount - 1,
                    pageSize,
                    queryString));
        } else {
            pagedHtmlString.append("<li class='disabled'><a href='#' title='最后一页'>最后一页</a></li>");
        }


        pagedHtmlString.append("</ul>");

        return pagedHtmlString.toString();

    }

    /**
     * 分页工具栏
     *
     * @param pageIndex   当前页码
     * @param pageSize    分页大小
     * @param sizeCount   记录总数
     * @param queryString queryString查询参数
     * @return
     */
    public static String paging(
            long pageIndex,
            long pageSize,
            long sizeCount,
            String queryString) {

        return paging(pageIndex, pageSize, sizeCount, 0, 10, queryString);

    }

    public static String paging(Paged paged, Map<String, String> queryStringMap) {

        StringBuilder html = new StringBuilder();

        if (paged != null && paged.getSizeCount() > 0) {

            //得到现有query参数
            String queryString = "";

            if (null != queryStringMap) {

                for (Map.Entry<String, String> entry : queryStringMap.entrySet()) {

                    String currentKey = entry.getKey().toLowerCase();

                    if (!currentKey.equalsIgnoreCase("pageindex") &&
                            !currentKey.equalsIgnoreCase("pagesize")) {

                        queryString += String.format("%s=%s&", currentKey, entry.getValue());

                    }

                }

            }

            html.append(paging(paged.getPageIndex(), paged.getPageSize(), paged.getSizeCount(), queryString));
        }

        if (paged != null && paged.getSizeCount() <= 0) {

            html.append("<div class='alert alert-info'> <strong>提示</strong> 没有查询到记录。 </div>");

        }

        return html.toString();
    }

    public static String paging(Paged paged, HttpServletRequest httpServletRequest) {

        Map<String, String> map = getQueryStringMap(httpServletRequest);

        return paging(paged, map);

    }

    public static Map<String, String> getQueryStringMap(HttpServletRequest httpServletRequest) {

        Map<String, String> queryMap = new HashMap<>();

        for (Map.Entry<String, String[]> item : httpServletRequest.getParameterMap().entrySet()) {

            String key = item.getKey();

            String[] values = item.getValue();

            if (null != values && values.length > 0) {

                queryMap.put(key, values[0]);

            }
        }

        return queryMap;
    }
}
