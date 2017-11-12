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
	public static final String LOOP = "LOOP";
	public static final String DUPLICATE = "DUPLICATE";
	public static final String ERROR = "ERROR";
	public static final String SUCCESS = "SUCCESS";

	private static Logger logger = Logger.getLogger(QuestionDao.class);

	public String addRule(int rule_id, int parent_question_id, String condition, String value, int child_question_id) {
		Connection con = MysqlJdbc.getConnection();
		int flag = 0;
		try {
			Statement stm = con.createStatement();

			// check if the rules already exists
			ResultSet rsExist = stm.executeQuery(
					"select * from rules where parent_question_id=" + parent_question_id + " and child_question_id="
							+ child_question_id + " and rule_condition='" + condition + "' and value='" + value + "'");
			if (rsExist.next()) {
				rsExist.close();
				return DUPLICATE;
			}

			// check if there is loop from current child to parent which might lead to
			// looping and deadlock
			ResultSet rsLoop = stm.executeQuery("select * from rules where parent_question_id=" + child_question_id
					+ " and child_question_id=" + parent_question_id);
			if (rsLoop.next()) {
				rsLoop.close();
				return LOOP;
			}

			// insert network features and precondition into network_ari table
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"insert into rules(rule_id,parent_question_id,rule_condition,value,child_question_id) values(?,?,?,?,?)");
			// rule_id is auto incremented hence we are passing 0 value to it
			ps.setInt(1, rule_id);
			ps.setInt(2, parent_question_id);
			ps.setString(3, condition);
			ps.setString(4, value);
			ps.setInt(5, child_question_id);

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

	public ResultSet getAllRules() {
		Connection con = MysqlJdbc.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try {
			// select all questions from the Questions table
			stm = (Statement) con.createStatement();
			String sqlQuery = "select r1.rule_id, r1.parent_question_id, r1.parent_question_txt, r1.rule_condition, r1.value,r1.child_question_id, r2.child_question_txt "
					+ "from (select r.rule_id, r.parent_question_id, q.question_txt as parent_question_txt, r.rule_condition as rule_condition, r.value as value, r.child_question_id as child_question_id "  
					+ "from rules r, questions q where r.parent_question_id = q.question_id) r1 inner join (select r.rule_id, r.child_question_id as child_question_id, q.question_txt as child_question_txt from rules r,questions q where r.child_question_id = q.question_id) r2 on r1.rule_id = r2.rule_id";
			/*rs = stm.executeQuery(
					"Select rule_id, parent_question_id, rule_condition, value, child_question_id from rules");*/
			
			rs = stm.executeQuery(sqlQuery);

		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		}
		logger.info("getAllRules method success");
		return rs;
	}

	public Rule getRuleById(int rule_id) {
		Connection con = MysqlJdbc.getConnection();
		String selectByIdQuery = "Select rule_id, parent_question_id, rule_condition, value, child_question_id from rules where rule_id = "
				+ rule_id;
		Statement stm;
		ResultSet rs;
		Rule rl = null;
		try {
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery(selectByIdQuery);

			while (rs.next()) {
				rl = new Rule();
				rl.setRuleId(rs.getInt("rule_id"));
				rl.setParentQuestionId(rs.getInt("parent_question_id"));
				rl.setCondition(rs.getString("rule_condition"));
				rl.setValue(rs.getString("value"));
				rl.setChildQuestionId(rs.getInt("child_question_id"));
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
