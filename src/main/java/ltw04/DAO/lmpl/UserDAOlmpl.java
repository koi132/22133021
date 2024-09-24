package ltw04.DAO.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ltw04.Configs.DBConnection;
import ltw04.DAO.UserDAO;
import ltw04.Models.User;

public class UserDAOlmpl implements UserDAO {
	/*
	 * private Connection conn = null; private PreparedStatement ps = null;
	 */

	@Override
	public User findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
	    try (Connection conn = new DBConnection().getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setUserName(rs.getString("username"));
	            user.setPassWord(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            user.setFullName(rs.getString("fullname"));
	            // Add other fields if needed
	            return user;
	        }
	    } catch (SQLException e) {
	        System.err.println("SQL error during user lookup: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.err.println("Unexpected error during user lookup: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public User get(String username) {
		// Existing method
		return null;
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void register(User user) {
		 String sql = "INSERT INTO users (username, password, email, fullname) VALUES (?, ?, ?, ?)";

	        try (Connection conn = new DBConnection().getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            // Kiểm tra kết nối
	            if (conn == null || conn.isClosed()) {
	                System.err.println("Connection is null or closed.");
	                return;
	            }

	            // Đặt giá trị cho PreparedStatement
	            ps.setString(1, user.getUserName());
	            ps.setString(2, user.getPassWord());
	            ps.setString(3, user.getEmail());
	            ps.setString(4, user.getFullName());

	            // Thực thi câu lệnh SQL
	            int rowsAffected = ps.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("User registered successfully.");
	            } else {
	                System.out.println("No rows affected.");
	            }

	        } catch (SQLException e) {
	            System.err.println("SQL error during registration: " + e.getMessage());
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.err.println("Unexpected error during registration: " + e.getMessage());
	            e.printStackTrace();
	        }
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
}
