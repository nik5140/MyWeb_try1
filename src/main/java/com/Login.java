package com;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
// please keep this project, cause it extra hard to make sqlite db work with TomCat

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	public static ArrayList<String> Info=new ArrayList<String>();	// we can make list of names from this and get it from database
	private static final long serialVersionUID = 1L;
	public static int id=10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (Info.isEmpty())
			request.getServletContext().getRequestDispatcher("/mypage.jsp").forward(request, response);
		else
			{
			out.print("The text is "+Info.get(0));
			
			}
		
		
		System.out.println(Info);
	
	System.out.println("We are in doGet");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getParameter("button1")!=null)
		{
			System.out.println("button1 pushed");
			
		}
		
		if (request.getParameter("button1")!=null) {
		String inputName = request.getParameter("user");
		
	    request.setAttribute("name", inputName);
	    request.setAttribute("cage", (String)("CAGE"));
	    try {
			SQLiteClass.SetData(inputName);
			System.out.println("trying insert");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   if(inputName.equalsIgnoreCase("5"))
		 {
	    	response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	    	for(int i=0; i<5; i++)
	    		out.println("<p>Hello, magic world!</p>");
	    		Info.clear();
	    }
	   // System.out.println(inputName);
	    
	   else request.getServletContext().getRequestDispatcher("/mypage2.jsp").include(request, response);
		System.out.println("We are in doPost");
		}
		
		else if (request.getParameter("button2")!=null)
		{
			System.out.println("button2 pressed");
			Info.clear();
			request.getServletContext().getRequestDispatcher("/mypage3.jsp").include(request, response);

		}
		
		else if (request.getParameter("button3")!=null)
		{
			System.out.println("button3 pressed");
			String deleteName = request.getParameter("deleteusr");
			try {
				SQLiteClass.DelData(deleteName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getServletContext().getRequestDispatcher("/mypage3.jsp").include(request, response);

		}
		
		else if (request.getParameter("backButton")!=null)
		{
			request.getServletContext().getRequestDispatcher("/mypage.jsp").include(request, response);
			System.out.println("backButton pressed");
			
		}
		
		else if (request.getParameter("backButton2")!=null)
		{
			request.getServletContext().getRequestDispatcher("/mypage.jsp").include(request, response);
			System.out.println("backButton2 pressed");
			
		}
		
	}	

}
