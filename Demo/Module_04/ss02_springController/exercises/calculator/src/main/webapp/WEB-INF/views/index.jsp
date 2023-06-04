<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>CALCULTOR</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="number" name = "number01">
    <input type="number" name = "number02">x
    <select name="operator" >
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="output">
</form>
    <p >Result: ${result}</p>
</body>
</html>