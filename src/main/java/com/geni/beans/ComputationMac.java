package com.geni.beans;

public class ComputationMac {

	private String resourceName;
	private String noOfCores;
	private String operatingSystem;
	private String dedicatedServer;
	private float ramSize;
	private int localStorage;
	private String gpuSize; // need gpu or not
	private float linuxCost;
	private float rhelCost;
	private float windowsCost;
	private float suseCost;
	private int resource_id;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getNoOfCores() {
		return noOfCores;
	}

	public void setNoOfCores(String noOfCores) {
		this.noOfCores = noOfCores;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getDedicatedServer() {
		return dedicatedServer;
	}

	public void setDedicatedServer(String dedicatedServer) {
		this.dedicatedServer = dedicatedServer;
	}

	public float getRamSize() {
		return ramSize;
	}

	public void setRamSize(float ramSize) {
		this.ramSize = ramSize;
	}

	public int getLocalStorage() {
		return localStorage;
	}

	public void setLocalStorage(int localStorage) {
		this.localStorage = localStorage;
	}

	public String getGpuSize() {
		return gpuSize;
	}

	public void setGpuSize(String gpuSize) {
		this.gpuSize = gpuSize;
	}

	public float getLinuxCost() {
		return linuxCost;
	}

	public void setLinuxCost(float linuxCost) {
		this.linuxCost = linuxCost;
	}

	public float getRhelCost() {
		return rhelCost;
	}

	public void setRhelCost(float rhelCost) {
		this.rhelCost = rhelCost;
	}

	public float getWindowsCost() {
		return windowsCost;
	}

	public void setWindowsCost(float windowsCost) {
		this.windowsCost = windowsCost;
	}

	public float getSuseCost() {
		return suseCost;
	}

	public void setSuseCost(float suseCost) {
		this.suseCost = suseCost;
	}

	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}

}
