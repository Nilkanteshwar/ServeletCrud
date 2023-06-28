package display;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Users List");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>User name </th>");
		out.println("<th>Email </th>");
		out.println("<th>Number</th>");
		out.println("<th>Password </th>");
		
		out.println("</tr>");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Naruto","root","root");
			Statement stmnt=con.createStatement();
			ResultSet res=stmnt.executeQuery("select * from Users"); 
			
			
			while(res.next()) {
		
				out.println("<tr>");
				out.println("<td>" + res.getString(1) +"</td>"  );
				out.println("<td>" + res.getString(2) +"</td>"  );
				out.println("<td>" + res.getString(3) +"</td>"  );
				out.println("<td>" + res.getString(4) +"</td>"  );
				out.println("</tr>");
				
			}
			
			out.println("</table>");
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
