<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <link rel="stylesheet" type="text/css" href=css/ViewAllBurgers.css />
            <title>Burger Details</title>
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