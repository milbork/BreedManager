<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Breeding</title>
</head>
<body>
<table>

    <tr>
        <td>Name:</td>
        <td>${breeding.name}</td>
    </tr>
    <tr>
        <td>Breed:</td>
        <td> ${breeding.dogsBreed}</td>
    </tr>
    <tr>
        <td>Available litters:</td>
        <td> ${breeding.available}</td>
    </tr>
    <tr>
        <td>:</td>
        <td> ${breeding.available}</td>
    </tr>
    <tr>
        <td><a href='<c:url value="/user/breeding/edit"/>'><input type="button" value="Edit"></a></td>
    </tr>
</table>
</body>
</html>
