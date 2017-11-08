package com.geni.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.geni.beans.Question;
import com.geni.dao.QuestionDao;

public class QuestionService {
	
	private static Logger logger = Logger.getLogger(QuestionService.class);
	private static QuestionDao dao = new QuestionDao();
	
	public static String addQuestion(Question ques){
		String flag = dao.addQuestion(ques.getQuestion_txt(), ques.getCategory());
		return flag;
	}
	
	public static List<Question> listQuestions() {
		List<Question> questionList = new ArrayList<Question>();
		ResultSet rs = dao.listQuestions();
		if (rs != null) {
			try {
				while(rs.next()) {
					Question ques = new Question();
					ques.setQuestion_id(rs.getInt("question_id"));
					ques.setQuestion_txt(rs.getString("question_txt"));
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
	
	public static Question getQuestionById(int question_id) {
		Question ques;
		ques = dao.getQuestionById(question_id);
		if (ques == null) {
			logger.error("Question object is null");
		}
		return ques;
	}
	
	public static int updateQuestion(Question ques) {
		return dao.editQuestion(ques.getQuestion_id(), ques.getQuestion_txt(), ques.getCategory());
	}
	
	public static int removeQuesiton(int question_id) {
		return dao.deleteQuestion(question_id);
	}
}
