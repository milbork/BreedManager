<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Breed Manager</title>
    <style>


        #container {
            width: 1366px;
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

        #left {
            width: 683px;
            float: left;
            min-height: 716px;
            background-color: #002747;
            color: white;
        }

        #content {
            margin: 30px;
        }

        #right {
            width: 683px;
            float: left;
            min-height: 700px;
            background-color: white;
            color: #2f3131;
        }

        #top {
            min-height: 100px;
        }

        #mid {
            height: 500px;
            width: 433px;
            text-align: center;
            background-color: #002747;
            color: white;
            float: left;
        }

        #bottom {
            min-height: 100px;
            clear: both;

        }

        #footer {
            clear: both;
            height: 50px;
            background-color: #324c60;
            color: white;
        }

        .option {
            width: 220px;
            float: left;
        }

        .button {
            width: 100px;
            float: left;
        }

        .side {
            width: 125px;
            height: 500px;
            float: left;
        }


    </style>
</head>
<body>

<div id="container">
    <div id="header">
        <div id="logo">
            <img src="${pageContext.request.contextPath}/img/logotype.png" height="50">
        </div>
        <form method="post">
            <div class="option"><label><input type="text" name="username" placeholder="Email" size="18"/></label>
            </div>
            <div class="option"><label><input type="password" name="password" placeholder="Password"
                                              size="18"/></label></div>
            <div class="button"><input type="submit" value="Sign In"/></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <div style="clear: both"></div>
    </div>
    <div id="left">
        <div id="content">
            <p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. In dictum mauris id imperdiet blandit. Nam
                volutpat
                finibus vestibulum. Sed luctus, risus ornare pharetra placerat, lorem purus congue leo, sed scelerisque
                libero ipsum rhoncus eros. Nullam aliquet feugiat libero, non imperdiet magna malesuada eu. Vivamus est
                ipsum, tempor eu nibh eget, consectetur pretium sapien. Donec lobortis mi ac quam accumsan suscipit.
                Morbi
                sodales ante risus, ut egestas sem finibus vulputate. In vel justo ante. Cras elit erat, volutpat at
                semper
                sed, rhoncus a lorem.
            </p>
            <p>

                Aenean volutpat justo a est gravida, quis iaculis lorem mattis. Aenean rhoncus sapien at feugiat
                ultrices.
                Donec porta risus non nisi placerat, in blandit quam sollicitudin. Sed quis orci quam. Nunc ut ex mi.
                Morbi
                euismod neque nunc, eu tincidunt mi tincidunt eget. Aliquam vestibulum eu erat at consequat.
            </p>
        </div>
    </div>


    <div id="right">
        <div id="top"><p></p></div>
        <div class="side"><p></p></div>
        <div id="mid">
            <img src="${pageContext.request.contextPath}/img/logo.png" width="400"><br>

            <h3>Join us today!</h3>

            <a href="${pageContext.request.contextPath}/registration">
                <input type="button" value="Sign up">
            </a>


        </div>
        <div class="side"><p></p></div>
        <div id="bottom"><p></p></div>

    </div>
    <div id="footer">
    </div>

</div>


</body>
</html>


