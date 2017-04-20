package com.geni.beans;

public class ComputeCandidateResource extends CandidateResource{
	
	private float ram;
	private int vCpu;
	private int minBandwidth;
	private int maxBandwidth;
	private String gpu;
	private String storageType;
	private int storageSize;
	private String os;

	
	public int getMinBandwidth() {
		return minBandwidth;
	}

	public void setMinBandwidth(int minBandwidth) {
		this.minBandwidth = minBandwidth;
	}

	public int getMaxBandwidth() {
		return maxBandwidth;
	}

	public void setMaxBandwidth(int maxBandwidth) {
		this.maxBandwidth = maxBandwidth;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public float getRam() {
		return ram;
	}

	public void setRam(float ram) {
		this.ram = ram;
	}

	public int getvCpu() {
		return vCpu;
	}

	public void setvCpu(int vCpu) {
		this.vCpu = vCpu;
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

	public String toString() {
		return  "Linux , " + vCpu + " cores, " + ram + " GB RAM, " + storageSize + " GB " + storageType 
				+ "Up to : " + maxBandwidth + " Mbps n/w bandwidth" +" : " + getCsp();
	}
}
