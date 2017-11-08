package com.geni.rulebased.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GeneralRequirement extends ActionSupport implements ModelDriven<GeneralARI> {

	private static final long serialVersionUID = 1L;

	
	public boolean isValid() {
		boolean isValid = true;
		return isValid;
	}
	

	
	public String display() {
		return NONE;
	}
	
	public String setGeneralReq() {
		if (!isValid()) {
			return INPUT;
		} else {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("emailid", "arjun");
			return SUCCESS;
		}
	}

	public GeneralARI getModel() {
		return null;
	}

}
