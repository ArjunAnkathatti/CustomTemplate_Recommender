package com.geni.beans;

public class ComputationQuery {
	private int bandwidth;
	private int vCPU;
	private double ram;
	private int localStorage;
	private String storageType;
	private String os;
	private String gpu;
	private int gpuCores;
	private String dedicatedServer;

	public int getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public int getvCPU() {
		return vCPU;
	}

	public void setvCPU(int vCPU) {
		this.vCPU = vCPU;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public int getGpuCores() {
		return gpuCores;
	}

	public void setGpuCores(int gpuCores) {
		this.gpuCores = gpuCores;
	}

	public String getDedicatedServer() {
		return dedicatedServer;
	}

	public void setDedicatedServer(String dedicatedServer) {
		this.dedicatedServer = dedicatedServer;
	}

	public int getLocalStorage() {
		return localStorage;
	}

	public void setLocalStorage(int localStorage) {
		this.localStorage = localStorage;
	}
	

}
