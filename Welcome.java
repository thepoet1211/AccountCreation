package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		doGet(request, response);
		javax.servlet.http.Cookie[] ck=request.getCookies();  
		String u=ck[0].getValue();
		PrintWriter out = response.getWriter();  
		out.print("Hello "+u);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  
			  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		      
		    javax.servlet.http.Cookie[] ck=request.getCookies();  
		    out.print("Hello "+ck[0].getValue()+" your account has been created");  
		  
		    out.close();  
		  
		         }catch(Exception e){System.out.println(e);}  
		    }  
		      
		  
		
	}


