package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/aaa")
public class MyServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String n= req.getParameter("name1");
	String e = req.getParameter("email1");
	
	PrintWriter out = resp.getWriter();
	out.println("NAME:"+n);
	out.println("EMAIL:"+e);
	
	
		
		
		
	}
}