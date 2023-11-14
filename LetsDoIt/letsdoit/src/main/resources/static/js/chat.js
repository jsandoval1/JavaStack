// Connect to the WebSocket server
var socket = new SockJS('/ws');
var stompClient = Stomp.over(socket);

stompClient.connect({}, function(frame) {
    // Subscribe to the /topic/messages topic to receive messages
    stompClient.subscribe('/topic/messages', function(messageOutput) {
        // Handle received messages
        console.log(JSON.parse(messageOutput.body).content);
    });
});

// Send a message
function sendMessage() {
    var messageInput = document.getElementById('messageInput').value;
    stompClient.send("/app/ws", {}, JSON.stringify({ 'content': messageInput }));
}