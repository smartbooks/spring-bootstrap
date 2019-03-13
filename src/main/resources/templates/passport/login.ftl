<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>用户登录<#include "/_layout/brand.ftl"></title>
    <#include "/_layout/head.ftl" parse=false encoding="UTF-8">
</head>
<body
        style="background-color: #273444; background-image: url(/static/img/index_bg.png); padding-bottom: 0px;">

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand" style="padding: 0px;">
                <svg
                        aria-hidden="true" class="icon icon-sentry-logo" role="icon"
                        width="160" height="50" viewBox="0 0 72 16" version="1.1">
                    <path d="M44.54,10.27L39.19,3.34H37.85v9.27h1.34V5.49l5.49,7.12h1.19V3.34H44.54v6.93ZM31.07,8.55h4.78V7.36H31.07V4.59h5.4V3.34H29.73v9.27h6.83V11.41H31.07V8.55ZM25.48,7.36c-1.86-.43-2.39-0.81-2.39-1.67s0.67-1.29,1.72-1.29a4.46,4.46,0,0,1,2.58.91l0.72-1a5.18,5.18,0,0,0-3.3-1.1c-1.81,0-3.1,1.1-3.1,2.63s1.1,2.24,3.06,2.72c1.77,0.38,2.29.76,2.29,1.62s-0.72,1.39-1.86,1.39a4.56,4.56,0,0,1-3-1.19l-0.81,1a5.75,5.75,0,0,0,3.77,1.39c2,0,3.25-1.05,3.25-2.72C28.44,8.64,27.58,7.88,25.48,7.36Zm44.94-4L67.65,7.69,64.88,3.34H63.26l3.68,5.59v3.68h1.39V8.88L72,3.34H70.42ZM47,4.59h3v8h1.39v-8h3V3.34H47V4.59ZM60.87,9A2.72,2.72,0,0,0,63,6.21c0-1.77-1.29-2.87-3.39-2.87H55.52v9.27h1.39V9.27h2.34l2.34,3.34h1.62L60.68,9.07Zm-4-.91V4.54h2.58c1.34,0,2.15.62,2.15,1.77a1.84,1.84,0,0,1-2.1,1.77H56.91ZM10.38,0.81A1.57,1.57,0,0,0,8.95,0,1.57,1.57,0,0,0,7.52.81L5.18,4.87,5.8,5.21A11.44,11.44,0,0,1,10,9.41a11.35,11.35,0,0,1,1.53,5.06H9.86a10.25,10.25,0,0,0-1.29-4.25A9.47,9.47,0,0,0,4.94,6.59L4.32,6.26l-2.2,3.82,0.62,0.33a5.65,5.65,0,0,1,2.72,4.06H1.69a0.3,0.3,0,0,1-.24-0.14,0.29,0.29,0,0,1,0-.29L2.5,12.23a3.67,3.67,0,0,0-1.19-.67L0.26,13.37a1.8,1.8,0,0,0,0,1.77A1.57,1.57,0,0,0,1.64,16H6.85V15.28a7.25,7.25,0,0,0-.91-3.44A6.89,6.89,0,0,0,4,9.7L4.84,8.26A8.27,8.27,0,0,1,7.37,11a8.35,8.35,0,0,1,1.15,4.25V16h4.39V15.28a12.79,12.79,0,0,0-1.72-6.45A12.48,12.48,0,0,0,7,4.49L8.71,1.58a0.33,0.33,0,0,1,.24-0.14,0.23,0.23,0,0,1,.24.14L16.5,14.19a0.29,0.29,0,0,1-.24.43H14.54a13.4,13.4,0,0,1,0,1.39h1.72a1.57,1.57,0,0,0,1.43-.81,1.73,1.73,0,0,0,0-1.67Z"></path>
                </svg>
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav" style="float: right;">
                <li><a href="/help/helpcenter/index">帮助中心</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container body-content"
     style="background: none; min-height: 480px;">

    <div class="row">

        <div class="col-md-4">
            <img src="/static/img/login-welcome.png" style="opacity: 0.9;"/>
        </div>
        <div class="col-md-3 col-md-offset-5" style="background-color: #FFF;">

            <div class="form-group" id="home-switcher-wrap">
                <ul class="login-switcher">
                    <li class='active' target="home-login-form"><a>登录</a></li>
                    <li target="home-signup-form"><a>注册</a></li>
                </ul>
            </div>

            <!--登录表单-->
            <form id="home-login-form"
                  action="/passport/login"
                  class="form-horizontal"
                  method="post"
                  style='max-width: 350px; padding: 15px; margin: 0 auto; display:block;'>

                <#if entity??>

                    <@spring.bind "entity.userName" />
                    <div class="form-group <#if (spring.status.errorMessages?size>0)>has-error</#if>">
                        <div class="col-md-12">

                            <input class="form-control input-lg"
                                   name="userName"
                                   type="text"
                                   value="${entity.userName!}"
                                   placeholder="登录账号"/>

                            <p class="help-block"><@spring.showErrors "<br>"/></p>

                        </div>
                    </div>

                    <@spring.bind "entity.password" />
                    <div class="form-group <#if (spring.status.errorMessages?size>0)>has-error</#if>">
                        <div class="col-md-12">

                            <input class="form-control input-lg"
                                   name="password"
                                   type="password"
                                   value="${entity.password!}"
                                   placeholder="登录密码"/>

                            <p class="help-block"><@spring.showErrors "<br>"/></p>

                        </div>
                    </div>

                </#if>

                <div class="form-group">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-lg btn-block btn-primary">登录</button>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <a href="#" onclick="javascript:return false;" target="_blank">忘记密码?</a>
                    </div>
                </div>

                <#if page_error??>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="alert alert-danger">${page_error}</div>
                        </div>
                    </div>
                </#if>

            </form>

            <!--注册表单-->
            <form id="home-signup-form" action="#"
                  class="form-horizontal" method="post"
                  style='max-width: 350px; padding: 15px; margin: 0 auto; display:none;'>
                <div class="form-group">
                    <div class="col-md-12">
                        <input class="form-control input-lg" name="username"
                               placeholder="登录账号" type="text" maxlength="11" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <input class="form-control input-lg" name="password"
                               placeholder="登录密码" type="password" maxlength="20" disabled/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-12">
                        <input class="form-control input-lg" name="confirmPassword"
                               placeholder="登录密码" type="password" maxlength="20" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-lg btn-block btn-primary" disabled>免费创建账号</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">

                    </div>
                </div>
            </form>

        </div>

    </div>
</div>

<div class="row haobtc-showcase-number"
     style="position: fixed; bottom: 0; width: 100%; display:block;">
    <div class="col-md-4">
        <p class="pull-right">
            <span id="showcase-number-profit">111</span>用户/日<span
                    class="hidden-xs">「当日新增」</span>
        </p>
    </div>
    <div class="col-md-4">
        <p class="text-center">
            <span id="showcase-number-mining">111,355</span>人/日<span
                    class="hidden-xs">「活跃用户」</span>
        </p>
    </div>
    <div class="col-md-4">
        <p class="pull-left">
            <span id="showcase-number-dividends">3,123</span>用户<span
                    class="hidden-xs">「用户总量」</span>
        </p>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#helpcenter-switcher-wrap li').click(function () {
            var target = $(this).attr('target');

            $(this).addClass('active').siblings().removeClass('active');

            if (target == 'helpcenter-login-form') {
                $('#helpcenter-login-form').show();
                $('#helpcenter-signup-form').hide();
            } else {
                $('#helpcenter-login-form').hide();
                $('#helpcenter-signup-form').show();
            }

            return false;
        });

        $('.alert').fadeOut(9000);

        $("input[name='username']").val($.cookie('username'));
    });
</script>

</body>
</html>