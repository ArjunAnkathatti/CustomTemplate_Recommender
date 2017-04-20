package com.geni.beans;

public class Template {
	private int templateId;
	private String fileReference;
	private String networkResource;
	private String networkResourceId;
	private int bandwidth;
	private float network_cost;
	private String networkCSP;
	private String storageResource;
	private String storageResourceId;
	private int storageSize;
	private String storageDisk;
	private float storageCost;
	private String storageCSP;
	private String computeResource;
	private String computeResourceId;
	private float computeCost;
	private String computeCSP;
	private float totalCost;

	public Template(int bandwidth, float nCost, int sSize, float sCost, float cCost) {
		this.bandwidth = bandwidth;
		this.network_cost = nCost;
		this.storageSize = sSize;
		this.storageCost = sCost;
		this.computeCost = cCost;

		this.totalCost = this.network_cost + this.storageCost + (computeCost*24*7*4);
	}

	
	public String getStorageDisk() {
		return storageDisk;
	}


	public void setStorageDisk(String storageDisk) {
		this.storageDisk = storageDisk;
	}


	public String getStorageResource() {
		return storageResource;
	}

	public void setStorageResource(String storageResource) {
		this.storageResource = storageResource;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getFileReference() {
		return fileReference;
	}

	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}

	public String getNetworkResource() {
		return networkResource;
	}

	public void setNetworkResource(String networkResource) {
		this.networkResource = networkResource;
	}

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public float getNetwork_cost() {
		return network_cost;
	}

	public void setNetwork_cost(float network_cost) {
		this.network_cost = network_cost;
	}

	public float getStorageCost() {
		return storageCost;
	}

	public void setStorageCost(float storageCost) {
		this.storageCost = storageCost;
	}

	public String getComputeResource() {
		return computeResource;
	}

	public void setComputeResource(String computeResource) {
		this.computeResource = computeResource;
	}

	public float getComputeCost() {
		return computeCost;
	}

	public void setComputeCost(float computeCost) {
		this.computeCost = computeCost;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public String getNetworkCSP() {
		return networkCSP;
	}

	public void setNetworkCSP(String networkCSP) {
		this.networkCSP = networkCSP;
	}

	public String getStorageCSP() {
		return storageCSP;
	}

	public void setStorageCSP(String storageCSP) {
		this.storageCSP = storageCSP;
	}

	public String getComputeCSP() {
		return computeCSP;
	}

	public void setComputeCSP(String computeCSP) {
		this.computeCSP = computeCSP;
	}

	public int getStorageSize() {
		return storageSize;
	}


	public String getNetworkResourceId() {
		return networkResourceId;
	}


	public void setNetworkResourceId(String networkResourceId) {
		this.networkResourceId = networkResourceId;
	}


	public String getStorageResourceId() {
		return storageResourceId;
	}


	public void setStorageResourceId(String storageResourceId) {
		this.storageResourceId = storageResourceId;
	}


	public String getComputeResourceId() {
		return computeResourceId;
	}


	public void setComputeResourceId(String computeResourceId) {
		this.computeResourceId = computeResourceId;
	}
	
	

}
