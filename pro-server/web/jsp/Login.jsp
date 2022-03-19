<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<title>登录界面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/login.css"/>
	<script src="../statics/js/jquery.js"></script>
</head>
	<body>
		<div class="login">
			<div class="content clearfix">
				<div class="content-left">
					<div class="logo">
						<img src="${pageContext.request.contextPath }/statics/images/logoBg.jpg"  alt="" />
						<p>综合售楼系统</p>
					</div>
				</div>
				<div class="shu"></div>
				<div class="content-right">
					<form action="${pageContext.request.contextPath}/login.html"  method="post">
					<div class="login-form">
						<h2>登录/LOGIN</h2>
						<div class="account clearfix">
							<span>账　号：</span>
							<input type="text" name="userName" value="" data-validate="required:请输入账号"/>
						</div>
						<div class="password clearfix">
							<span>密　码：</span>
							<input type="password" name="userPassword" value="" data-validate="required:请输入密码"/>
						</div>
						<div class="subBtn"  style="margin-top: 20px">
							<input type="submit"  style="width: 110px;margin: 0px 20px 0px 80px" value="登录"/>
							<input type="reset"  style="width: 110px"value="重置"/>
						</div>
						<span class="error" style="color: red">${msg}</span>
					</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
