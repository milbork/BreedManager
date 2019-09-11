<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 11.09.2019
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add breeder</title>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="breeder">
        <tr>
            <td>Name:</td>
            <td><form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Breeding Name:</td>
            <td><form:input path="breedingName"/><form:errors path="breedingName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><form:input path="email"/><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password"/><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </form:form>
</table>
</body>
</html>
