<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>映射列表 - 映射管理 - 管理主页<#include "/_layout/brand.ftl"></title>
    <#include "/_layout/head.ftl" parse=false encoding="UTF-8">
</head>
<body>

<#include "/_layout/nav.ftl" parse=false encoding="UTF-8">

<div class="container body-content">

    <div style="min-height: 720px;">
        <div class="row">

            <#include "share/menu.ftl" parse=false>

            <div class="col-md-10">
                <ol class="breadcrumb">
                    <li><a href="/home/index">管理主页</a></li>
                    <li><a href="/root/urlmapping/index">映射管理</a></li>
                    <li class="active">映射列表</li>
                </ol>

                <!--正文内容开始-->

                <!--表格开始-->
                <div class="panel panel-info" style="margin-bottom: 0px;">
                    <div class="panel-heading">
                        <h3 class="panel-title">映射列表</h3>
                    </div>

                    <table class="table table-hover table-striped table-condensed table-bordered center">

                        <thead>
                        <tr>
                            <th class="center">序号</th>
                            <th class="center">类名</th>
                            <th class="center">方法名</th>
                            <th class="center">URL</th>
                            <th class="center">类型</th>
                        </tr>
                        </thead>

                        <#if page_data??>
                            <tbody>

                            <#list page_data as entity>
                                <tr>
                                    <td>${entity_index+1}</td>
                                    <td style="text-align: left;">${entity.className}</td>
                                    <td style="text-align: left;">${entity.method}</td>
                                    <td style="text-align: left;">
                                        <a href="${entity.url}" target="_blank">${entity.url}</a>
                                    </td>
                                    <td style="text-align: left;">${entity.type}</td>
                                </tr>
                            </#list>

                            </tbody>
                        </#if>

                    </table>

                </div>
                <!--表格结束-->

                <!--正文内容结束-->

            </div>
        </div>
    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>

</body>
</html>