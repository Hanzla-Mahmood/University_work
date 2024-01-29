package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class myservlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String myemail = request.getParameter("email");
        String mypassword = request.getParameter("password");
        database Co=new database();
        try {
            Connection connection=Co.concet();
            PreparedStatement ps = connection.prepareStatement("select * from login where email=? and password=?");
            ps.setString(1, myemail);
            ps.setString(2, mypassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                out.println("Congratulations! Login Successfully");
                RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
                rd.include(request, response);

            } else {
                out.println("Email or Password Did not matched");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

