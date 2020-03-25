<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create new user</title>
    <style>

        #container {
            width: 1366px;
            min-height: 768px;
            margin-left: auto;
            margin-right: auto;
        }

        #header {
            color: #002747;
            height: 50px;
        }

        #logo {
            float: left;
            width: 822px;
        }

        #content {
            width: 684px;
            background-color: #002747;
            color: white;
            min-height: 500px;
            text-align: center;
            margin: auto;
        }

        #top {
            margin: auto;
            padding-top: 50px;
        }

        #mid {
            padding-left: 175px;
        }

        .blank {
            height: 100px;
        }

        #footer {
            clear: both;
            height: 50px;
            background-color: #324c60;
            color: white;
        }

        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>

<div id="container">
    <div id="header">
        <div id="logo">
            <img src="${pageContext.request.contextPath}/img/logotype.png" height="50">
        </div>
    </div>
    <div class="blank"><p></p></div>
    <div id="content">
        <div id="top"><img src="${pageContext.request.contextPath}/img/createAccount.png"></div>
        <div id="mid">
            <form:errors path="*" cssClass="error"/>
            <table>
                <form:form method="post" modelAttribute="user">
                    <tr>
                        <td style="color: white">Name:</td>
                        <td><form:input path="firstName"/></td>
                        <td><form:errors path="firstName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color: white">Surname:</td>
                        <td><form:input path="lastName"/></td>
                        <td><form:errors path="lastName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color: white"> Function:</td>
                        <td style="color: white">
                            Owner: <form:radiobutton path="function" value="owner"/>
                            Breeder: <form:radiobutton path="function" value="breeder"/>
                        </td>
                        <td><form:errors path="function" cssClass="error"/></td>

                    </tr>
                    <tr>
                        <td style="color: white">E-mail:</td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color: white">Password:</td>
                        <td><form:input path="password"/></td>
                        <td><form:errors path="password" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Save"></td>
                    </tr>
                </form:form>
            </table>

        </div>
    </div>
    <div class="blank"><p></p></div>
    <div id="footer">

    </div>
</div>

</body>
</html>
