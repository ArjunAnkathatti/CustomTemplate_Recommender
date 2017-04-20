package com.geni.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String emailID = "111@gmail.com";
		Connection conn = MysqlJdbc.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where id = '" + emailID + "'");
			while (rs.next()) {
				System.out.println(rs.getString("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MysqlJdbc.closeConn(stmt, conn);
		}

	}

}
