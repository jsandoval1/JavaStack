<!DOCTYPE html>
<html>
    <head>
        <title>Date Page</title>
        
        <!-- Include an external JavaScript file -->
        <script src="/js/script.js"></script>

        <!-- Include an external stylesheet for styling -->
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
    <body>
        <div class="container">
            <h1>Current Date</h1>

            <!-- Display the formatted date retrieved from the model -->
            <p id="date-display">${dateTimeModel.formattedDate}</p>
        </div>
    </body>
</html>
