package com.geni.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.geni.beans.ResourceSpace;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.geni.utility.MysqlJdbc;

public class ResourceSpaceDao {
	private ResourceSpace rs;
	
	public ResourceSpaceDao(){}
	
/*	public void InsertData2DB(ResourceSpace rs){
		setRs(rs);
		Connection connection = MysqlJdbc.getConnection();
		PreparedStatement pstmt = null;
		try{
			
			String sql = "insert into resourcespace(domain,resource,rconstraint,cost) values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, this.rs.getDomain());
			pstmt.setString(2, this.rs.getResource());
			pstmt.setString(3, this.rs.getRconstraint());
			pstmt.setFloat(4, (float) 0.0);
			pstmt.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			MysqlJdbc.closeConn(pstmt, connection);
		}
	}*/
/*
	public List<String> findRealResource(String domain, String resourceClass){
		setRs(rs);
		Connection connection = MysqlJdbc.getConnection();
		Statement stmt = null;
		List<String> tempRealResourceList = new ArrayList<String>(); 
		try{
			String sql = "select * from resourcespace where domain = '" + domain +"' and resource = '" + resourceClass +"'";
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				tempRealResourceList.add(rs.getString("rconstraint"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			MysqlJdbc.closeConn(stmt, connection);
		}
		return tempRealResourceList;
	}
	public ResourceSpace getRs() {
		return rs;
	}

	public void setRs(ResourceSpace rs) {
		this.rs = rs;
	}*/
	
}
