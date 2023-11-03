<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <!-- <link rel="stylesheet" type="text/css" href=css/EditBurger.css /> -->
                    <title>Edit Burger</title>
                    <style>
                        body {
                            background-color: black;
                            color: white;
                            font-family: Arial, sans-serif;
                            text-align: center;
                        }

                        .burger-form {
                            margin: 20px auto;
                            max-width: 400px;
                            padding: 20px;
                            background-color: #444;
                            border: 1px solid slategray;
                            border-radius: 5px;
                            text-align: left;
                        }

                        label {
                            color: goldenrod;
                            display: block;
                            margin-top: 10px;
                        }

                        input[type="text"],
                        input[type="number"] {
                            width: 95%;
                            padding: 10px;
                            margin-top: 5px;
                            border: 1px solid #444;
                            border-radius: 5px;
                            background-color: black;
                            color: #fff;
                        }

                        button[type="submit"] {
                            background-color: goldenrod;
                            color: black;
                            padding: 10px 20px;
                            border: none;
                            border-radius: 5px;
                            cursor: pointer;
                            margin-top: 15px;
                        }

                        .error {
                            font: Verdana;
                            font-size: 12px;
                            font-weight: 600;
                            color: red;
                        }
                    </style>
                </head>

                <body>
                    <h1>Edit Burger</h1>
                    <form:form modelAttribute="burger" method="post" action="/burgers/${burger.id}">
                        <input type="hidden" name="_method" value="put" />

                        <label for="burgerName">Burger Name:</label>
                        <!-- Display a label with the text "Burger Name" -->
                        <form:input path="burgerName" id="burgerName" required="true" />
                        <!-- Create an input field for "burgerName" and associate it with the "burgerName" attribute in the model.-->
                        <form:errors path="burgerName" cssClass="error" />
                        <!-- If there are validation errors for the "burgerName" field, styled them using the "error" CSS class. -->

                        <label for="restaurantName">Restaurant:</label>
                        <form:input path="restaurantName" id="restaurantName" required="true" />
                        <form:errors path="restaurantName" cssClass="error" />

                        <label for="rating">Rating:</label>
                        <form:input path="rating" id="rating" type="number" min="1" max="5" required="true" />
                        <form:errors path="rating" cssClass="error" />

                        <button type="submit">Edit Burger</button>

                    </form:form>
                </body>

                </html>