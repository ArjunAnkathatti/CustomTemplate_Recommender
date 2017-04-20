package com.geni.beans;

public class ResourceSpace {
	private int rid;
	private String domain;
	private String resource;
	private String rconstraint;
	private float cost;
	

	public int getRid() {
		return rid;
	}
	public String getDomain() {
		return domain;
	}
	public String getResource() {
		return resource;
	}
	public String getRconstraint() {
		return rconstraint;
	}
	public float getCost() {
		return cost;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public void setRconstraint(String rconstraint) {
		this.rconstraint = rconstraint;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
}
