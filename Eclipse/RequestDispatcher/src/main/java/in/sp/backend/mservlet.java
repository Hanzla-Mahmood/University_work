package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.catalina.ha.backend.Sender;
@WebServlet("/submitForm")
public class mservlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myemail  = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		
		if (myemail.equals("hanzlaf865@gmail.com")&& mypass.equals("595877")) {
			RequestDispatcher rd= req.getRequestDispatcher("profile.jsp");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
		
	
}


