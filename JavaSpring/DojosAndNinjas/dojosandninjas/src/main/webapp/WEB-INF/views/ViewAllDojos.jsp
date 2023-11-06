<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <title>View All Dojos</title>
                </head>

                <body>
                    <h1>All Dojos</h1>
                    <ul>
                        <c:forEach items="${dojos}" var="dojo">
                            <li>
                                <a href="/dojos/${dojo.id}">${dojo.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                    <!-- Button to create a new Dojo -->
                    <p><a href="/dojos/new">Create New Dojo</a></p>
                    <!-- Button to create a new Ninja -->
                    <p><a href="/ninjas/new">Create New Ninja</a></p>
                </body>

                </html>