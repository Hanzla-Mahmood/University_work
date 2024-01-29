package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/submitForm")
public class MyServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		
		String nameS = req.getParameter("myname");
		String emailS = req.getParameter("myemail");
	
		
		System.out.println("Name"+nameS);
		
		System.out.println("Email"+emailS);
		
		PrintWriter out =resp.getWriter();
		
		out.println("Name:"+nameS);
		
		out.println("Email:"+emailS);
		
		
	}
	
}



