package com.geni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.geni.beans.Question;
import com.geni.utility.MysqlJdbc;

public class QuestionDao {
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	
	private static Logger logger = Logger.getLogger(QuestionDao.class);

	public String addQuestion(String question_txt, String category) {
		Connection con = MysqlJdbc.getConnection();
		int flag = 0;
		try {
			// insert network features and precondition into network_ari table
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into questions(question_txt,category) values(?,?)");
			ps.setString(1, question_txt);
			ps.setString(2, category);

			flag = ps.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		}
		if (flag == 1) {
			logger.info("addQuestion method success");
			return SUCCESS;
		} else {
			logger.error("addQuestion method failed");
			return ERROR;
		}
	}

	public String addQuestionWithIV(String question_txt, String category, String iv) {
		Connection con = MysqlJdbc.getConnection();
		int flag = 0;
		try {
			// insert network features and precondition into network_ari table
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into questions(question_txt,category,iv) values(?,?)");
			ps.setString(1, question_txt);
			ps.setString(2, category);
			ps.setString(3, iv);
			
			flag = ps.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} finally {
			MysqlJdbc.closeConn(con);
		}
		if (flag == 1) {
			logger.info("addQuestionWithIV method success");
			return SUCCESS;
		} else {
			logger.info("addQuestionWithIV mehtod failed");
			return ERROR;
		}
	}
	
	public ResultSet getAllQuestions() {
		Connection con = MysqlJdbc.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try {
			// select all questions from the Questions table
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery("Select question_id, question_txt, category from questions");
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} finally {
			//MysqlJdbc.closeConn(stm, con);
		}
		logger.info("listQuestions method success");
		return rs;
	}
	
	public int editQuestion(int question_id, String question_txt, String category) {
		Connection con = MysqlJdbc.getConnection();
		String updateQueryStr = "update questions set question_txt=?, category=? where question_id = ?";
		int flag = 0;
		try {
			// insert network features and precondition into network_ari table
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(updateQueryStr);
			ps.setString(1, question_txt);
			ps.setString(2, category);
			ps.setInt(3, question_id);
			
			flag = ps.executeUpdate(); 
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} finally {
			MysqlJdbc.closeConn(con);
		}
		logger.info("editQuestion method success");
		return flag;
	}
	
	public int deleteQuestion(int question_id) {
		Connection con = MysqlJdbc.getConnection();
		String deleteQueryStr = "delete from questions where question_id = ?";
		int flag = 0;
		try {
			// insert network features and precondition into network_ari table
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(deleteQueryStr);
			ps.setInt(1, question_id);
			
			flag = ps.executeUpdate(); 
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} finally {
			MysqlJdbc.closeConn(con);
		}
		logger.info("deleteQuestion method success");
		return flag;
	}
	
	public Question getQuestionById(int question_id) {
		Connection con = MysqlJdbc.getConnection();
		String selectByIdQuery = "Select question_id, question_txt, category from questions where question_id = " + question_id;
		Statement stm;
		ResultSet rs;
		Question ques = null;
		try {
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery(selectByIdQuery);
			
			while(rs.next()) {
				ques = new Question();
				ques.setQuestionId(rs.getInt("question_id"));
				ques.setQuestionText(rs.getString("question_txt"));
				ques.setCategory(rs.getString("category"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			logger.error(e.getStackTrace());
		} finally {
			MysqlJdbc.closeConn(con);
		}
		return ques;
	}
}
