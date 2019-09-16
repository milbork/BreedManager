<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
</table>
<br>
<a href="/user"><input type="button" value="Cancel"></a>
</body>
</html>
