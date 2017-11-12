package com.geni.services;

import org.apache.log4j.Logger;

import com.geni.beans.Question;
import com.geni.dao.QuestionnaireDao;

public class QuestionnaireService {
	private static Logger logger = Logger.getLogger(QuestionService.class);
	private static QuestionnaireDao dao = new QuestionnaireDao();

	public static Question getFirstQuestion() {

		return dao.getFirstQuestion();
	}

	public static Question getNextQuestion(Question currentQuestion, String answer) {
		return dao.getNextQuestion(currentQuestion.getQuestionId(), "==", answer);
	}
}
