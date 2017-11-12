package com.geni.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geni.beans.Rule;
import com.geni.services.QuestionService;
import com.geni.services.RuleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RuleActions extends ActionSupport implements ModelDriven<Rule> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String LOOP = "LOOP";
	public static final String DUPLICATE = "DUPLICATE";

	private Rule rule = new Rule();
	private List<Rule> ruleList;
	private List<String> conditionList;
	private HashMap<Integer, String> questionList;

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public List<String> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<String> conditionList) {
		this.conditionList = conditionList;
	}

	public HashMap<Integer, String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(HashMap<Integer, String> questionList) {
		this.questionList = questionList;
	}

	public List<Rule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<Rule> ruleList) {
		this.ruleList = ruleList;
	}

	public RuleActions() {
		conditionList = new ArrayList<String>();
		conditionList.add(">");
		conditionList.add("<");
		conditionList.add(">=");
		conditionList.add("<=");
		conditionList.add("==");
		conditionList.add("!=");

		this.questionList = QuestionService.getQuestionsInMap();
	}

	public String inputRules() {
		this.ruleList = RuleService.getAllRules();
		return INPUT;
	}

	public String addRule() {
		System.out.println(this.rule.getParentQuestionId());
		System.out.println(this.rule.getCondition());
		System.out.println(this.rule.getValue());
		System.out.println(this.rule.getChildQuestionId());
		
		//chekc if both parent and child questions are same
		if (this.rule.getParentQuestionId() == this.rule.getChildQuestionId()) {
			addActionError("Both parent and child questions are same");
			this.ruleList = RuleService.getAllRules();
			return INPUT;
		}
		String flag = RuleService.addRule(this.rule);

		if (flag.equalsIgnoreCase("success")) {
			addActionMessage("Rule added succesfully");
			return SUCCESS;
		} else if (flag.equalsIgnoreCase(DUPLICATE)) {
			addActionError("Rule already exists");
			return INPUT;
		} else if (flag.equalsIgnoreCase(LOOP)) {
			addActionError("Possible loop creation");
			return INPUT;
		} else {
			addActionError("Adding rule failed");
			return INPUT;
		}
	}

	@Override
	public Rule getModel() {
		return this.rule;
	}
}
