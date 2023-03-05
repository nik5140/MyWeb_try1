package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class SQLiteClass {
	public static Connection conn;
	public static Statement stat;
	public static ResultSet rs;
	
	public static void Conn() throws ClassNotFoundException, SQLException, NamingException {
	//	Class.forName("org.sqlite.JDBC");
	//	System.setProperty("org.sqlite.lib.path", "${catalina.home}" + "/lib/sqlite-jdbc-3.40.0.0.jar");
	//	conn = DriverManager.getConnection("jdbc:sqlite:/Users/nikitavagapov/Developer/apache-tomcat-9.0.72/lib/SimpleDatabase.db");
	//	conn = DriverManager.getConnection("jdbc:sqlite:${catalina.home}/lib/SimpleDatabase.db");
	//	conn = DriverManager.getConnection("jdbc:sqlite:SimpleDatabase");
//		conn = DriverManager.getConnection(String.format("jdbc:sqlite:%s",
  //              getServletContext().getRealPath("WEB-INF/sample.db")));
		
		
	   //   Class.forName("org.sqlite.JDBC");
	     /*   Context initCtx =  new InitialContext();
	        Context envCtx =  (Context) initCtx.lookup("java:comp/env");
	        DataSource ds = (DataSource)((InitialContext) envCtx).lookup("jdbc/SimpleDatabase");
	*/
	        Context ctx = new InitialContext();
	          DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/sqlite");
	          conn = ds.getConnection();
	}
	
	public static void PrData() throws ClassNotFoundException, SQLException, NamingException
	{
		
		Conn();
		stat = conn.createStatement();
	//	ResultSet rs = stat.executeQuery("SELECT * FROM NAMES;");
	//	rs = stat.executeQuery("INSERT INTO NAMES VALUES (3,'Hello');");
		ResultSet rs = stat.executeQuery("SELECT * FROM NAMES;");
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			Login.Info.add(rs.getString("name")) ;
			
		//	System.out.println(rs.getObject(1));
		}
		
		//Login.Info = "heyp";
		System.out.println("Wew got "+Login.Info.get(0));
		rs.close();
		stat.close();
				
	}
	
	
	public static void SetData(String Name) throws ClassNotFoundException, SQLException, NamingException
	{
		Conn();
		stat = conn.createStatement();
		Login.Info.clear();
		ResultSet rs = stat.executeQuery("SELECT * FROM NAMES;");
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			Login.Info.add(rs.getString("name")) ;
			

		}
		
		
		Login.id=Login.Info.size()+1;
		stat.executeUpdate("INSERT INTO NAMES VALUES("+Login.id+",'"+Name+"');");
		

		stat.close();
	}
	
	public static void DelData(String Name) throws ClassNotFoundException, SQLException, NamingException
	{
		Conn();
		stat = conn.createStatement();
		Login.Info.clear();
		
		stat.executeUpdate("DELETE FROM NAMES WHERE Name='"+Name+"';");
		

		stat.close();
	}
	
	
	public static void CloseDB() throws ClassNotFoundException, SQLException{
		conn.close();
	}
}
