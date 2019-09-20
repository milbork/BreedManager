<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Panel</title>
</head>
<body>
<br><br>
Hello ${username}<br>
${function}
<br><br>
<a href="/user/editUser"><input type="button" value="Edit your profile"></a>
<br><br>
<a href="/user/addDog"><input type="button" value="Add your dog"></a>
<br><br>
<a href="/user/showDogs"><input type="button" value="Show list of your dogs"></a>
<br><br>

<sec:authorize access="hasRole('BREEDER')">
    <a href="/user/addLitter"><input type="button" value="Add litter"></a>
    <br><br>
    <a href="/user/litters"><input type="button" value="Show list of your litters"></a>
    <br><br>
</sec:authorize>

<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
