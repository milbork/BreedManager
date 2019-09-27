<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your profile</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="user">
        <tr>
            <td>Name:</td>
            <td><form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Function:</td>
            <td>Owner:
                <form:radiobutton path="function" value="owner"/>
            </td>
            <td>Breeder:
                <form:radiobutton path="function" value="breeder"/>

            </td>
            <td><form:errors path="function" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Breeding name:</td>
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
<br>

<a href="/user"><input type="button" value="Cancel"></a>
</body>
</html>
