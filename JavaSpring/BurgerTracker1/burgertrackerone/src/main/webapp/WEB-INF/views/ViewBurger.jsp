<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Burger Details</title>
    <style>
        body {
            background-color: #000;
            color: #fff;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        h1 {
            color: #ffcc00;
        }
        .burger-info {
            width: 80%;
            margin: 20px auto;
            text-align: left;
        }
        .burger-info p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <div class="burger-info">
        <h1>${burger.burgerName}</h1>
        <p>Restaurant: ${burger.restaurantName}</p>
        <p>Rating: ${burger.rating}</p>
        <p>Created At: ${burger.createdAt}</p>
        <p>Updated At: ${burger.updatedAt}</p>
    </div>
</body>
</html>
