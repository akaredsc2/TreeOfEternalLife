<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--Logout--%>
<c:if test="${!empty sessionScope.username}">
    <form method="post" action="login_servlet">
        Hello, ${username}!<br>
        <input type="hidden" name="command" value="logout">
        <input type="submit" value="Logout"/>
    </form>
    <br/>

    <table border="1">
        <c:forEach var="entry" items="${tree}">
            <tr><td>${entry.value}</td></tr>
        </c:forEach>
    </tablebo>
</c:if>

<%--Place for rendered tree--%>
<a href="<c:url value="/manage.jsp"/>">Manage tree</a>
<a href="<c:url value="/home.jsp"/>">Home</a>
</body>
</html>
