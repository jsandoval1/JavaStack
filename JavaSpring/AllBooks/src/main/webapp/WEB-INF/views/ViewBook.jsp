<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Book Details</title>
    <link rel="stylesheet" type="text/css" href="/css/ViewBook.css">
</head>
<body>
    <div class="book-info">
        <h1>${book.title}</h1>
        <p>${book.description}</p>
        <p>Language: ${book.language}</p>
        <p>Number of Pages: ${book.numberOfPages}</p>
        <p>Created At: ${book.createdAt}</p>
        <p>Updated At: ${book.updatedAt}</p>
    </div>
</body>
</html>
