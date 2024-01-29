package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("servlet1")
public class MyServlet1 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		doGet(req, resp);
		String p = req.getParameter("nm");
		PrintWriter out = resp.getWriter();
		out.println("<form action='servlet2'> input type='text' name='users'value='"+p+"'> <br><br> <button type='submit'></form>");
	}
}
