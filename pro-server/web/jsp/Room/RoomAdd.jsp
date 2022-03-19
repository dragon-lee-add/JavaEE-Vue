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
    <div class="panel-head"><strong><span class="icon-key"></span>新增房型</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/AddRoom.do">
            <div class="form-group">
                <div class="label">
                    <label>房型价格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="price" size="50" placeholder="如：9000/平"
                           data-validate="required:请输入价格"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>售楼类型：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="type" size="50" placeholder="如：两室一厅"
                           data-validate="required:请输入售楼类型"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>售楼面积：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="area" size="50" placeholder="如：120平"
                           data-validate="required:请输入售楼面积"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>售楼所剩套数：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="total" size="50" placeholder="如：200"
                           data-validate="required:请输入售楼所剩套数"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>位置：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="address" size="50" placeholder="请输入具体的楼房位置"
                           data-validate="required:请输入位置"/>
                </div>
            </div>

            <div class="btn" style="text-align: center">
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">新增</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<style type="text/css">

</style>
</html>