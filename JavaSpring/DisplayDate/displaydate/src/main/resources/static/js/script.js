// Listen for the DOMContentLoaded event, which indicates the page has loaded
document.addEventListener('DOMContentLoaded', function() {
    // Retrieve the current page's title
    var pageName = document.title;
    
    // Create a message to display in an alert
    var message = "You are on the " + pageName + ".";
    
    // Show the message in an alert dialog
    alert(message);
});
