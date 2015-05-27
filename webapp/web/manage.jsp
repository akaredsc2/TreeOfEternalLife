<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Manager</title>
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
</c:if>

<%--Navigation--%>
<a href="<c:url value="/home.jsp"/>">Home</a>
<a href="<c:url value="/tree.jsp"/>">Draw tree</a>

<form method="post" action="creation">

    <%--FullName--%>
    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="Name" pattern="[a-zA-Z]+" required><br/>

    <label for="surname">Surname</label>
    <input type="text" id="surname" name="surname" placeholder="Surname" pattern="[a-zA-Z]+" required><br/>

    <hr/>
    <%--LifeTime--%>
    <label for="birthday">Birthday</label>
    <input type="date" id="birthday" name="birthday" placeholder="Birthday"
           pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required/><br/>

    <label for="alive">Alive</label>
    <input type="radio" id="alive" name="is-alive" value="alive"/>
    <label for="dead">Dead</label>
    <input type="radio" id="dead" name="is-alive" value="dead"/><br/>

    <label for="day-of-death">Day of death</label>
    <input type="date" id="day-of-death" name="day-of-death" placeholder="Day of death"
           pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" disabled/><br/>

    <hr/>
    <%--Parents--%>

    Parents placeholder
    <%--Children--%>

    Children placeholder
    <hr/>

    <%--AdditionalInfo--%>
    <label for="info-box">Additional information</label> <br/>
    <input type="checkbox" id="info-box" name="info-box" checked/><br/>

    <label for="photo-url">Photo URL</label>
    <input type="url" id="photo-url" name="photo-url"/><br/>

    <label for="about">About</label>
    <textarea id="about" name="about" cols="30" rows="10"></textarea><br/>

    Sex: <br/>
    <label for="male">Male</label>
    <input type="radio" id="male" name="sex" value="male" checked/><br/>

    <label for="female">Female</label>
    <input type="radio" id="female" name="sex" value="female"/>

    <input type="submit" value="Submit"/>
    <hr/>
</form>
</body>
</html>