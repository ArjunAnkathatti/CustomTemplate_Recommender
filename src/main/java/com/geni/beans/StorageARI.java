package com.geni.beans;

public class StorageARI {

	private int storageSize;
	private String storageDisk; // HDD , SSD
	private String storageDataCenter;

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public String getStorageDisk() {
		return storageDisk;
	}

	public void setStorageDisk(String storageDisk) {
		this.storageDisk = storageDisk;
	}

	public String getStorageDataCenter() {
		return storageDataCenter;
	}

	public void setStorageDataCenter(String storageDataCenter) {
		this.storageDataCenter = storageDataCenter;
	}

	public StorageQuery getStorageQuery() {
		StorageQuery sq = new StorageQuery();
		sq.setStorageSize(this.getStorageSize());
		sq.setStorageDisk(this.storageDisk);
		return sq;
	}
}
