package Controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckSign {
	Connection conn =null;
	PreparedStatement ps =null;
	ResultSet rs=null;
	public boolean checkSign(String id,String user, String pass,String image,String fullname) {
	    try {
	        String query = "insert into [User](Id,username,password,image,fullname) values (?,?,?,?,?)";
	        conn = new Connection_DB().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, id);
	        ps.setString(2, user);
	        ps.setString(3, pass);
	        ps.setString(4, image);
	        ps.setString(5, fullname);
	        int kq = ps.executeUpdate();
	        if(kq>0) {
	        	return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  // Log the exception
	    }
	    return false;
	}
}
