<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/17/2022
  Time: 5:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<form action="/menu" method="post">
  <input type="checkbox" id="vehicle1" name="condiments" value="Lettuce">
  <label for="vehicle1">Lettuce</label><br>
  <input type="checkbox" id="vehicle2" name="condiments" value="Tomato">
  <label for="vehicle2">Tomato</label><br>
  <input type="checkbox" id="vehicle3" name="condiments" value="Mustard">
  <label for="vehicle3">Mustard</label><br>
  <input type="checkbox" id="vehicle4" name="condiments" value="Sprouts">
  <label for="vehicle4">Sprouts</label><br>
  <hr>
  <input type="submit" value="Save">
</form>

<jsp:include page="result.jsp"></jsp:include>
</body>
</html>
