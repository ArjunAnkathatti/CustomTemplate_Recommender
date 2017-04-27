package com.geni.beans;

public class ScalingPolicy {
	private String policyName;
	private String scalingAction;
	private int scalingAdjustment;
	private String metricType;
	private String comparisionOperator;
	private float threshold;

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getScalingAction() {
		return scalingAction;
	}

	public void setScalingAction(String scalingAction) {
		this.scalingAction = scalingAction;
	}

	public int getScalingAdjustment() {
		return scalingAdjustment;
	}

	public void setScalingAdjustment(int scalingAdjustment) {
		this.scalingAdjustment = scalingAdjustment;
	}

	public String getMetricType() {
		return metricType;
	}

	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}

	public String getComparisionOperator() {
		return comparisionOperator;
	}

	public void setComparisionOperator(String comparisionOperator) {
		this.comparisionOperator = comparisionOperator;
	}

	public float getThreshold() {
		return threshold;
	}

	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}

}
