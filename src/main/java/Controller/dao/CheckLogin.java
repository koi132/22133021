package Controller.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckLogin {
	Connection conn =null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	public Accont checkLogin(String user, String pass) {
	    try {
	        String query = "select username, password from [User] where username = ? and password = ?";
	        conn = new Connection_DB().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, user);
	        ps.setString(2, pass);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            Accont a = new Accont(rs.getString(1), rs.getString(2));
	            return a;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  // Log the exception
	    }
	    return null;
	}
}
