package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.geni.beans.StorageARI;
import com.geni.services.PrePopulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StorageRequirement extends ActionSupport implements ModelDriven<StorageARI> {

	private static final long serialVersionUID = 1L;

	private StorageARI storage = new StorageARI();
	private List<String> storageSizeList;
	private List<String> storageDiskList;
	private List<String> storageDataCenterList;
	
	public StorageARI getStorage() {
		return storage;
	}

	public void setStorage(StorageARI storage) {
		this.storage = storage;
	}

	public List<String> getStorageSizeList() {
		return storageSizeList;
	}

	public void setStorageSizeList(List<String> storageSizeList) {
		this.storageSizeList = storageSizeList;
	}

	public List<String> getStorageDiskList() {
		return storageDiskList;
	}

	public void setStorageDiskList(List<String> storageDiskList) {
		this.storageDiskList = storageDiskList;
	}

	public List<String> getStorageDataCenterList() {
		return storageDataCenterList;
	}

	public void setStorageDataCenterList(List<String> storageDataCenterList) {
		this.storageDataCenterList = storageDataCenterList;
	}


	public StorageRequirement() {
		storageSizeList = new ArrayList<String>();
		storageSizeList.add(getText("storageSizeList.opt1"));
		storageSizeList.add(getText("storageSizeList.opt2"));
		storageSizeList.add(getText("storageSizeList.opt3"));
		storageSizeList.add(getText("storageSizeList.opt4"));
		storageSizeList.add(getText("storageSizeList.opt5"));
		storageSizeList.add(getText("storageSizeList.opt6"));
		storageSizeList.add(getText("storageSizeList.opt7"));
		storageSizeList.add(getText("list.unknown"));

		storageDiskList = new ArrayList<String>();
		storageDiskList.add(getText("storageDiskList.hdd"));
		storageDiskList.add(getText("storageDiskList.ssd"));
		storageDiskList.add(getText("list.unknown"));
		
		storageDataCenterList = new ArrayList<String>();
		storageDataCenterList.add(getText("sdc.opt1"));
		storageDataCenterList.add(getText("sdc.opt2"));
		storageDataCenterList.add(getText("sdc.opt3"));
		storageDataCenterList.add(getText("sdc.opt4"));
	}

	public boolean isValid() {
		boolean val = true;
		if (storage.getStorageDisk().equals("null")) {
			addFieldError("localStorageSize", getText("error.storageSize"));
			val = false;
		}
		if (storage.getStorageDisk().equals("null")) {
			addFieldError("localStorageDisk", getText("error.storageDisk"));
			val = false;
		}
		if (storage.getStorageDataCenter().equals("null")) {
			addFieldError("storageDataCenter", getText("error.storageDataCenter"));
			val = false;
		}
		return val;
	}

	public String display() {
		ActionContext ctx = ActionContext.getContext();
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		StorageARI storage = PrePopulateService.getStorageReq(general);
		if (storage != null) {
			this.storage.setStorageSize(storage.getStorageSize());
			this.storage.setStorageDisk(storage.getStorageDisk());
		}
		return NONE;
	}

	public String setStorageReq() {

		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(storage.getStorageSize());
			System.out.println(storage.getStorageDisk());
			System.out.println(storage.getStorageDataCenter());

			String unknownVal = getText("list.unknown");
			// set default local storage disk type
			if (storage.getStorageDisk().equals(unknownVal)) {
				storage.setStorageDisk(getText("storageDiskList.hdd"));
			}

			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("storage", storage);

			return SUCCESS;
		}
	}

	@Override
	public StorageARI getModel() {
		return storage;
	}
}
