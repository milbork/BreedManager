<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Litters</title>
</head>
<body>
<table>
<c:forEach items="${litter}" var="l">
    <tr>
        <td>Date of Birth:</td>
        <td>${l.dateOfBirth}</td>
    </tr>
    <tr>
        <td>Amount of puppies:</td>
        <td> ${l.amountOfPuppies}</td>
    </tr>
    <tr>
        <td></td>
        <td><a href="/user/litter/edit/${l.id}"><input type="button" value="Edit"></a>

        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <a href="/user/litter/remove/${l.id}">
                <input type="button" value="Delete">
            </a><br><br>
        </td>
    </tr>
</c:forEach>
</table>
<a href="/user"><input type="button" value="Back to user panel"></a>
</body>
</html>
