<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Receipt</title>
</head>
<body>
    <h1>Receipt</h1>
    
    <!-- Loop through items in the model using JSTL forEach -->
    <c:forEach items="${items}" var="item">
        <p>Name: ${item.name}</p> <!-- Display the name of the item -->
        <p>Item Name: ${item.itemName}</p> <!-- Display the item name -->
        <p>Price: $${item.price}</p> <!-- Display the item price -->
        <p>Description: ${item.description}</p> <!-- Display the item description -->
        <p>Vendor: ${item.vendor}</p> <!-- Display the vendor of the item -->
    </c:forEach>
</body>
</html>
