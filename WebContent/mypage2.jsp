<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome, ${name}</h1>
<form action="Login" method= "Post">
<input type = "submit" name = "backButton" value="back"/>
<input type = "color" name = "secondButton" value = "secBack"/>
<H1>The time in seconds is:
<%= System.currentTimeMillis()%></H1>
Name:

<h1>Also we got ${cage}</h1>
</form>
</body>
</html>