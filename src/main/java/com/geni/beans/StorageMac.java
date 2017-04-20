package com.geni.beans;

public class StorageMac {
	private String resourceName;
	private String minStorage;
	private String maxStorage;
	private String ssd;
	private String storageCost;
	private String csp;
	private int resource_id;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getMinStorage() {
		return minStorage;
	}

	public void setMinStorage(String minStorage) {
		this.minStorage = minStorage;
	}

	public String getMaxStorage() {
		return maxStorage;
	}

	public void setMaxStorage(String maxStorage) {
		this.maxStorage = maxStorage;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}

	public String getStorageCost() {
		return storageCost;
	}

	public void setStorageCost(String storageCost) {
		this.storageCost = storageCost;
	}

	public String getCsp() {
		return csp;
	}

	public void setCsp(String csp) {
		this.csp = csp;
	}

	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}

}
