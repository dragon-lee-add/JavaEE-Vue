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
            <strong class="icon-reorder" style="padding-right: 60px">客户列表</strong>
            <div class="button-group" >
                <a href="ClientAdd"
                   class="button border-green">添加</a>
            </div>
            <div class="button-group">
                <a href="downExcel"
                   class="button border-green">Excel导出</a>
            </div>
            <%--<div class="button-group">--%>
                <%--<a href="ExcelImport"--%>
                   <%--class="button border-green">--%>
                    <%--Excel导入--%>
                <%--</a>--%>
            <%--</div>--%>
        </div>
        <table class="table table-hover text-center">
            <tr>

                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>家庭住址</th>
                <th width="120">购买房型号</th>
                <th>购买类型</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="client">
                <tr>

                    <td>${client.name}</td>
                    <td>${client.sex}</td>
                    <td>${client.age}</td>
                    <td>${client.phone}</td>
                    <td>${client.addr}</td>
                    <td>${client.roomId}</td>
                    <td>${client.room.type}</td>
                    <td>
                        <div class="button-group">
                            <a href="${pageContext.request.contextPath}/ClientUp.do?id=${client.id}"
                               class="button border-blue"></i>修改</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">

                    <div style="text-align: center;">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }页,总 ${pageInfo.total }
                        条记录
                    </div>
                    <div class="pagelist">
                        <a href="${pageContext.request.contextPath}/ClientList.do?page=1">首页</a>
                        <a href="${pageContext.request.contextPath}/ClientList.do?page=${pageInfo.pageNum-1}">上一页</a>
                        <a href="${pageContext.request.contextPath}/ClientList.do?page=${pageInfo.pageNum+1}">下一页</a>
                        <a href="${pageContext.request.contextPath}/ClientList.do?page=${pageInfo.pages}">尾页</a>
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