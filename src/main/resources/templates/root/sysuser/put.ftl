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
                <#if page_data??>
                    <form method="post" action="/root/sysuser/put" class="form-horizontal">
                        <table class="table table-condensed table-form">
                            <thead>
                            <tr>
                                <th></th>
                                <th class="center"><h2>修改用户</h2></th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>

                            <tr>
                                <td style="text-align: right">
                                    <label class="control-label" for="id">账户标识:</label>
                                </td>
                                <td style="text-align: left; width: 300px;">
                                    <input type="hidden" id="id" name="id" value="${page_data.id?c}">
                                    <label class="control-label">${page_data.id?c}</label>
                                </td>
                                <td></td>
                            </tr>

                            <tr>
                                <td style="text-align: right">
                                    <label class="control-label" for="userCode">账户代码:</label>
                                </td>
                                <td style="text-align: left; width: 300px;">
                                    <input type="text"
                                           id="userCode"
                                           name="userCode"
                                           autofocus="autofocus"
                                           class="form-control"
                                           placeholder="账户代码"
                                           aria-describedby="helpUserCode"
                                           value="${page_data.userCode}"/>
                                </td>
                                <td style="text-align: left;">
                                    <span id="helpUserCode" class="help-block">账户代码是必须的.</span>
                                </td>
                            </tr>

                            <tr>
                                <td style="text-align: right">
                                    <label class="control-label" for="userName">用户账号:</label>
                                </td>
                                <td style="text-align: left; width: 300px;">
                                    <input type="text"
                                           id="userName"
                                           name="userName"
                                           class="form-control"
                                           placeholder="用户账号"
                                           aria-describedby="helpUserName"
                                           value="${page_data.userName}"/>
                                </td>
                                <td style="text-align: left;">
                                    <span id="helpUserName" class="help-block">用户账号是必须的.</span>
                                </td>
                            </tr>

                            <tr>
                                <td style="text-align: right">
                                    <label class="control-label" for="password">账号密码:</label>
                                </td>
                                <td style="text-align: left; width: 300px;">
                                    <input type="password"
                                           id="password"
                                           name="password"
                                           class="form-control"
                                           placeholder="账号密码"
                                           aria-describedby="helpPassword"
                                           value="${page_data.password}"/>
                                </td>
                                <td style="text-align: left;">
                                    <span id="helpPassword" class="help-block">账号密码是必须的.</span>
                                </td>
                            </tr>

                            <tr>
                                <td style="text-align: right">
                                    <label class="control-label" for="salt">加把大盐:</label>
                                </td>
                                <td style="text-align: left; width: 300px;">
                                    <input type="text"
                                           id="salt"
                                           name="salt"
                                           class="form-control"
                                           placeholder="加把大盐"
                                           aria-describedby="helpSalt"
                                           value="${page_data.salt}"/>
                                </td>
                                <td style="text-align: left;">
                                    <span id="helpSalt" class="help-block">加把大盐是必须的.</span>
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
                                    <button type="submit" class="btn btn-primary">保存</button>
                                    <a href="/root/sysuser/list" class="btn btn-default">取消</a>
                                </td>
                                <td></td>
                            </tr>

                            </tbody>
                        </table>

                    </form>
                </#if>
                <!--表单结束-->

                <!--正文内容结束-->

            </div>
        </div>
    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>

</body>
</html>