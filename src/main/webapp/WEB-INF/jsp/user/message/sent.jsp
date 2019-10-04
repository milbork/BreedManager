<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: milosz
  Date: 04.10.2019
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sent messages</title>
</head>
<body>
<table>
    <c:forEach items="${sent}" var="i">
        <tr>
            <td>
                Recipient:
            </td>
            <td>
                    ${i.receiver.firstName} ${i.receiver.lastName}
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
            <td><a href='<c:url value="/user/message/send/${i.receiver.id}"/>'><input type="button"
                                                                                      value="Send message"></a>
        </tr>
    </c:forEach>
</table>
</body>
</html>
