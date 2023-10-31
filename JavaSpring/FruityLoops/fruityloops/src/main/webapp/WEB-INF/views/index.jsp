<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Fruits</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css"> <!-- Link to the style sheet -->
    </head>

    <body>
        <div class="container">
            <h1>Fruit</h1>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through items in the model using JSTL forEach tag-->
                    <c:forEach items="${fruits}" var="fruit">
                    <!-- items="fruits" is looking for "fruits" key in the 
                    model, and using var="fruit" as a placeholder
                    to iterate through the items -->
                        <tr>
                            <td>${fruit.name}</td> <!-- Display the name of the item -->
                            <td>$${fruit.price}</td> <!-- Display the item price -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>

    </html>