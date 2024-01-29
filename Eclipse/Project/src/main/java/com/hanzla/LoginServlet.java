package com.hanzla;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/uuniversity","root","595877");
			String n =request.getParameter("txtName");
			String p =request.getParameter("txtpwd");
			PreparedStatement ps=con.prepareStatement("select * from login where email=? and password=?");
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				 out.println("Congratulations! Login Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("quizz.jsp");
		     rd.forward(request, response);
			}
			else {
			out.println("<font color=red size=18>Login Failed!!<br>");
			out.println("<a href=login.jsp>Try AGAIN!!</a>");
			out.print("Failed ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

