<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%
String path=request.getContextPath();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/admin.css">
    <script src="../statics/js/jquery.js"></script>
    <script src="../statics/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
    <div class="body-content">
        <fm:form   modelAttribute="user" method="post" class="form-x" action="${pageContext.request.contextPath}/editPwd.html">
            <div class="form-group">
                <div class="label">
                    <label>管理员帐号：</label>
                </div>
                    <div class="field">
                        <%--<fm:errors path="userName"></fm:errors>--%>
                        <input type="text"  class="input w50"  name="userName" size="50" placeholder="请输入账号" />
                    </div>
                </div>
            <div class="form-group">
                <div class="label">
                    <label >原始密码：</label>
                </div>
                <div class="field">
                    <%--<fm:errors path="userPassword"></fm:errors>--%>
                    <input type="password"  class="input w50"  name="userPassword" size="50" placeholder="请输入原始密码"  />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label >新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="newPassword" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
                </div>
            </div>
            <div class="form-group" style="text-align: center ">
                <div class="label">
                    <label >确认新密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="confirmPwd" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newPassword:两次输入的密码不一致" />
                </div>
            </div>
            <div class="btn">
                    <span class="success" style="color: red;text-align: center">${msg}</span>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
                </div>
            </div>
        </fm:form>
    </div>
</div>
</body>
<style type="text/css">
    .btn{
        text-align: center;
    }
</style>
</html>