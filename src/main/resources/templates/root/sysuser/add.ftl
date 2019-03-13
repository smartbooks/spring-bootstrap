<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>添加用户 - 用户管理<#include "/_layout/brand.ftl"></title>
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
                    <li class="active">添加用户</li>
                </ol>

                <!--正文内容开始-->

                <!--表单开始-->
                <form method="post" action="/root/sysuser/add" class="form-horizontal">

                    <table class="table table-condensed table-form">

                        <thead>
                        <tr>
                            <th></th>
                            <th class="center"><h2>添加用户</h2></th>
                            <th></th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td style="text-align: right">
                                <label class="control-label" for="userName">用户账号:</label>
                            </td>
                            <td style="text-align: left; width: 300px;">
                                <input type="text"
                                       id="userName"
                                       name="userName"
                                       autofocus="autofocus"
                                       class="form-control"
                                       placeholder="用户账号"
                                       aria-describedby="helpUserName"/>
                            </td>
                            <td style="text-align: left;">
                                <span id="helpUserName" class="help-block">用户账号是必须的.</span>
                            </td>
                        </tr>

                        <tr class="has-error">
                            <td style="text-align: right">
                                <label class="control-label" for="password">账号密码:</label>
                            </td>
                            <td style="text-align: left; width: 300px;">
                                <input type="password"
                                       id="password"
                                       name="password"
                                       class="form-control"
                                       placeholder="账号密码"
                                       aria-describedby="helpPassword"/>
                            </td>
                            <td style="text-align: left;">
                                <span id="helpPassword" class="help-block">账号密码是必须的.</span>
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td style="text-align: left; width: 300px;">
                                <#if page_error??>
                                    <div class="alert alert-danger">${page_error}</div>
                                </#if>
                            </td>
                            <td></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td class="center">
                                <button type="submit" class="btn btn-primary">添加</button>
                                <a href="/root/sysuser/list" class="btn btn-default">取消</a>
                            </td>
                            <td></td>
                        </tr>

                        </tbody>
                    </table>

                </form>
                <!--表单结束-->

                <!--正文内容结束-->

            </div>
        </div>
    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>

</body>
</html>