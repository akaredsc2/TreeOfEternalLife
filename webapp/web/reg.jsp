<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="post" action="registration">
    <input type="text" name="username" placeholder="Username" required/>
    <input type="password" name="password1" placeholder="Password" required/>
    <input type="password" name="password2" placeholder="Repeat password" required/>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
