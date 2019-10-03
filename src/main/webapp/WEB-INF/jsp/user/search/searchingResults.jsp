<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searching Results</title>
</head>
<body>

<table>
    <c:forEach items="${find}" var="s">

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
</table>
<a href='<c:url value="/user"/>'><input type="button" value="Back"></a>
</body>
</html>
