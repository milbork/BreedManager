<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 13.09.2019
  Time: 00:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add dog</title>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="dog">
    <tr>
        <td>Name:</td>
        <td><form:input path="name"/><form:errors path="name" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Breed:</td>
        <td><form:input path="breed"/><form:errors path="breed" cssClass="error"/></td>
    </tr>
    <tr>
        <td>Date of birth:</td>
        <td><form:input path="dateOfBirth"/><form:errors path="dateOfBirth" cssClass="error"/></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="Save"></td>
    </tr>
    </form:form>
</body>
</html>
