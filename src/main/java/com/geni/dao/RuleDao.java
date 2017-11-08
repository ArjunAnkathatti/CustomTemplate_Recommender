package com.geni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.geni.beans.Rule;
import com.geni.utility.MysqlJdbc;

public class RuleDao {
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	
	private static Logger logger = Logger.getLogger(QuestionDao.class);
	
	public String addRule(int rule_id, int question_id, String condition, String value) {
		Connection con = MysqlJdbc.getConnection();
		int flag = 0;
		try {
			// insert network features and precondition into network_ari table
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into rules(rule_id,question_id,condition,value) values(?,?,?,?)");
			ps.setInt(1, rule_id);
			ps.setInt(2, question_id);
			ps.setString(3, condition);
			ps.setString(4, value);

			flag = ps.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		}
		if (flag == 1) {
			logger.info("addRule method success");
			return SUCCESS;
		} else {
			logger.error("addRule method failed");
			return ERROR;
		}
	}
	
	public ResultSet listRules() {
		Connection con = MysqlJdbc.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try {
			// select all questions from the Questions table
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery("Select rule_id, question_id, condition, value, cv from rules");
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} 
		logger.info("listRules method success");
		return rs;
	}
	
	public Rule getRuleById(int rule_id) {
		Connection con = MysqlJdbc.getConnection();
		String selectByIdQuery = "Select rule_id, question_id, condition, value, cv from rules where rule_id = " + rule_id;
		Statement stm;
		ResultSet rs;
		Rule rl = null;
		try {
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery(selectByIdQuery);
			
			while(rs.next()) {
				rl = new Rule();
				rl.setRule_id(rs.getInt("rule_id"));
				rl.setQuestion_id(rs.getInt("question_id"));
				rl.setCondition(rs.getString("condition"));
				rl.setValue(rs.getString("value"));
				rl.setCv(rs.getString("cv"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			logger.error(e.getStackTrace());
		} finally {
			MysqlJdbc.closeConn(con);
		}
		return rl;
	}
}
