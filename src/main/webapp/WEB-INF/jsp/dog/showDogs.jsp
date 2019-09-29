<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show dogs</title>
</head>
<body>
<form

<table>
    <c:forEach items="${doggo}" var="d">
        <tr>
            <td>Name:</td>
            <td>${d.name}</td>
        </tr>
        <tr>
            <td>Breed:</td>
            <td> ${d.breed}</td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td>${d.dateOfBirth}</td>
        </tr>
        <tr>
            <td></td>
            <td><a href="/user/dog/edit/${d.id}"><input type="button" value="Edit"></a>

            </td>
        </tr>
        <tr>
            <td></td>
            <td><a href="/user/dog/remove/${d.id}"><input type="button" value="Delete"></a><br><br></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/user"><input type="button" value="Back to user panel"></a>
</body>
</html>


