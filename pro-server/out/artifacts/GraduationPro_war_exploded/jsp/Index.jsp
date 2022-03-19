<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>售楼系统管理中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/admin.css">
    <script src="../statics/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">

<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${pageContext.request.contextPath }/statics/images/logo.png" class="radius-circle rotate-hover" height="50"/>后台管理中心</h1>
    </div>
    <div class="head-l">
        <form action="${pageContext.request.contextPath}/loginOut.html" method="post">
            <a class="button button-little bg-green" href="Index" target="_blank"><span class="icon-home"></span>后台首页</a>
            &nbsp;&nbsp;
            <a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a>
            &nbsp;&nbsp;
            <input type="submit" style="width: 120px;"
                   class="button button-little bg-yellow" value="退出登录">
        </form>
    </div>
</div>

<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>基本设置</h2>
    <ul style="display:block">
        <li><a href="RoomList.do" target="right"><span class="icon-caret-right"></span>房型管理</a></li>
        <li><a href="ClientList.do" target="right"><span class="icon-caret-right"></span>客户管理</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>高级设置</h2>
    <ul>
        <li><a href="EditPwd" target="right"><span class="icon-caret-right"></span>修改管理员密码</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="Message" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="Message" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>