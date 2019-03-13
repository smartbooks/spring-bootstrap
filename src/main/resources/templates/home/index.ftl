<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>管理主页<#include "/_layout/brand.ftl"></title>
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
                    <li class="active">管理主页</li>
                </ol>

                <!--正文内容开始-->

                <#if msg??>msg:${msg}</#if>
                <#if lang??>lang:${lang}</#if>
                
                <!--正文内容结束-->

            </div>
        </div>
    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>

</body>
</html>