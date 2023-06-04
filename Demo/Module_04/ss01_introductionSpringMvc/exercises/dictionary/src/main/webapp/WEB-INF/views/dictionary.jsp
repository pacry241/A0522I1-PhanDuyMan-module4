<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/10/2022
  Time: 8:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/dictionary/search" method="get">
    <input type="text" name="search"><br/>
    <input type="submit" value="Search">
    <h2>RESULT = ${result}</h2>
</form>
</body>
</html>
