package com.geni.actions;

import org.apache.struts2.ServletActionContext;

import com.geni.services.User_Information_Service;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogin extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	private String regis_username;
	private String regis_password;
	User_Information_Service userService = new User_Information_Service();

	public String getRegis_username() {
		return regis_username;
	}

	public void setRegis_username(String regis_username) {
		this.regis_username = regis_username;
	}

	public String getRegis_password() {
		return regis_password;
	}

	public void setRegis_password(String regis_password) {
		this.regis_password = regis_password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInformation() throws Exception {
		// System.out.println(this.getUsername()+this.getPassword());
		if (userService.loginAccount(this.getUsername(), this.getPassword())) {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("emailid", this.getUsername());
			ServletActionContext.getResponse().getWriter().print("SUCCESS");
			return null;
		} else {
			ServletActionContext.getResponse().getWriter().print("ERROR");
			return null;
		}

	}

	public String registration() throws Exception {
		if (userService.addAccount(this.regis_username, this.regis_password) == true) {
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("emailid", this.getRegis_username());
			ServletActionContext.getResponse().getWriter().print("SUCCESS");
		} else {
			ServletActionContext.getResponse().getWriter().print("ERROR");
		}
		return null;
	}
}
