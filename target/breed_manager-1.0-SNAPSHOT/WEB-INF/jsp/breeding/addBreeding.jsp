<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Breeding</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<form:errors path="*" cssClass="error"/>
<table>
    <form:form method="post" modelAttribute="breeding">
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Dogs Breed:</td>
            <td><form:input path="dogsBreed"/></td>
            <td><form:errors path="dogsBreed" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Available litter? </td>
            <td><form:checkbox path="available" value="yes"/></td>
            <td><form:checkbox path="available" value="no"/></td>
            <td><form:errors path="available" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </form:form>
</table>

</body>
</html>
