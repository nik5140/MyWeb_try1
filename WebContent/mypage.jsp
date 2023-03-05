<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

div {
	border: 1px solid gray;
	padding: 8px;

}

h1 {
text-align: center;
text-transform: uppercase;
color: #4CAF50;

}

</style>

<body>
<div>
<h1 style = "background-color:DodgerBlue;">Pharmacy market</h1>
<form action="Login" method = "Post">
Add Name:<input type="text" name = "user"/>
<input type="submit" name = "button1" value="Enter" />
<input type="submit" name = "button2" value="Another Button" />
<p>
Delete:<input type="text" name = "deleteusr"/>
<input type="submit" name = "button3" value="Delete" />

</p>

</form>

<h3>SQLite Database connection in web app</h3>
<h3> Here we got ${Info} }</h3>
</div>
</body>
</html>