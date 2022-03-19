<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/admin.css">
    <script src="../statics/js/jquery.js"></script>
    <script src="../statics/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span>修改客户信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/upClientById.do">
            <%--传递隐藏域--%>
            <input type="hidden" name="id" value="${client.id}">
            <div class="form-group">
                <div class="label">
                    <label>购买房型号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="roomId" size="50" placeholder="请输入购买房型号" value="${client.roomId}"
                           data-validate="required:请输入购买房型号"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="name" size="50" placeholder="请输入姓名" value="${client.name}"
                           data-validate="required:请输入姓名"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="sex" size="50" placeholder="请输入性别" value="${client.sex}"
                           data-validate="required:请输入性别"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>年龄：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="age" size="50" placeholder="请输入年龄" value="${client.age}"
                           data-validate="required:请输入年龄"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>手机号码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="phone" size="50" placeholder="请输入具体手机号码" value="${client.phone}"
                           data-validate="required:请输入手机号码"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>家庭住址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="addr" size="50" placeholder="请输入具体家庭住址" value="${client.addr}"
                           data-validate="required:请输入家庭住址"/>
                </div>
            </div>
            <div class="btn" style="text-align: center">
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<style type="text/css">

</style>
</html>