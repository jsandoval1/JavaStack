<!-- JSP to edit burger -->
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
                    <title>Edit Burger</title>
                </head>
                <body>
                    <h1>Edit Burger</h1>
                    <form:form modelAttribute="burger" method="post" action="/burgers/${burger.id}"> 
                        <input type="hidden" name="_method" value="put" />
                    
                        <label for="burgerName">Burger Name:</label> <!-- Display a label with the text "Burger Name" -->
                        <form:input path="burgerName" id="burgerName" required="true" /> <!-- Create an input field for "burgerName" and associate it with the "burgerName" attribute in the model.-->
                        <form:errors path="burgerName" cssClass="error" /> <!-- If there are validation errors for the "burgerName" field, styled them using the "error" CSS class. -->
                        
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