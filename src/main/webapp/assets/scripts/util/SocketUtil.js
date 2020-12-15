var stompClient = null;
var SocketUtil = {};

SocketUtil.setConnected = function (connected) {
    if (connected) {

    } else {

    }
}


SocketUtil.connect = function () {
    var socket = new SockJS('/IOTApp/text-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            SocketUtil.showGreeting(JSON.parse(message.body));
        });
    });
}

SocketUtil.disconnect = function () {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    SocketUtil.setConnected(false);
    console.log("Disconnected");
}

SocketUtil.sendName = function () {
    stompClient.send("/app/chat", {}, JSON.stringify({'from': 'jkhgjgj', 'text': 'hello'}));
}


SocketUtil.showGreeting = function (message) {
    $("#id_table_render").empty();
    $("#id_table_render").append("<h2>" + message.text + "</h2>");
}