package com.geni.beans;

import java.util.Collection;

public class SoftwareARI {
	
	private String webServerRequired;
	private String webServer;
	private String dbServerRequired;
	private String databaseServer;
	private Collection<AdditionalSoftware> additionalSoftware;
	
	private int prefCores;
	private int prefRAM;
	private int prefLocalStorage;
	private int prefBandwidth;
	private int prefStorage;
	
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
	public int getPrefCores() {
		return prefCores;
	}
	public void setPrefCores(int prefCores) {
		this.prefCores = prefCores;
	}
	public int getPrefRAM() {
		return prefRAM;
	}
	public void setPrefRAM(int prefRAM) {
		this.prefRAM = prefRAM;
	}
	public int getPrefLocalStorage() {
		return prefLocalStorage;
	}
	public void setPrefLocalStorage(int prefLocalStorage) {
		this.prefLocalStorage = prefLocalStorage;
	}
	public int getPrefBandwidth() {
		return prefBandwidth;
	}
	public void setPrefBandwidth(int prefBandwidth) {
		this.prefBandwidth = prefBandwidth;
	}
	public int getPrefStorage() {
		return prefStorage;
	}
	public void setPrefStorage(int prefStorage) {
		this.prefStorage = prefStorage;
	}
	
	
	
}
