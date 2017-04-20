package com.geni.beans;

public class MiniTemplate {
	private double[] templateAttributes;
	private String templateId;
	private float totalCost;

	public MiniTemplate(double[] templateAttributes, String templateId, float totalCost) {
		this.templateId = templateId;
		this.templateAttributes = templateAttributes;
		this.totalCost = totalCost;
	}

	public double[] getTemplateAttributes() {
		return templateAttributes;
	}

	public void setTemplateAttributes(double[] templateAttributes) {
		this.templateAttributes = templateAttributes;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totaCost) {
		this.totalCost = totaCost;
	}

}
