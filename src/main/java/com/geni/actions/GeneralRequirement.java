package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GeneralRequirement extends ActionSupport implements ModelDriven<GeneralARI> {

	private static final long serialVersionUID = 1L;

	private GeneralARI general = new GeneralARI();
	private List<String> appKindList;
	private List<String> appPriorityList;
	private List<String> appDataSizeList;
	private List<String> appTransTimeList;
	private List<String> appPreferredDimensionList;
	private long startTime; 


	public GeneralARI getGeneral() {
		return general;
	}
	public void setGeneral(GeneralARI general) {
		this.general = general;
	}
	public List<String> getAppKindList() {
		return appKindList;
	}
	public void setAppKindList(List<String> appKindList) {
		this.appKindList = appKindList;
	}
	public List<String> getAppPriorityList() {
		return appPriorityList;
	}
	public void setAppPriorityList(List<String> appPriorityList) {
		this.appPriorityList = appPriorityList;
	}
	public List<String> getAppDataSizeList() {
		return appDataSizeList;
	}
	public void setAppDataSizeList(List<String> appDataSizeList) {
		this.appDataSizeList = appDataSizeList;
	}
	public List<String> getAppTransTimeList() {
		return appTransTimeList;
	}
	public void setAppTransTimeList(List<String> appTransTimeList) {
		this.appTransTimeList = appTransTimeList;
	}
	public List<String> getAppPreferredDimensionList() {
		return appPreferredDimensionList;
	}
	public void setAppPreferredDimensionList(List<String> appPreferredDimensionList) {
		this.appPreferredDimensionList = appPreferredDimensionList;
	}
	
	public GeneralRequirement() {
		appKindList = new ArrayList<String>();
		appKindList.add(getText("appKind.commonApp"));
		appKindList.add(getText("appKind.dataIntensiveApp"));
		appKindList.add(getText("appKind.missionCriticalApp"));
		appKindList.add(getText("appKind.streamingApp"));
		appKindList.add(getText("appKind.virtualDesktop"));
		appKindList.add(getText("list.unknown"));
		
		appPriorityList = new ArrayList<String>();
		appPriorityList.add(getText("appPriority.availability"));
		appPriorityList.add(getText("appPriority.performance"));
		appPriorityList.add(getText("appPriority.throughput"));
		appPriorityList.add(getText("list.unknown"));
		
		appDataSizeList = new ArrayList<String>();
		appDataSizeList.add(getText("appDataSizeList.op1"));
		appDataSizeList.add(getText("appDataSizeList.op2"));
		appDataSizeList.add(getText("appDataSizeList.op3"));
		appDataSizeList.add(getText("appDataSizeList.op4"));
		appDataSizeList.add(getText("appDataSizeList.op5"));
		appDataSizeList.add(getText("appDataSizeList.op6"));
		appDataSizeList.add(getText("list.unknown"));
		
		/*appTransTimeList = new ArrayList<String>();
		appTransTimeList.add(getText("appTransTimeList.op1"));
		appTransTimeList.add(getText("appTransTimeList.op2"));
		appTransTimeList.add(getText("appTransTimeList.op3"));
		appTransTimeList.add(getText("list.unknown"));*/
		
		appPreferredDimensionList = new ArrayList<String>();
		appPreferredDimensionList.add(getText("pdList.network"));
		appPreferredDimensionList.add(getText("pdList.storage"));
		appPreferredDimensionList.add(getText("pdList.compute"));
		
		this.startTime = System.currentTimeMillis();
		
	}

	public boolean isValid() {
		boolean isValid = true;
		if (StringUtils.isEmptyOrWhitespaceOnly(general.getAppName())) {
			addFieldError("appName", getText("error.appName"));
			isValid = false;
		}
		if (general.getAppKind().equals("null")) {
			addFieldError("appKind", getText("error.appKind"));
			isValid = false;
		}
		if (general.getAppPriority().equals("null")) {
			addFieldError("appPriority", getText("error.appPriority"));
			isValid = false;
		}
		if (general.getAppDataSize().equals("null")) {
			addFieldError("appDataSize", getText("error.appDataSize"));
			isValid = false;
		}
		/*if (general.getAppTransferTime().equals("null")) {
			addFieldError("appTransferTime", getText("error.appTransferTime"));
			isValid = false;
		}
		if (general.getAppPreferredDimension().equals("null")) {
			addFieldError("appPreferredDimension", getText("error.appPreferredDimension"));
		}*/
		return isValid;
	}
	
	public String getDefaultAppKind() {
		return "RiceKb";
	}
	
	public String display() {
		//general.setAppName("SoyKb");
		//general.setAppKind(getText("appKind.missionCriticalApp"));
		//general.setAppPriority(getText("appPriority.availability"));
		//general.setAppDataSize(getText("appDataSizeList.op3"));
		return NONE;
	}
	
	public String setGeneralReq() {
		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(general.getAppName());
			System.out.println(general.getAppKind());
			System.out.println(general.getAppPriority());
			System.out.println(general.getAppDataSize());
	
			// set default appPriority
			if (general.getAppPriority().equals("default")) {
				general.setAppPriority("availability");
			}
	
			// set default appKind
			if (general.getAppKind().equals("default")) {
				general.setAppKind("webApp");
			}
	
			// set default dataSize
			if (general.getAppDataSize().equals("default")) {
				general.setAppDataSize("5 - 10 Gbps");
			}
	
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("emailid", "arjun");
			ctx.getSession().put("general", general);
			ctx.getSession().put("kisStartTime", this.startTime);
			return SUCCESS;
		}
	}

	public GeneralARI getModel() {
		return general;
	}

}
