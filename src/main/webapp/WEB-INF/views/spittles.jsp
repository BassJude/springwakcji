<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
    <%--          href="<c:url value="/resources/style.css" />" >--%>
</head>
<body>
<h1>Witamy w serwisie Spittr</h1>
<a href="<c:url value="/spittles" />">Spittle</a> |
<a href="<c:url value="/spitter/register" />">Rejestracja</a>
<div></div>

<c:forEach items="${spittleList}" var="spittle" >
    <li id="spittle_<c:out value="spittle.id"/>">
        <div class="spittleMessage">
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime"><c:out value="${spittle.time}" /></span>
            <span class="spittleLocation">
(<c:out value="${spittle.latitude}" />,
<c:out value="${spittle.longitude}" />)
</span>
        </div>
    </li>
</c:forEach>


</body>