package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/regform")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String myname = req.getParameter("name1");
	String myemail = req.getParameter("email1");
	String mypass = req.getParameter("pass1");
	String mygender = req.getParameter("gender1");
	String mycity = req.getParameter("city1");
	PrintWriter out = resp.getWriter();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reg","root","595877");
		System.out.println("Connected database");
		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, myname);
		ps.setString(2, myemail);
		ps.setString(3, mypass);
		ps.setString(4, mygender);
		ps.setString(5, mycity);
		int count =ps.executeUpdate();
		if(count >0) {
			resp.setContentType("text/html");
			out.print("userregistered successfully");
		RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
		rd.include(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
			out.print("error");
		}
		
		}catch (Exception e) {
		// TODO: handle exception
	}
	}

}
