package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.Question;
import com.geni.beans.QuestionType;
import com.geni.services.QuestionnaireService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class QuestionnaireActions extends ActionSupport implements ModelDriven<Question> {

	/**
	 * 
	 */

	private static final String DROPDOWN = "DROPDOWN";
	private static final String TEXTBOX = "TEXTBOX";
	private static final String RADIOBOX = "RADIOBOX";
	private static final String CHECKBOX = "CHECKBOX";

	private static final long serialVersionUID = 1L;
	private Question question = new Question();
	private String answer;
	private List<String> optionsList;
	private Boolean firstQuestion;

	public Question getQuestion() {
		return question;
	}

	public Boolean getFirstQuestion() {
		return firstQuestion;
	}

	public void setFirstQuestion(Boolean firstQuestion) {
		this.firstQuestion = firstQuestion;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<String> optionsList) {
		this.optionsList = optionsList;
	}

	public QuestionnaireActions() {
		optionsList = new ArrayList<String>();
		optionsList.add("Yes");
		optionsList.add("No");
		optionsList.add("Unknown");
	}

	// method to display the first question
	public String execute() {
		this.question = QuestionnaireService.getFirstQuestion();
		if (this.question == null) {
			addActionError("There is no first question to fetch");
			return ERROR;
		}
		ValueStack stack = ActionContext.getContext().getValueStack();
		this.firstQuestion = true;
		stack.push(firstQuestion);
		stack.push(question);
		return SUCCESS;
	}

	public String nextQuestion() {
		System.out.println(this.question.getQuestionId());
		System.out.println(this.question.getQuestionText());
		System.out.println(this.question.getCategory());
		System.out.println(this.question.getQuestionType());
		System.out.println(this.answer);

		ValueStack stack = ActionContext.getContext().getValueStack();
		try {
			Boolean b = Class.forName("com.geni.beans.Question").isInstance(stack.peek());
			System.out.println(b);
			if (b) {
				stack.pop();
			}
			this.question = QuestionnaireService.getNextQuestion(this.question, answer);
			if (this.question == null) {
				addActionError("No more questions to fetch");
				// if there are no more questions to ask return INPUT which is mapped to requirement review page
				return INPUT;
			}
			stack.push(this.question);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Override
	public Question getModel() {
		// TODO Auto-generated method stub
		return this.question;
	}

}
