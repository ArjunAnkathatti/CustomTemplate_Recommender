package com.geni.actions;

import java.util.ArrayList;
import java.util.List;


import com.geni.beans.SoftwareARI;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SoftwareRequirement extends ActionSupport implements ModelDriven<SoftwareARI>{

	private static final long serialVersionUID = 1L;
	
	
	private SoftwareARI software = new SoftwareARI();
	private List<String> yesOrNoList;
 	private List<String> webServerList;
	private List<String> dbServerList;
	
	private List<Integer> prefList;

	
	public List<String> getYesOrNoList() {
		return yesOrNoList;
	}
	public void setYesOrNoList(List<String> yesOrNoList) {
		this.yesOrNoList = yesOrNoList;
	}
	public List<String> getWebServerList() {
		return webServerList;
	}
	public void setWebServerList(List<String> webServerList) {
		this.webServerList = webServerList;
	}
	public List<String> getDbServerList() {
		return dbServerList;
	}
	public void setDbServerList(List<String> dbServerList) {
		this.dbServerList = dbServerList;
	}
	public SoftwareARI getSoftware() {
		return software;
	}
	public void setSoftware(SoftwareARI software) {
		this.software = software;
	}
	public List<Integer> getPrefList() {
		return prefList;
	}
	public void setPrefList(List<Integer> prefList) {
		this.prefList = prefList;
	}
	public SoftwareRequirement() {
		yesOrNoList = new ArrayList<String>();
		yesOrNoList.add(getText("list.no"));
		yesOrNoList.add(getText("list.yes"));
		
		webServerList = new ArrayList<String>();
		webServerList.add(getText("web.none"));
		webServerList.add(getText("web.apache"));
		webServerList.add(getText("web.gws"));
		webServerList.add(getText("web.nginx"));
		
		dbServerList = new ArrayList<String>();
		dbServerList.add(getText("db.none"));
		dbServerList.add(getText("db.mysql"));
		dbServerList.add(getText("db.postgreSql"));
		dbServerList.add(getText("db.maria"));
		
		prefList = new ArrayList<Integer>();
		prefList.add(1);
		prefList.add(2);
		prefList.add(3);
		prefList.add(4);
	}
	
	public String getDefaultWebServer() {
		return getText("web.apache");
	}
	public String getDefaultDBServer() {
		return getText("db.mysql");
	}
	
	public boolean isValid() {
		boolean val = true;
		if (software.getWebServerRequired().equals(getText("list.yes"))) {
			if (software.getWebServer().equals("null") || software.getWebServer().isEmpty()) {
				addFieldError("webServer", getText("error.webServer"));
				val = false;
			}
		}
		if (software.getDbServerRequired().equals(getText("list.yes"))) {
			if (software.getDatabaseServer().equals("null") || software.getDatabaseServer().isEmpty()) {
				addFieldError("databaseServer", getText("error.dbServer"));
				val = false;
			}
		}
		return val;
	}
	
	public String display() {
		this.software.setWebServerRequired(getText("list.yes"));
		this.software.setDbServerRequired(getText("list.yes"));
		return NONE;
	}
	
	public String setSoftwareReq() {
		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(software.getWebServerRequired());
			System.out.println(software.getWebServer());
			System.out.println(software.getDbServerRequired());
			System.out.println(software.getDatabaseServer());
			
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("software", software);
			return SUCCESS;
		}
	}

	public SoftwareARI getModel() {
		return software;
	}
}
