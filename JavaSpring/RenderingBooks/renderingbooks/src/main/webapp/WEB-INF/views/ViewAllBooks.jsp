<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>View all books</title>
    <link rel="stylesheet" type="text/css" href="/css/ViewAllBooks.css">
</head>
<body>
    <div class="table-container">
        <h1>View all books</h1>
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Language</th>
                <th>Number of Pages</th>
                <th>Created At</th>
                <th>Updated At</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.description}</td>
                    <td>${book.language}</td>
                    <td>${book.numberOfPages}</td>
                    <td>${book.createdAt}</td>
                    <td>${book.updatedAt}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
