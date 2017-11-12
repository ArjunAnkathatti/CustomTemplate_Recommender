package com.geni.utility;

import com.geni.services.QuestionService;

import java.util.List;

import org.apache.log4j.Logger;

import com.geni.beans.Question;

public class Delete {
	private static Logger logger = Logger.getLogger(Delete.class);

	public static void main(String[] args) {
		/*
		 * Question ques = new Question();
		 * ques.setQuestion_txt("what is the type of your applicaiton/workflow?"
		 * ); ques.setCategory("General"); String flag =
		 * QuestionService.addQuestion(ques);
		 */

		List<Question> questionList = QuestionService.listQuestions();
		if (questionList != null) {
			for (Question ques : questionList) {
				System.out.printf("Question_id: %d, %s, %s\n", ques.getQuestionId(), ques.getQuestionText(),
						ques.getCategory());
			}
		} else {
			System.out.println("no question to display");
		}

		/*
		 * Question ques = new Question(); ques.setQuestion_id(1);
		 * ques.setQuestion_txt("What is you application name?");
		 * ques.setCategory("General"); int flag =
		 * QuestionService.updateQuestion(ques); if (flag == 1) {
		 * System.out.println("updated succesfully"); } else {
		 * System.out.println("updation failed"); }
		 */

		/*
		 * int flag = QuestionService.removeQuesiton(2); if (flag == 1) {
		 * System.out.println("deleted"); } else {
		 * System.out.println("deletion failed"); }
		 */
		Question ques = new Question();
		ques.setQuestionId(4);
		ques.setQuestionText("new value");
		ques.setCategory("Network");
		int flag = QuestionService.updateQuestion(ques);
		System.out.println(flag);
	}
}
