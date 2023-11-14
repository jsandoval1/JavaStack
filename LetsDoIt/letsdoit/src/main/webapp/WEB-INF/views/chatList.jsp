<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chat List</title>
</head>
<body>
    <h1>Chat List</h1>
    <ul>
        <c:forEach var="user" items="${chatPartners}">
            <li>
                <a href="<c:url value='/chat/${user.id}'/>">${user.firstName}</a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>