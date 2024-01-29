package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String username = request.getParameter("txtName");
            String password = request.getParameter("txtpwd");

            LoginDAO loginDAO = new LoginDAO();
            if (loginDAO.validateUser(username, password)) {
                RequestDispatcher rd = request.getRequestDispatcher("quiz.html");
                rd.forward(request, response);
            } else {
                out.println("<font color=red size=18>Login Failed!!<br>");
                out.println("<a href=login.jsp>Try AGAIN!!</a>");
                out.print("Failed ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
