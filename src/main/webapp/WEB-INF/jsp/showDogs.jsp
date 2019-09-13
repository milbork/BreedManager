<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 13.09.2019
  Time: 02:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show dogs</title>
</head>
<body>
<c:forEach items="${doggo}" var="d">
    ${d}<br>
</c:forEach>
<br>
<a href="/user">Back to user panel</a>
</body>
</html>
