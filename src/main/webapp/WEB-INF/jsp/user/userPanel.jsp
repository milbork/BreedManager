<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>
Hello ${username}
<br><br>
<a href="/user/editUser">Edit your profile</a>
<br><br>
<a href="/user/addDog">Add your dog</a>
<br><br>

<a href="/user/showDogs">Show list of your dogs</a>
<br><br>

<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
