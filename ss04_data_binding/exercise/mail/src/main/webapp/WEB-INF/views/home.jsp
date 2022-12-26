<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/22/2022
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Home</h3>
<form:form action="save" method="post" modelAttribute="formMail">
    <fieldset>
        <legend>Settings</legend>
        <table>
            <tr>
                <td><form:label path="language">Languages:</form:label></td>
                <td>
                    <form:select path="language">
                        <form:option value="NONE"> --SELECT--</form:option>
                        <form:options items="${languageList}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td>Show <form:select path="pageSize">
                    <form:options items="${pageList}"></form:options>
                </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="spams">Spams fillter</form:label></td>
                <td><form:checkbox path="spams"/>Enables spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Spams fillter</form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><form:button>Cancel</form:button></td>
                <td><form:button>Update</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>