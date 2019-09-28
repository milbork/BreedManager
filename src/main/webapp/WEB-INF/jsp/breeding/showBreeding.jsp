<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Breeding</title>
</head>
<body>
<table>
    <c:forEach items="${breeding}" var="b">
        <tr>
            <td>Name:</td>
            <td>${b.name}</td>
        </tr>
        <tr>
            <td>Breed:</td>
            <td> ${b.dogsBreed}</td>
        </tr>
        <tr>

        </tr>
        <tr>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
