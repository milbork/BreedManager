<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Message</title>
</head>
<body>
<form:form modelAttribute="messages" method="post">
    <form:textarea path="message"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
