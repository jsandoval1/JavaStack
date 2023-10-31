<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Time Page</title>

    <!-- Include an external JavaScript file -->
    <script src="/js/script.js"></script>

    <!-- Include an external stylesheet for styling -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Current time</h1>

        <!-- Display the formatted time retrieved from the model -->
        <p id="time-display">${dateTimeModel.formattedTime}</p>
    </div>
</body>
</html>
