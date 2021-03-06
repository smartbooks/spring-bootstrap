<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="zn_CN">
<head>
    <title>注销用户<#include "/_layout/brand.ftl"></title>
    <#include "/_layout/head.ftl" parse=false encoding="UTF-8">
</head>
<body>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/member/index" class="navbar-brand" style="padding: 0px;">
                <svg aria-hidden="true" class="icon icon-sentry-logo" role="icon" width="160" height="50"
                     viewBox="0 0 72 16" version="1.1">
                    <path d="M44.54,10.27L39.19,3.34H37.85v9.27h1.34V5.49l5.49,7.12h1.19V3.34H44.54v6.93ZM31.07,8.55h4.78V7.36H31.07V4.59h5.4V3.34H29.73v9.27h6.83V11.41H31.07V8.55ZM25.48,7.36c-1.86-.43-2.39-0.81-2.39-1.67s0.67-1.29,1.72-1.29a4.46,4.46,0,0,1,2.58.91l0.72-1a5.18,5.18,0,0,0-3.3-1.1c-1.81,0-3.1,1.1-3.1,2.63s1.1,2.24,3.06,2.72c1.77,0.38,2.29.76,2.29,1.62s-0.72,1.39-1.86,1.39a4.56,4.56,0,0,1-3-1.19l-0.81,1a5.75,5.75,0,0,0,3.77,1.39c2,0,3.25-1.05,3.25-2.72C28.44,8.64,27.58,7.88,25.48,7.36Zm44.94-4L67.65,7.69,64.88,3.34H63.26l3.68,5.59v3.68h1.39V8.88L72,3.34H70.42ZM47,4.59h3v8h1.39v-8h3V3.34H47V4.59ZM60.87,9A2.72,2.72,0,0,0,63,6.21c0-1.77-1.29-2.87-3.39-2.87H55.52v9.27h1.39V9.27h2.34l2.34,3.34h1.62L60.68,9.07Zm-4-.91V4.54h2.58c1.34,0,2.15.62,2.15,1.77a1.84,1.84,0,0,1-2.1,1.77H56.91ZM10.38,0.81A1.57,1.57,0,0,0,8.95,0,1.57,1.57,0,0,0,7.52.81L5.18,4.87,5.8,5.21A11.44,11.44,0,0,1,10,9.41a11.35,11.35,0,0,1,1.53,5.06H9.86a10.25,10.25,0,0,0-1.29-4.25A9.47,9.47,0,0,0,4.94,6.59L4.32,6.26l-2.2,3.82,0.62,0.33a5.65,5.65,0,0,1,2.72,4.06H1.69a0.3,0.3,0,0,1-.24-0.14,0.29,0.29,0,0,1,0-.29L2.5,12.23a3.67,3.67,0,0,0-1.19-.67L0.26,13.37a1.8,1.8,0,0,0,0,1.77A1.57,1.57,0,0,0,1.64,16H6.85V15.28a7.25,7.25,0,0,0-.91-3.44A6.89,6.89,0,0,0,4,9.7L4.84,8.26A8.27,8.27,0,0,1,7.37,11a8.35,8.35,0,0,1,1.15,4.25V16h4.39V15.28a12.79,12.79,0,0,0-1.72-6.45A12.48,12.48,0,0,0,7,4.49L8.71,1.58a0.33,0.33,0,0,1,.24-0.14,0.23,0.23,0,0,1,.24.14L16.5,14.19a0.29,0.29,0,0,1-.24.43H14.54a13.4,13.4,0,0,1,0,1.39h1.72a1.57,1.57,0,0,0,1.43-.81,1.73,1.73,0,0,0,0-1.67Z"></path>
                </svg>
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <!-- <li><a href="#">test</a></li> -->
            </ul>
        </div>
    </div>
</div>

<div class="container body-content">

    <div style="min-height: 720px;">


        <div class="row" style="padding-top:150px;">

            <form action="#" class="form-horizontal" style="max-width: 350px; padding: 15px; margin: 0 auto;">
                <div class="form-group">
                    <div class="col-md-12">
                        <h1>您已经注销登录！</h1>
                        <p><b id="timerNumber" style="color:red; font-size:600%; vertical-align: middle;">6</b>
                            秒钟后跳转到首页，单击<a href="/">返回首页</a></p>
                    </div>
                </div>
            </form>

            <script type="text/javascript">

                var timerNumber = document.getElementById('timerNumber');
                var timerNumberMin = 0;
                var timerNumberCurrent = 6;

                setInterval(function () {

                    timerNumberCurrent -= 1;
                    if (timerNumberCurrent == timerNumberMin || timerNumberCurrent < timerNumberMin) {
                        window.location = '/';
                    } else {
                        timerNumber.innerHTML = '' + timerNumberCurrent;
                    }

                }, 1000);


            </script>

        </div>


    </div>

    <#include "/_layout/copyright.ftl" parse=false encoding="UTF-8">

</div>
</body>
</html>
