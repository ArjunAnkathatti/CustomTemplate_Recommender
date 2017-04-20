package com.geni.beans;

public class ApplicationReqIdentifier {
	
	private String userId;
	private GeneralARI generalARI;
	private NetworkARI networkARI;
	private StorageARI storageARI;
	private ComputationARI computationARI;
	private SoftwareARI softwareARI;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public GeneralARI getGeneralARI() {
		return generalARI;
	}
	public void setGeneralARI(GeneralARI generalARI) {
		this.generalARI = generalARI;
	}
	public NetworkARI getNetworkARI() {
		return networkARI;
	}
	public void setNetworkARI(NetworkARI networkARI) {
		this.networkARI = networkARI;
	}
	public StorageARI getStorageARI() {
		return storageARI;
	}
	public void setStorageARI(StorageARI storageARI) {
		this.storageARI = storageARI;
	}
	public ComputationARI getComputationARI() {
		return computationARI;
	}
	public void setComputationARI(ComputationARI computationARI) {
		this.computationARI = computationARI;
	}
	public SoftwareARI getSoftwareARI() {
		return softwareARI;
	}
	public void setSoftwareARI(SoftwareARI softwareARI) {
		this.softwareARI = softwareARI;
	}
	
	
}
