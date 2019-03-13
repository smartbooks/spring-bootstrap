<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>查看用户 - 用户管理<#include "/_layout/brand.ftl"></title>
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
                    <li class="active">查看用户</li>
                </ol>

                <!--正文内容开始-->

                <!--工具栏开始-->
                <div class="callout callout-primary">
                    <div class="btn-group">
                        <a class="btn btn-default btn-group-lg" href="/root/sysuser/list">返回</a>
                    </div>
                </div>
                <!--工具栏结束-->

                <!--表格开始-->
                <div class="panel panel-info" style="margin-bottom: 0px;">
                    <div class="panel-heading">
                        <h3 class="panel-title">用户资料</h3>
                    </div>

                    <table class="table table-hover table-striped table-condensed table-bordered center">

                        <thead>
                        <tr>
                            <th class="center">Property</th>
                            <th class="center">Value</th>
                            <th class="center">Description</th>
                        </tr>
                        </thead>

                        <#if page_data??>
                            <tbody>

                            <tr>
                                <td style="text-align: right;">ID</td>
                                <td style="text-align: left;">${page_data.id?c}</td>
                                <td style="text-align: left;"></td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">CODE</td>
                                <td style="text-align: left;">${page_data.userCode}</td>
                                <td style="text-align: left;"></td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">UserName</td>
                                <td style="text-align: left;">${page_data.userName}</td>
                                <td style="text-align: left;"></td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">Password</td>
                                <td style="text-align: left;">${page_data.password}</td>
                                <td style="text-align: left;"></td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">Salt</td>
                                <td style="text-align: left;">${page_data.salt}</td>
                                <td style="text-align: left;"></td>
                            </tr>

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