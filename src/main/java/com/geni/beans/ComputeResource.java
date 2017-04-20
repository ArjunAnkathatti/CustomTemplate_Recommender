package com.geni.beans;

public class ComputeResource {
	public double[] computeAttributes;
	public String computeResourceName;
	int cResourceId;

	public ComputeResource(double[] computeAttributes, String computeResourceName) {
		this.computeAttributes = computeAttributes;
		this.computeResourceName = computeResourceName;
	}

	public double[] getComputeAttributes() {
		return computeAttributes;
	}

	public void setComputeAttributes(double[] computeAttributes) {
		this.computeAttributes = computeAttributes;
	}

	public String getComputeResourceName() {
		return computeResourceName;
	}

	public void setComputeResourceName(String computeResourceName) {
		this.computeResourceName = computeResourceName;
	}

	public int getcResourceId() {
		return cResourceId;
	}

	public void setcResourceId(int cResourceId) {
		this.cResourceId = cResourceId;
	}
	
	
	
}
