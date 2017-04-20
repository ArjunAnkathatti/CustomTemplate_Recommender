package com.geni.services;

import com.geni.beans.*;

import com.geni.dao.ARI_Dao;

public class ARI_Generation_Service {
	ARI_Dao ARI_Dao = new ARI_Dao();
	
	public int generateARI(String emailId, GeneralARI general, NetworkARI network, StorageARI storage, ComputationARI computation, SoftwareARI software) {
		ApplicationReqIdentifier ari = new ApplicationReqIdentifier();
		ari.setUserId(emailId);
		ari.setGeneralARI(general);
		ari.setNetworkARI(network);
		ari.setStorageARI(storage);
		ari.setComputationARI(computation);
		ari.setSoftwareARI(software);
		//return ARI_Dao.insertARIIntoMango(ari);
		return ARI_Dao.insertARIIntoMySql(ari);
	}
	
}
