package com.geni.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.geni.beans.Question;
import com.geni.dao.QuestionDao;

public class QuestionService {
	
	private static Logger logger = Logger.getLogger(QuestionService.class);
	private static QuestionDao dao = new QuestionDao();
	
	public static String addQuestion(Question ques){
		String flag = dao.addQuestion(ques.getQuestionText(), ques.getCategory());
		return flag;
	}
	
	public static List<Question> getAllQuestions() {
		List<Question> questionList = new ArrayList<Question>();
		ResultSet rs = dao.getAllQuestions();
		if (rs != null) {
			try {
				while(rs.next()) {
					Question ques = new Question();
					ques.setQuestionId(rs.getInt("question_id"));
					ques.setQuestionText(rs.getString("question_txt"));
					ques.setCategory(rs.getString("category"));
					questionList.add(ques);
				}
			} catch (SQLException e) {
				logger.error(e.getStackTrace());
				logger.error(e.getMessage());
			}
			logger.info("listQuestion mehtod - resultSet is not null");
		} else {
			logger.info("listQuestion method - resultSet is null");
		}
		return questionList;
	}
	
	public static HashMap<Integer, String> getQuestionsInMap() {
		HashMap<Integer, String> questionMap = new HashMap<Integer, String>();
		ResultSet rs = dao.getAllQuestions();
		if (rs != null) {
			try {
				while(rs.next()) {
					questionMap.put(rs.getInt("question_id"), rs.getString("question_txt"));
				}
			} catch (SQLException e) {
				logger.error(e.getStackTrace());
				logger.error(e.getMessage());
			}
			logger.info("getQuestionsInMap mehtod - resultSet is not null");
		} else {
			logger.info("getQuestionsInMap method - resultSet is null");
		}
		return questionMap;
	}
	
	public static Question getQuestionById(int question_id) {
		Question ques;
		ques = dao.getQuestionById(question_id);
		if (ques == null) {
			logger.error("Question object is null");
		}
		return ques;
	}
	
	public static int updateQuestion(Question ques) {
		return dao.editQuestion(ques.getQuestionId(), ques.getQuestionText(), ques.getCategory());
	}
	
	public static int removeQuesiton(int question_id) {
		return dao.deleteQuestion(question_id);
	}
}
