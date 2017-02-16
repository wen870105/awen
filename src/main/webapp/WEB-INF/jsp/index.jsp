<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var ws;
		$("#login").click(function(){
			var target = $("#url").val();//"ws://127.0.0.1/websocket/testWsAnnotation";
			if ('WebSocket' in window) {
			    ws = new WebSocket(target);
			} else if ('MozWebSocket' in window) {
			    ws = new MozWebSocket(target);
			} else {
			    alert('WebSocket is not supported by this browser.');
			    return;
			}
			ws.onopen = function () {
			    console.log('Info: WebSocket connection opened.');
			};
			ws.onmessage = function (event) {
				alert(event.data);
			    console.log('Received: ' + event.data);
			};
			ws.onclose = function () {
				alert("cloesd");
			    console.log('Info: WebSocket connection closed.');
			};
		});
		$("#logout").click(function(){
			if (ws != null) {
			    ws.close();
			    ws = null;
			}
		});	
		
		$("#send").click(function(){
			if (ws != null) {
				try{
					var message = $("#msg").val();
					console.log(message);
				    ws.send(message);
				}catch(e){
					alert(e);
				}
			    
			} else {
			    alert('WebSocket connection not established, please connect.');
			}
		});
		$("#receive").click(function(){
			$.post("index/msg?msg="+$("#receiveMsg").val()).done(function(result) {
				console.log("execute " + "index/msg?msg="+$("#receiveMsg"));
			});
		});
	});
</script>
</head>
<body>
<input type="text" id="url" value="ws://127.0.0.1:8000/awen/handler" style="width: 350px;">
<div>
	<textarea id="msg" rows="5" cols="45"></textarea>
	<input type="button" id="send" value="send">
</div>
<div>
	<textarea id="receiveMsg" rows="5" cols="45">test msg</textarea>
	<input type="button" id="receive" value="receive">
</div>
<br/>
<input type="button" id="login" value="login">
<input type="button" id="logout" value="logout">
</body>
</html>