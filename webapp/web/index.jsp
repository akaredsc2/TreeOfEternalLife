<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
Hello! Please log in.
<form method="post" action="login_servlet">
    <input type="hidden" name="command" value="login">
    <input type="text" name="username" placeholder="Login">
    <br>
    <input type="password" name="password" placeholder="Password">
    <br>
    <input type="submit" value="Log in">
</form>
</body>
</html>