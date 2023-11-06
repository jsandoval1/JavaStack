<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Create Ninja</title>
            </head>

            <body>
                <h1>Create Ninja</h1>
                <form:form action="/ninjas" method="post" modelAttribute="ninja">
                    <p>
                        <form:label path="firstName">First Name:</form:label>
                        <form:errors path="firstName" />
                        <form:input path="firstName" />
                    </p>

                    <p>
                        <form:label path="lastName">Last Name:</form:label>
                        <form:errors path="lastName" />
                        <form:input path="lastName" />
                    </p>

                    <p>
                        <form:label path="age">Age:</form:label>
                        <form:errors path="age" />
                        <form:input type="number" path="age" />
                    </p>

                    <p>
                        <form:label path="dojo.id">Dojo:</form:label>
                        <form:select path="dojo">
                            <c:forEach var="dojo" items="${dojos}">
                                <form:option value="${dojo.id}" path="ninja.dojo">${dojo.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </p>

                    <input type="submit" value="Create Ninja">
                </form:form>
            </body>

            </html>