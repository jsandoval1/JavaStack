<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Create New Dojo</title>
        </head>

        <body>
            <h1>Create a New Dojo</h1>
            <form:form method="post" modelAttribute="dojo" action="/dojos">
                <form:label path="name">Name:</form:label>
                <form:input path="name" required="true" />
                <br>
                <button type="submit">Create Dojo</button>
            </form:form>
        </body>

        </html>