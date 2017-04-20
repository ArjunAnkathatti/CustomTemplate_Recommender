package com.geni.beans;

import java.util.Collection;

public class SoftwareMac {
	private String webServerRequired;
	private String webServer;
	private String dbServerRequired;
	private String databaseServer;
	private Collection<AdditionalSoftware> additionalSoftware;
	
	
	public String getWebServerRequired() {
		return webServerRequired;
	}
	public void setWebServerRequired(String webServerRequired) {
		this.webServerRequired = webServerRequired;
	}
	public String getWebServer() {
		return webServer;
	}
	public void setWebServer(String webServer) {
		this.webServer = webServer;
	}
	public String getDbServerRequired() {
		return dbServerRequired;
	}
	public void setDbServerRequired(String dbServerRequired) {
		this.dbServerRequired = dbServerRequired;
	}
	public String getDatabaseServer() {
		return databaseServer;
	}
	public void setDatabaseServer(String databaseServer) {
		this.databaseServer = databaseServer;
	}
	public Collection<AdditionalSoftware> getAdditionalSoftware() {
		return additionalSoftware;
	}
	public void setAdditionalSoftware(Collection<AdditionalSoftware> additionalSoftware) {
		this.additionalSoftware = additionalSoftware;
	}

}
