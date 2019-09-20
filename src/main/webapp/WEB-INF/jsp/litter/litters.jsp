<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 18.09.2019
  Time: 01:06
  To change this template use File | Settings | File Templates.

      <tr>
        <td></td>
        <td><a href="/user/editDog/${d.id}"><input type="button" value="Edit"></a>

        </td>
    </tr>
    <tr>
        <td></td>
        <td><a href="/user/removeDog/${d.id}"><input type="button" value="Delete"></a><br><br></td>
    </tr>
--%>
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
        <td><a href="/user/editLitter/${l.id}"><input type="button" value="Edit"></a>

        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <a href="/user/removeLitter/${l.id}">
                <input type="button" value="Delete">
            </a><br><br>
        </td>
    </tr>
</c:forEach>
</table>
<a href="/user"><input type="button" value="Back to user panel"></a>
</body>
</html>
