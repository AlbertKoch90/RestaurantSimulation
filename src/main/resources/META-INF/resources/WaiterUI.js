var socket;

$(document).ready(function () {

    socket = new WebSocket("ws://" + location.host + "/waiter");
    socket.onmessage = function(m) {
                        console.log("Message received");
                        $("#tasks").append("Please bring " + m.data + " to the table\n");
    }
    socket.onopen=function(){
                    connected =true;
                    console.log("Connected to web socket");

};
});
