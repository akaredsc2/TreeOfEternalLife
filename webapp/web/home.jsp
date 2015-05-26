<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--Logout--%>
Zdarova, ${username}<br>

<form method="post" action="login_servlet">
    <input type="hidden" name="command" value="logout">
    <input type="submit" value="Logout"/>
</form>

<a href="create.jsp">creation</a>
</body>
</html>