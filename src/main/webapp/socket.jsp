<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		var socket;
        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }
 
        function connect() {
            if ('WebSocket' in window){
                  console.log('Websocket supported');
                  socket = new WebSocket('ws://localhost:8080/demo/myHandler');
 
                  console.log('Connection attempted');
 
                  socket.onopen = function(){
                       console.log('Connection open!');
                       setConnected(true);
                    }
 
                  socket.onclose = function(){
                      console.log('Disconnecting connection');
                  }
 
                  socket.onmessage = function (evt)
                     {
                        var received_msg = evt.data;
                        console.log(received_msg);
                        console.log('message received!');
                        showMessage(received_msg);
                     }
 
                } else {
                  console.log('Websocket not supported');
                }
        }
 
        function disconnect() {
            setConnected(false);
            console.log("Disconnected");
        }
 
        function sendName() {
            var message = document.getElementById('message').value;
            socket.send(JSON.stringify({ 'message': message }));
        }
 
        function showMessage(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
 
</script>
</head>
<body>

</body>
</html>