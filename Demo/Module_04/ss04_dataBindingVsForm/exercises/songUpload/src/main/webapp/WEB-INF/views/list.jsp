<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/10/2022
  Time: 3:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/music/add">Add more</a>
<table style="border: 1px solid crimson">
    <tr>
        <th>Name</th>
        <th>Singer</th>
        <th>Kind</th>
        <th>Link</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.singer}</td>
            <td>${item.kind}</td>
            <td>${item.link}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
