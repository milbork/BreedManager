<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>

<table>
    <form:form method="post" modelAttribute="search">
        <tr>
            <td>Dogs breed:</td>
            <td><form:input path="dogsBreed"/></td>
            <td><form:errors path="dogsBreed" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Available:</td>
            <td><form:checkbox path="available" value="yes"/></td>
            <td><form:errors path="available" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Search"></td>
        </tr>
    </form:form>
</table>
</body>
</html>
