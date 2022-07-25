<%--
  Created by IntelliJ IDEA.
  User: nikitasudaev
  Date: 25.07.22
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login</title>
        <link rel="stylesheet" href="resources/css/loginStyle.css">
    </head>
    <body>
        <h1 class="logo">Welcome to JAVA login</h1>
        <div class="login_panel">
            <form action="login" method="post">
                <h2>Login</h2>
                <input class="inputs" type="text" name="login">
                <h2>Pass</h2>
                <input class="inputs" type="password" name="password">
                <br><br><br>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>