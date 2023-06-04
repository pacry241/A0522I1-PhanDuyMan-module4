<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/10/2022
  Time: 7:52 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Convert</title>
</head>
<body>
<form action="/convert" method="post">
    <input type="number" name="tienTe" value="tienTe"> USD<br/>
    <input type="number" name="tiGia" value="tiGia"> Tỉ giá<br/>
    <input type="submit" value="count"><br/>
    Kết quả là : ${showConvert} VND
</form>
</body>
</html>
