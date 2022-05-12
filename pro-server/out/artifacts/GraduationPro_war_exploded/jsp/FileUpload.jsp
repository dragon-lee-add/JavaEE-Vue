<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8" />
    <title>资料上传</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/admin.css">
    <script src="../statics/js/jquery.js"></script>
    <script src="../statics/js/pintuer.js"></script>

    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
        var ue = UE.getEditor('container');
    </script>
</head>
<style type="text/css">

</style>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span>资料上传</strong></div>
    <div class="body-content" >
        <form  class="form-x" action="insertFile.do" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>资料主题：</label>
                </div>
                <div class="field">
                    <input name="fileTitle"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <%--<input type="file" name="file"/>--%>
                <script id="container" name="content" type="text/plain"></script>
                    <input type="submit" value="提交">
                </div>
            </div>

        </form>
    </div>

</div>
</body>

</html>