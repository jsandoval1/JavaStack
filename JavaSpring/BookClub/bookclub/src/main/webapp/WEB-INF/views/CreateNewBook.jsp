<!-- CreateNewBook.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <title>Create New Book</title>
                </head>

                <body>
                    <h1>Create a New Book</h1>
                    <form:form method="POST" action="/books/new" modelAttribute="book">
                        <!-- * ⬇️ NEED THIS FOR BOOK TO TIE WITH USER ID ⬇️-->
                        <input type="hidden" name="user" value="${userId}"> 

                        <label for="title">Title:</label>
                        <form:input path="title" id="title" required="true" />
                        <form:errors path="title" />
                        <br>

                        <label for="author">Author:</label>
                        <form:input path="author" id="author" required="true" />
                        <form:errors path="author" />
                        <br>

                        <label for="thoughts">Thoughts:</label>
                        <form:input path="thoughts" id="thoughts" required="true" />
                        <form:errors path="thoughts" />
                        <br>

                        <input type="submit" value="Add Book" />
                    </form:form>
                    <a href="/books">Go Back</a>
                </body>

                </html>