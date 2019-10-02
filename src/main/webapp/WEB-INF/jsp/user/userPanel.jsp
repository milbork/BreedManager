<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

</table>
<br><br>
<a href='<c:url value= "/user/edit"/>'><input type="button" value="Edit your profile"></a>
<br><br>
<a href='<c:url value= "/user/dog/add"/>'><input type="button" value="Add your dog"></a>
<br><br>
<a href='<c:url value= "/user/dog/show"/>'><input type="button" value="Show list of your dogs"></a>
<br><br>

<sec:authorize access="hasRole('BREEDER')">
    <a href='<c:url value="/user/litter/add"/>'><input type="button" value="Add litter"></a>
    <br><br>
    <a href='<c:url value="/user/litter/show"/>'><input type="button" value="Show list of your litters"></a>
    <br><br>
    <a href='<c:url value="/user/breeding/add"/>'><input type="button" value="add breeding"></a>
    <br><br>
    <a href='<c:url value= "/user/breeding/show"/>'><input type="button" value="show breeding"></a>


    <br><br>

</sec:authorize>

<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>