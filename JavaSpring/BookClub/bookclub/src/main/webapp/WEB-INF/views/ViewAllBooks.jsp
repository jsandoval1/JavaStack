<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Book Club</title>
                    <style>
                        body {
                            background-color: black;
                            color: white;
                            font-family: Arial, sans-serif;
                        }
                    </style>
                    <!-- <link rel="stylesheet" type="text/css" href="css/expenses.css"> -->
                </head>

                <body>
                    <h1>Book Club</h1>
                    <h2> Hey, ${user.userName}</h2> <!-- This shows user in session-->
                    <a href="/books/new"> Create a Bookietookie </a>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Author Name</th>
                                <th>Post By</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="book" items="${books}">
                                <tr>
                                    <td>${book.id}</td>
                                    <td>
                                        <a href="/books/${book.id}"> ${book.title} </a>
                                    </td> 
                                    <td>${book.author}</td>
                                    <!-- ! Compicated part: accessing books posted by user name -->
                                    <td>
                                        ${book.user.userName}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="/logout">Logout</a>
                </body>

                </html>