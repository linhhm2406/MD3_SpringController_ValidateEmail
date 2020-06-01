<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/validate">
    <table>
        <tr>
            <td>Input Email:</td>
            <td><input type="text" name="inputEmail"></td>
        </tr>
        <tr>
            <td>Result : </td>
            <td><input type="text" value="${result}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Check"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
