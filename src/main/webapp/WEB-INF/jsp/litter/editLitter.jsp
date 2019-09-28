<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Litter</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="litter">
        <tr>
            <td>Breed:</td>
            <td><form:input path="dogsBreed"/></td>
            <td><form:errors path="dogsBreed" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><form:input path="dateOfBirth"/></td>
            <td><form:errors path="dateOfBirth" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Amount of puppies:</td>
            <td><form:input path="amountOfPuppies"/></td>
            <td><form:errors path="amountOfPuppies" cssClass="error"/></td>
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
