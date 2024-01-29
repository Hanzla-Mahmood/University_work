package in.sp.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public boolean validateUser(String username, String password) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uuniversity", "root", "595877")) {
            PreparedStatement ps = con.prepareStatement("select uname from login where uname=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
