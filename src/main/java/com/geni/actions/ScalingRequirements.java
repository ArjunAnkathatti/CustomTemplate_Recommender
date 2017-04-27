package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.ScalingPolicy;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScalingRequirements extends ActionSupport implements ModelDriven<ScalingPolicy>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScalingPolicy sp = new ScalingPolicy();
	private List<String> noOfInstancesList;
	private List<String> actionList;
	private List<String> metricTypeList;
	private List<String> conditionList;
	
	
	public List<String> getNoOfInstancesList() {
		return noOfInstancesList;
	}

	public void setNoOfInstancesList(List<String> noOfInstancesList) {
		this.noOfInstancesList = noOfInstancesList;
	}

	public List<String> getActionList() {
		return actionList;
	}

	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}

	public List<String> getMetricTypeList() {
		return metricTypeList;
	}

	public void setMetricTypeList(List<String> metricTypeList) {
		this.metricTypeList = metricTypeList;
	}

	public List<String> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<String> conditionList) {
		this.conditionList = conditionList;
	}

	public ScalingPolicy getSp() {
		return sp;
	}

	public void setSp(ScalingPolicy sp) {
		this.sp = sp;
	}
	
	public ScalingRequirements() {
		noOfInstancesList = new ArrayList<String>();
		noOfInstancesList.add("1");
		noOfInstancesList.add("2");
		noOfInstancesList.add("3");
		noOfInstancesList.add("4");
		
		actionList = new ArrayList<String>();
		actionList.add("Add");
		actionList.add("Remove");
		
		metricTypeList = new ArrayList<String>();
		metricTypeList.add("CPU Utilization");
		metricTypeList.add("Disk Utilization");
		metricTypeList.add("Network Utilization");
		
		conditionList = new ArrayList<String>();
		conditionList.add(">");
		conditionList.add(">=");
		conditionList.add("<");
		conditionList.add("<=");
	}
	

	@Override
	public ScalingPolicy getModel() {
		return this.sp;
	}
	
	public String display() {
		return NONE;
	}
	
	public String setScalingReq() {
		System.out.println("ComparisionOperator" + this.sp.getComparisionOperator());
		System.out.println("Metric Type" + this.sp.getMetricType());
		System.out.println("Policy Name" + this.sp.getPolicyName());
		System.out.println("Scaling Action" + this.sp.getScalingAction());
		System.out.println("Threshold" + this.sp.getThreshold());
		return SUCCESS;
	}
	
	

}
