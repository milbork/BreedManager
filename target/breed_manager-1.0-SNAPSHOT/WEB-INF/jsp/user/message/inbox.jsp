<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inbox</title>
</head>
<body>
<table>
    <c:forEach items="${inbox}" var="i">
        <tr>
            <td>
                Sender:
            </td>
            <td>
                ${i.sender.firstName} ${i.sender.lastName}
            </td>
        </tr>
        <tr>
            <td>
                Message:
            </td>
            <td>
                ${i.message}
            </td>
        </tr>
        <tr>
            <td>Send message:</td>
            <td><a href='<c:url value="/user/message/send/${i.sender.id}"/>'><input type="button" value="Send message"></a>
        </tr>
    </c:forEach>
</table>
</body>
</html>
