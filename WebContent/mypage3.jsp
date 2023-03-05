<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "com.Login" %>
<%@page import = "com.SQLiteClass" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Hello from page number 3!</h1>
<% 
	
		try {
		System.out.println("We are here");
		SQLiteClass.PrData();

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
	for(int i=0; i<Login.Info.size();i++)
	{
		out.println("<p>"+Login.Info.get(i)+"</p>");
		
	}
//	Login.Info.clear();
	
	  %>
	  
	  <form action="Login" method= "Post">
	  <input type = "submit" name = "backButton2" value="back"/>
	  </form>
</body>
</html>