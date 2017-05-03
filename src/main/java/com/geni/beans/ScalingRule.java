package com.geni.beans;

public class ScalingRule {
	
	private String ruleName;
	private String metricType;
	private String condition;
	private String action;
	private int noOfInstances;
	private double threshold;
	private int period;
	private int evaluationPeriod;
	
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getMetricType() {
		return metricType;
	}
	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getNoOfInstances() {
		return noOfInstances;
	}
	public void setNoOfInstances(int noOfInstances) {
		this.noOfInstances = noOfInstances;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getEvaluationPeriod() {
		return evaluationPeriod;
	}
	public void setEvaluationPeriod(int evaluationPeriod) {
		this.evaluationPeriod = evaluationPeriod;
	}
	
}
