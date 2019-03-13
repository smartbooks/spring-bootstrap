<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>用户管理<#include "/_layout/brand.ftl"></title>
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
                    <li class="active">用户管理</li>
                </ol>

                <!--正文内容开始-->

                <!--工具栏开始-->
                <div class="callout callout-primary">
                    <div class="btn-group">
                        <a class="btn btn-default btn-group-lg" href="#">今日</a>
                        <a class="btn btn-default btn-group-lg" href="#">昨日</a>
                        <a class="btn btn-default btn-group-lg" href="#">最近7日</a>
                        <a class="btn btn-default btn-group-lg" href="#">最近30日</a>
                        <form action="#" class="form-inline" style="float: left; margin-left: 10px;" method="GET">
                            <input type="hidden" id="domain" name="domain" value="0"/>
                            <div class="form-group">
                                <label>开始时间：</label>
                                <input type="text" class="form-control datepicker" name="beginDate" placeholder="开始时间"
                                       style="width: 100px;" value="">
                            </div>
                            <div class="form-group">
                                <label>结束时间：</label>
                                <input type="text" class="form-control datepicker" name="endDate" placeholder="结束时间"
                                       style="width: 100px;" value="">
                            </div>
                            <button type="submit" class="btn btn-default">查询</button>
                        </form>
                    </div>
                </div>
                <!--工具栏结束-->

                <!--表格开始-->
                <div class="panel panel-info" style="margin-bottom: 0px;">
                    <div class="panel-heading">
                        <h3 class="panel-title">全部用户</h3>
                    </div>

                    <table class="table table-hover table-striped table-condensed table-bordered center">

                        <thead>
                        <tr>
                            <th class="center">#序号</th>
                            <th class="center">ID</th>
                            <th class="center">CODE</th>
                            <th class="center">UserName</th>
                            <th class="center">Password</th>
                            <th class="center">Salt</th>
                            <th class="center">Operation</th>
                        </tr>
                        </thead>

                        <#if page_data??>
                            <tbody>

                            <#list page_data.data as entity>
                                <tr>
                                    <td>${entity_index+1}</td>
                                    <td>${entity.id?c}</td>
                                    <td>${entity.userCode}</td>
                                    <td>${entity.userName}</td>
                                    <td>${entity.password}</td>
                                    <td>${entity.salt}</td>
                                    <td>
                                        <a href="/root/sysuser/view?id=${entity.id?c}">详情</a> |
                                        <a href="/root/sysuser/put?id=${entity.id?c}">修改</a> |
                                        <a href="/root/sysuser/del?id=${entity.id?c}">删除</a> |
                                        <a href="/root/sysuser/add">新增</a>
                                    </td>
                                </tr>
                            </#list>

                            </tbody>
                        </#if>

                    </table>

                </div>
                <!--表格结束-->

                <!--分页开始-->
                <@PageNumber data="page_data"></@PageNumber>
                <!--分页结束-->

                <!--正文内容结束-->

            </div>
        </div>
    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>

</body>
</html>