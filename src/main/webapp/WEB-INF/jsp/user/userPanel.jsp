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
<a href="/user/edit"><input type="button" value="Edit your profile"></a>
<br><br>
<a href="/user/dog/add"><input type="button" value="Add your dog"></a>
<br><br>
<a href="/user/dog/show"><input type="button" value="Show list of your dogs"></a>
<br><br>

<sec:authorize access="hasRole('BREEDER')">
    <a href="/user/litter/add"><input type="button" value="Add litter"></a>
    <br><br>
    <a href="/user/litter/show"><input type="button" value="Show list of your litters"></a>
    <br><br>
    <a href="/user/breeding/add"><input type="button" value="breeding"></a>
    <br><br>
    <a href="/user/breeding/show"><input type="button" value="breeding"></a>
    <br><br>

</sec:authorize>

<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
