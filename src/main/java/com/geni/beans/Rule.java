package com.geni.beans;

public class Rule {
	private int ruleId;
	private int parentQuestionId;
	private String parentQuestionText;
	private String condition;
	private String value;
	private int childQuestionId;
	private String childQuestionText;

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public int getParentQuestionId() {
		return parentQuestionId;
	}

	public void setParentQuestionId(int parentQuestionId) {
		this.parentQuestionId = parentQuestionId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getChildQuestionId() {
		return childQuestionId;
	}

	public void setChildQuestionId(int childQuestionId) {
		this.childQuestionId = childQuestionId;
	}

	public String getParentQuestionText() {
		return parentQuestionText;
	}

	public void setParentQuestionText(String parentQuestionText) {
		this.parentQuestionText = parentQuestionText;
	}

	public String getChildQuestionText() {
		return childQuestionText;
	}

	public void setChildQuestionText(String childQuestionText) {
		this.childQuestionText = childQuestionText;
	}

}
