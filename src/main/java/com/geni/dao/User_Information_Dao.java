package com.geni.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import com.geni.utility.MysqlJdbc;
public class User_Information_Dao {
	
	
  /* get user account / login in*/

  public String getUserPasswordWithID(String emailID){
	  String password = null;
	  Connection conn = MysqlJdbc.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where id ='"+emailID+"'");
			while(rs.next()){
				//System.out.println(rs.getString("pass"));
				password = rs.getString("ssh");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			MysqlJdbc.closeConn(stmt, conn);
		}
		return password;
  }
  
  /*Add new user*/
  public boolean addUserAccount(String emailID, String password){
	  boolean flag = false;
	  Connection conn = MysqlJdbc.getConnection();
		Statement stmt = null;
		try {
			 PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into user values(?,?,?)");
		     ps.setString(1, emailID);
		     ps.setString(2, password);
		     ps.setString(3, emailID);
		     if(ps.executeUpdate() == 1){
		    	 flag = true;
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			MysqlJdbc.closeConn(stmt, conn);
		}
	  
	  return flag;
  }
}
