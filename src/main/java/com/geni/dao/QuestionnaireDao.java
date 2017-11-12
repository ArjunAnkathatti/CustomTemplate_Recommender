package com.geni.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.geni.beans.Question;
import com.geni.services.QuestionService;
import com.geni.utility.MysqlJdbc;

public class QuestionnaireDao {
	private static Logger logger = Logger.getLogger(QuestionService.class);

	public Question getFirstQuestion() {
		Question question = null;

		Connection con = MysqlJdbc.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try {
			// select the question from question where firstQuestion is set to 'Y'
			stm = (Statement) con.createStatement();
			rs = stm.executeQuery(
					"Select question_id, question_txt, category, question_type from questions where firstQuestion='Y'");
			while (rs.next()) {
				question = new Question();
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuestionText(rs.getString("question_txt"));
				question.setCategory(rs.getString("category"));
				question.setQuestionType(rs.getString("question_type"));
			}

		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} finally {
			MysqlJdbc.closeConn(stm, con);
		}
		logger.info("getFirstQuestion method success");

		return question;
	}
	
	public Question getNextQuestion(int question_id, String condition, String answer) {
		Question question = null;

		Connection con = MysqlJdbc.getConnection();
		Statement stm = null;
		ResultSet resultSetRule = null;
		ResultSet resultSetQuestion = null;
		try {
			// select the question from question where parent question id, condition and answer matches the rule
			stm = (Statement) con.createStatement();
			resultSetRule = stm.executeQuery(
					"Select rule_id, child_question_id from rules where parent_question_id=" + question_id + " and rule_condition='" + condition + "' and value='" + answer +"'");
			int childQuestionId = 0;
			while (resultSetRule.next()) {
				logger.info("getNextQuestion: found a rule and fetching a childQuestionId");
				childQuestionId = resultSetRule.getInt("child_question_id");
			}
			if (childQuestionId != 0) {
				logger.info("getNextQuestion: childQuestionId is not zero");
				resultSetQuestion = stm.executeQuery("Select question_id, question_txt, category, question_type from questions where question_id=" + childQuestionId);
				while (resultSetQuestion.next()) {
					question = new Question();
					question.setQuestionId(resultSetQuestion.getInt("question_id"));
					question.setQuestionText(resultSetQuestion.getString("question_txt"));
					question.setCategory(resultSetQuestion.getString("category"));
					question.setQuestionType(resultSetQuestion.getString("question_type"));
				}
			}

		} catch (Exception e) {
			logger.error(e.getStackTrace());
			logger.error(e.getMessage());
		} finally {
			MysqlJdbc.closeConn(stm, con);
		}
		logger.info("getFirstQuestion method success");

		return question;
	}

}
