<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Chat</title>
            </head>

            <body>
                <h1>Chat with:</h1>
                <form:form action="/chat" method="post" modelAttribute="messageForm">
                    <form:hidden path="senderUser.id" />
                    <form:select path="receiverUser.id">
                        <c:forEach var="user" items="${users}">
                            <form:option value="${user.id}" label="${user.firstName}"/>
                        </c:forEach>
                    </form:select>
                    <form:textarea path="content" rows="4" cols="50" placeholder="Write your message here..." />
                    <br>
                    <input type="submit" value="Send Message">
                </form:form>
            </body>

            <script>
                var socket = new WebSocket("ws://localhost:8080/ws");
                document.querySelector('form').addEventListener('submit', function (event) {
                    event.preventDefault();
                    var senderUserId = document.querySelector('input[name="senderUser.id"]').value;
                    var receiverUserId = document.querySelector('select[name="receiverUser.id"]').value;
                    var messageContent = document.querySelector('textarea[name="content"]').value;
                    console.log("Sender User ID: " + senderUserId);
                    console.log("Receiver User ID: " + receiverUserId);
                    console.log("Message Content: " + messageContent);
                    socket.send(JSON.stringify({ senderUserId: senderUserId, receiverUserId: receiverUserId, messageContent: messageContent }));
                });
            </script>

            </html>