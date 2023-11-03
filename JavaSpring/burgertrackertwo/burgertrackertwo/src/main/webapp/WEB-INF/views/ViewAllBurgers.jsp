<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ page isErrorPage="true" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <link rel="stylesheet" type="text/css" href=css/ViewAllBurgers.css />
                    <title>Burgers</title>
                </head>

                <body>
                    <h1>Burgers</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Burger Name</th>
                                <th>Restaurant</th>
                                <th>Rating</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="burger" items="${burgers}">
                                <tr>
                                    <td>${burger.id}</td>
                                    <td><a href="/burgers/${burger.id}">${burger.burgerName}</a></td>
                                    <td>${burger.restaurantName}</td>
                                    <td>${burger.rating}</td> <!-- Button to edit the burger -->
                                    <td><a href="/burgers/${burger.id}/edit">Edit</a></td>
                                    <td>
                                        <form method="POST" action="/burgers/${burger.id}/delete"> <!-- Button to delete the burger -->
                                            <input type="hidden" name="_method" value="DELETE"> <!-- Hidden input field to delete the burger because browser only knows get&post -->
                                            <button type="submit">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h2>Add a Burger</h2>
                    <form:form modelAttribute="burger" method="post" action="/burgers"> <!-- Parent modelAttribute is burger -->

                        <label for="burgerName">Burger Name:</label> <!-- Display a label with the text "Burger Name" -->
                        <form:input path="burgerName" id="burgerName" required="true" /> <!-- Create an input field for "burgerName" and associate it with the "burgerName" attribute in the model.-->
                        <form:errors path="burgerName" cssClass="error" /> <!-- If there are validation errors for the "burgerName" field, styled them using the "error" CSS class. -->

                        <label for="restaurantName">Restaurant:</label>
                        <form:input path="restaurantName" id="restaurantName" required="true" />
                        <form:errors path="restaurantName" cssClass="error" />

                        <label for="rating">Rating:</label>
                        <form:input path="rating" id="rating" type="number" min="1" max="5" required="true" />
                        <form:errors path="rating" cssClass="error" />

                        <button type="submit">Create Burger</button>
                    </form:form>
                </body>

                </html>