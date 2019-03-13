$(function () {

    //鼠标经过导航栏特效
    $('.navbar-nav li').mouseover(function () {
        $(this).addClass('active').siblings().removeClass('active');
    });

    if ($.support.style == false) {
        alert('你的浏览器已经Out了，赶快升级你的浏览器到Chrome吧！');
        window.open('https://www.google.com/intl/zh-CN/chrome/browser');
    }

    //删除确认操作
    $('.delete').click(function () {
        var markId = $(this).attr('data-id');
        var inputResult = prompt("请输入 " + markId + " 确认删除操作！删除后不可恢复！", "");
        if (markId != undefined && markId != '' && inputResult == markId) {
            return true;
        }
        return false;
    });

    //指标名词解释提示插件
    $('[data-toggle="popover"]').popover()

    //日期选择控件
    $('.datepicker').datepicker({
        format: "yyyy-mm-dd",
        language: "zh-CN",
        todayBtn: "linked",
        Integer: 1,
        todayHighlight: true,
        todayBtn: 'linked',
        autoclose: true
    });

    //当前日期高亮显示按钮
    var globalDate = $('#date').attr('value');
    if (globalDate) {
        var toolButtonList = $('#tool-list>a');
        $.each(toolButtonList, function (k, v) {
            var tempDate = $(v).attr('data-date');
            if (tempDate != undefined && globalDate == tempDate) {
                $(v).addClass("btn-primary");
            } else {
                $(v).removeClass("btn-primary");
            }
        });
    }

    //左侧菜单高亮显示
    var currentBreadcrumb = $('.breadcrumb li[class="active"]').text().trim();
    if (currentBreadcrumb) {
        $('#menu-left a').each(function (k, v) {
            var menuItem = $(v).attr('title');
            if (menuItem && currentBreadcrumb == menuItem) {
                $(v).addClass('active');
            }
        });
    }

    //二级菜单折叠
    $('.menu-head').click(function () {
        var selected = $(this).attr('selected');
        if (selected) {
            $(this).removeClass('glyphicon-minus')
                .addClass('glyphicon-plus')
                .attr('selected', false)
                .parent()
                .siblings('a')
                .fadeOut("slow");
        } else {
            $(this).removeClass('glyphicon-plus')
                .addClass('glyphicon-minus')
                .attr('selected', true)
                .parent()
                .siblings('a')
                .fadeIn("slow");
        }
    });

});
