package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.geni.beans.Question;
import com.geni.services.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class QuestionActions extends ActionSupport implements ModelDriven<Question> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question = new Question();
	private List<Question> questionList;
	private static List<String> categoryList = new ArrayList<String>();
	static {
		categoryList.add("General");
		categoryList.add("Network");
		categoryList.add("Storage");
		categoryList.add("Compute");
		categoryList.add("Software");
	}

	public List<Question> getQuestionList() {
		return questionList;
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

	public String inputQuestions() {
		this.questionList = QuestionService.getAllQuestions();
		return INPUT;
	}

	public String addQuestion() {
		System.out.println(this.question.getQuestionText());
		System.out.println(this.question.getCategory());

		String flag = QuestionService.addQuestion(this.question);
		
		if (flag.equalsIgnoreCase("success")) {
			//ValueStack stack = ActionContext.getContext().getValueStack();
			addActionMessage("Question inserted succesfully");
			return SUCCESS;
		} else {
			addActionError("Adding question failed");
			return INPUT;
		}
	}

	public String inputEditQuestion() {
		int question_id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		System.out.println(question_id);
		this.question = QuestionService.getQuestionById(question_id);
		return INPUT;
	}

	public String updateQuestion() {
		System.out.println(this.question.getQuestionId());
		System.out.println(this.question.getQuestionText());
		System.out.println(this.question.getCategory());

		int flag = QuestionService.updateQuestion(this.question);
		if (flag == 1) {
			addActionMessage("Question updated succesfully");
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
