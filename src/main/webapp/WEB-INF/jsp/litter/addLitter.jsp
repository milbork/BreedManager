<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Litter</title>
</head>
<body>
<table>
    <form:form method="post" modelAttribute="litter">
        <tr>
            <td>Date Of Birth:</td>
            <td><form:input path="dateOfBirth"/><form:errors path="dateOfBirth" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Amount Of Puppies:</td>
            <td><form:input path="amountOfPuppies"/><form:errors path="amountOfPuppies" cssClass="error"/></td>
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
