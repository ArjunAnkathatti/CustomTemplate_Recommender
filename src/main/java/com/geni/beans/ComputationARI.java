package com.geni.beans;

public class ComputationARI {

	private String noOfNodes;
	private int bandwidth;
	private int noOfCores; // no. of VM or cores
	private int localStorage;
	private String operatingSystem; // Windows Server 2008R2, Windows Server 7,
	private String dedicatedServer;
	private double ramSize; // size of the ram in Mb or Gb
	private String gpu; // yes or no
	private String gpuSize; // need gpu or not
	private String computeDataCenter;

	public String getNoOfNodes() {
		return noOfNodes;
	}

	public void setNoOfNodes(String noOfNodes) {
		this.noOfNodes = noOfNodes;
	}
	

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public int getNoOfCores() {
		return noOfCores;
	}

	public void setNoOfCores(int noOfCores) {
		this.noOfCores = noOfCores;
	}
	
	public int getLocalStorage() {
		return localStorage;
	}

	public void setLocalStorage(int localStorage) {
		this.localStorage = localStorage;
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

	public double getRamSize() {
		return ramSize;
	}

	public void setRamSize(double ramSize) {
		this.ramSize = ramSize;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getGpuSize() {
		return gpuSize;
	}

	public void setGpuSize(String gpuSize) {
		this.gpuSize = gpuSize;
	}
	
	public String getComputeDataCenter() {
		return computeDataCenter;
	}

	public void setComputeDataCenter(String computeDataCenter) {
		this.computeDataCenter = computeDataCenter;
	}

	public ComputationQuery getComputationQuery() {
		ComputationQuery cq = new ComputationQuery();
		cq.setvCPU(this.noOfCores);
		cq.setBandwidth(this.bandwidth);
		cq.setRam(this.getRamSize());
		cq.setOs(this.operatingSystem);
		return cq;
	}
}
