<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/admin.css">
    <script src="../../statics/js/jquery.js"></script>
    <script src="../../statics/js/pintuer.js"></script>
</head>
<body>
<form id="form1" action="" method="post">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder"  style="padding-right: 60px">房型列表</strong>
            <div class="button-group">
                <a href="RoomAdd"
                   class="button border-green">新增</a>
            </div>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">房型号</th>
                <th>类型</th>
                <th>价格</th>
                <th>大小</th>
                <th>剩余套数</th>
                <th>位置</th>

                <th>操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="room">
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.type}</td>
                    <td>${room.price}</td>
                    <td>${room.area}</td>
                    <td>${room.total}</td>
                    <td>${room.address}</td>

                    <td>
                        <div class="button-group">
                            <a href="${pageContext.request.contextPath}/delRoom.do?roomId=${room.roomId}"
                               class="button border-red">删除</a>
                        </div>
                        <div class="button-group">
                            <a href="${pageContext.request.contextPath}/RoomUp.do?roomId=${room.roomId}"
                               class="button border-blue"></i>修改</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">

                    <div style="text-align: center;">当前 ${pageInfo.pageNum }页,${pageInfo.pageSize }条/页,总${pageInfo.pages }页,总 ${pageInfo.total }
                        条记录
                    </div>
                    <div class="pagelist">
                        <a href="RoomList.do?page=1&pageSize=1">首页</a>
                        <a href="RoomList.do?page=${pageInfo.pageNum-1}">上一页</a>
                        <a href="RoomList.do?page=${pageInfo.pageNum+1}">下一页</a>
                        <a href="RoomList.do?page=${pageInfo.pages}">尾页</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">


</script>
</body>
</html>