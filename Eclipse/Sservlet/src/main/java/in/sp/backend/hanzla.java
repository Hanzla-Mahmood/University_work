package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class hanzla extends HttpServlet{
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	out.print("I am in doGet() method for browser ");
	// TODO Auto-generated method stub
	System.out.println("Connected in console");
}
	
}

