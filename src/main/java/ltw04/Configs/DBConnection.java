package ltw04.Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "LTWEB";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "123456";

    public Connection getConnection() throws Exception {
    	String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
    	
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        try {
            return DriverManager.getConnection(url, userID, password);
        } catch (SQLException e) {
            System.err.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
            throw e; // Hoặc trả về null nếu bạn muốn tiếp tục mà không ném ngoại lệ
        }
    }
    
    public static void main(String[] args) {
		try {
			System.out.println(new DBConnection().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
