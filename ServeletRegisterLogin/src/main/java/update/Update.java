package update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username= request.getParameter("name");

		String email= request.getParameter("email");
	

		System.out.println(Username);

		System.out.println(email);

	
	

	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Naruto","root","root");
		Statement stmnt=con.createStatement();
		stmnt.executeUpdate("UPDATE Users SET username='"+Username+"' WHERE email='"+email+"'");
		System.out.println("data Updated");
				
		
				
	} catch (Exception e) {
		e.printStackTrace();
	}
		doGet(request, response);
	}

}
