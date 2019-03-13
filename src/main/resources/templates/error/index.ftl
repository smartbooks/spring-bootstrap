<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>异常提示<#include "/_layout/brand.ftl"></title>
    <#include "/_layout/head.ftl" parse=false encoding="UTF-8">
</head>
<body>

<#include "/_layout/nav.ftl" parse=false encoding="UTF-8">

<div class="container body-content">

    <div style="min-height: 720px;">
        <div class="row">

            <div class="col-md-12">

                <!--正文内容开始-->

                <#if page_error??>

                    <div class="alert alert-danger">${page_error}</div>

                </#if>

                <!--正文内容结束-->

            </div>
        </div>
    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>

</body>
</html>