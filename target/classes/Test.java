
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import utility.MysqlJdbc;


public class Test {
	private static Properties prop;
	private static InputStream input;

	public static Connection getConnection() {
		try {
			String filename = "config.properties";
    		input = MysqlJdbc.class.getClassLoader().getResourceAsStream(filename);
			prop = new Properties();
			prop.load(input);
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName(prop.getProperty("DB_DRIVER_NAME"));
			String url = prop.getProperty("DB_URL");
			String user = prop.getProperty("DB_USER_NAME");
			String psw = prop.getProperty("DB_PASSWORD");
			//Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo_schema", "arjun", "arjun");
			Connection connect = DriverManager.getConnection(url, user, psw);
			System.out.println("mysql connectino is succesful");
			return connect;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConn(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occurs in closing the database!");
		}
	}
	
	public static void main(String[] args) {
		Connection con = getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from storage_rspace");
			while (rs.next()) {
				System.out.println(rs.getString("resource_name") + "\t" + "minStorage");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(stmt, con);
		}
	}

}
