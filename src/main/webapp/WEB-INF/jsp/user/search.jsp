<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>




<table>
    <c:forEach items="${search}" var="s">
    <tr>
        <td>Name:</td>
        <td>${s.name}</td>
    </tr>
    <tr>
        <td>Breed:</td>
        <td> ${s.dogsBreed}</td>
    </tr>
    <tr>
        <td>Breeder email:</td>
        <td>${s.breeder.email}</td>
    </tr>

    </c:forEach>

</body>
</html>
