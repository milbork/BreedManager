<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your breeding</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="breeding">
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Dogs Breed:</td>
            <td><form:input path="dogsBreed"/><form:errors path="dogsBreed" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Available litter:</td>
            <td>
                Yes: <form:checkbox path="available" value="yes"/>
                No: <form:checkbox path="available" value="no"/>
            </td>
            <td><form:errors path="available" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Save"></td>
        </tr>
    </form:form>
</table>
<br>

<a href='<c:url value="/user"/>'><input type="button" value="Cancel"></a>
</body>
</html>
