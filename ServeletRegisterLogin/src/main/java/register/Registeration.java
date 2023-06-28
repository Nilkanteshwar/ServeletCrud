package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/save")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Registeration() {
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
		String Username= request.getParameter("name");
		String number= request.getParameter("number");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
	System.out.println(Username);
	System.out.println(number);
	System.out.println(email);
	System.out.println(password);
	
	

	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Naruto","root","root");
		Statement stmnt=con.createStatement();
		stmnt.execute("insert into Users value('"+Username+"','"+number+"','"+email+"','"+password+"')"); 
		System.out.println("data inserted");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 out.println("<meta http-equiv='refresh' content='3;URL=login.html'>");//redirects after 3 seconds
		   out.println("<p style='color:red;'>Registered Sucessfully!</p>");
		
		
		
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

}
