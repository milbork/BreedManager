<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <style>

        #container {
            width: 1366px;
            margin-left: auto;
            margin-right: auto;
        }

        #right {
            width: 683px;
            float: left;
            min-height: 700px;


        }

        #left {
            width: 683px;
            float: left;
            min-height: 700px;
            background: lightgray;
        }

        #content {
            margin: 15px;
        }

        #top {
            min-height: 100px;
            margin-left: 140px;

        }

        #mid {
            min-height: 500px;
            text-align: center;
        }

        #bottom {
            min-height: 100px;
        }

        #footer {
            clear: both;
            height: 40px;
            background-color: black;
        }

        .option {
            width: 220px;
            float: left;
        }

        .button {
            width: 100px;
            float: left;
        }


    </style>
</head>
<body>

<div id="container">

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
        <div id="top">
            <form method="post">
                <div class="option"><label><input type="text" name="username" placeholder="Email" size="18"/></label>
                </div>
                <div class="option"><label><input type="password" name="password" placeholder="Password"
                                                  size="18"/></label></div>
                <div class="button"><input type="submit" value="Sign In"/></div>
                <div style="clear: both"></div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
        <div id="mid">
            <img src="${pageContext.request.contextPath}/img/paw.png" width="50" height="50"><br>
            <h3>Find yourself a perfect friend</h3>
            <br><br>
            <h4>Join us today!</h4>
            <div>
                <a href="${pageContext.request.contextPath}/registration">
                    <input type="button" value="Sign up">
                </a>
            </div>

        </div>
        <div id="bottom"></div>

    </div>
    <div id="footer">
    </div>

</div>


</body>
</html>


