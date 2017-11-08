package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.geni.beans.Question;
import com.geni.services.QuestionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionActions extends ActionSupport implements ModelDriven<Question> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question = new Question();
	private List<Question> questionList;
	private List<String> categoryList;

	public QuestionActions() {
		categoryList = new ArrayList<String>();
		categoryList.add("General");
		categoryList.add("Network");
		categoryList.add("Storage");
		categoryList.add("Compute");
		categoryList.add("Software");

	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public String displayAddQuestion() {
		this.questionList = QuestionService.listQuestions();
		return NONE;
	}

	public String addQuestion() {
		System.out.println(this.question.getQuestion_txt());
		System.out.println(this.question.getCategory());

		String flag = QuestionService.addQuestion(this.question);
		if (flag.equalsIgnoreCase("success")) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	// gets all the questions in the table Questions
	public String listQuestions() {
		this.questionList = QuestionService.listQuestions();
		return SUCCESS;
	}

	public String displayEditQuestion() {
		int question_id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		System.out.println(question_id);
		this.question = QuestionService.getQuestionById(question_id);
		this.questionList = QuestionService.listQuestions();
		return NONE;
	}

	public String updateQuestion() {
		System.out.println(this.question.getQuestion_id());
		System.out.println(this.question.getQuestion_txt());
		System.out.println(this.question.getCategory());

		int flag = QuestionService.updateQuestion(this.question);
		if (flag == 1) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	@Override
	public Question getModel() {
		// TODO Auto-generated method stub
		return this.question;
	}
}
