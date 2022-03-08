package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Serv1
 */
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String Uname= request.getParameter("uname");
		String Password= request.getParameter("password");
		String Npassword= request.getParameter("npassword");
		if(Password.equals(Npassword)) {
			Cookie ck=new Cookie("uname",Uname);//creating cookie object  
			response.addCookie(ck);
			RequestDispatcher r= request.getRequestDispatcher("Welcome");
			r.forward(request,response);
			try{
				
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	Connection con =DriverManager.getConnection("Jdbc:mysql:///form","root","P@rth$00d");
	        	Statement stmt = con.createStatement();
	        	String query = "insert into form.users(UserName,Password) values('"+Uname+"','"+Password+"')";
	        	int i = stmt.executeUpdate(query);
	        	if(i>0)
	        	{
	        	System.out.println("Record inserted");
	        	}
	        	else{
	        	System.out.println("Error");
	        	}
	        	 }
	        	 catch(Exception e)
	        	 {
	        	System.out.println("Exception has occurred "+e);
	        	 }
		}
		else {
			PrintWriter writer = response.getWriter();
			writer.println("Make sure your passwords match!!");
			
		
			response.sendRedirect("index2.html");
		}
	}

}
