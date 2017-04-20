package com.geni.beans;

public class StorageCandidateResource extends CandidateResource{
	
	private int storageSize;
	private String ssd;


	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public String getSsd() {
		return ssd;
	}

	public void setSsd(String ssd) {
		this.ssd = ssd;
	}
	
	public String toString() {
		if (ssd.equalsIgnoreCase("yes")) {
			return storageSize + "Gb, SSD : " + getCsp();
		}
		return storageSize + "Gb, HDD : " + getCsp(); 
	}

}
