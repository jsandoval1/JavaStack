<!-- ViewSingleBook.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <title>View Single Book</title>
                </head>

                <body>
                    <h1>${book.title}</h1>
                    <h2>${book.author}</h2>
                    <hr>
                    <h3>Here are ${book.user.userName} thoughts:</h3>
                    <p>
                        ${book.thoughts}
                    </p>
                    <a href="/books">Go Back</a>
                </body>

                </html>