package com.geni.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geni.beans.CandidateResource;
import com.geni.beans.ComputationARI;
import com.geni.beans.ComputationQuery;
import com.geni.beans.ComputeCandidateResource;
import com.geni.beans.NetworkARI;
import com.geni.beans.NetworkCandidateResource;
import com.geni.beans.NetworkQuery;
import com.geni.beans.SoftwareARI;
import com.geni.beans.StorageARI;
import com.geni.beans.StorageCandidateResource;
import com.geni.beans.StorageQuery;
import com.geni.beans.Template;

import com.geni.dao.KnnDao;
import com.geni.dao.MacroOperatorDao;
import com.geni.dao.TemplateDao;

public class MacroOperatorService {
	
	private MacroOperatorDao macOpDao;
	private TemplateDao templateDao;
	private KnnService knnService;
	private ComputeMacOperatorService computeMacOpDao;
	//private ResourceSpaceDao rsd = new ResourceSpaceDao();
	
	public MacroOperatorService() {
		this.macOpDao = new MacroOperatorDao();
		this.computeMacOpDao = new ComputeMacOperatorService();
		this.templateDao = new TemplateDao();
		this.knnService = new KnnService();
	}

	// public MacroOperatorService(int apprId){
	// setMo(new MacroOperator());
	// setMod(new MacroOperatorDao());
	// this.MacroOperatorGeneration(apprId);
	// }

/*	public boolean MacroOperatorGeneration(NetworkARI network, StorageARI storage, ComputationARI computation, SoftwareARI software,String apprId) {
		String ack = null;

		List<List<String>> tempPreconditionFeaturesList = new ArrayList<List<String>>();
		String resourceClass = null;
		String resource = null;
		if (mod.getDataFromARI(apprId).equals("SUCCESS")) {
			tempPreconditionFeaturesList = mod.getPreconditionFeaturesList();
			for (int i = 0; i < tempPreconditionFeaturesList.size(); i++) {
				String[] features = tempPreconditionFeaturesList.get(i).get(0)
						.split(",");
				if (features.length > 1) {
					for (int j = 0; j < features.length; j++) {
						if (j == 0) {
							mo.setDomain(features[0]);
						} else {
							resourceClass = features[j];
							mo.setResource(resource = rsd.findRealResource(mo.getDomain(), resourceClass).size() != 0 ? resourceClass : null);
							mo.setPrecondition(tempPreconditionFeaturesList
									.get(i).get(1));
							mo.setApplicationIdentifie(apprId);
							mod.insertMacroOperator2Database(mo);
						}
					}
				} else if (features.length == 1) {
					mo.setDomain(features[0]);
					mo.setResource(null);
					mo.setPrecondition(tempPreconditionFeaturesList.get(i).get(
							1));
					mo.setApplicationIdentifie(apprId);
					mod.insertMacroOperator2Database(mo);
				}
			}
			return true;
		} else {
			return false;
		}
	}*/

	public Map<String,List<CandidateResource>> generateMacroOperator(NetworkARI networkARI, StorageARI storageARI, ComputationARI computationARI, SoftwareARI softwareARI, int ariId) {
		Collection<Template> templateList = new ArrayList<Template>();
		NetworkQuery nq = networkARI.getNetworkQuery();
		StorageQuery sq = storageARI.getStorageQuery();
		ComputationQuery cq = computationARI.getComputationQuery();
		
		NetworkCandidateResource [] nResources = null;
		StorageCandidateResource [] sResources = null;
		ComputeCandidateResource [] cResources = null;
		macOpDao = new MacroOperatorDao();
		nResources = macOpDao.getNetworkResource(nq);
		sResources = macOpDao.getStorageResource(sq);
		cResources = computeMacOpDao.getCandidateComputationResource(cq);
		
		if (nResources.length == 0) {
			System.out.println("no network reource found");
		} else {
			System.out.println("no of network resources : " + nResources.length);
		}
		
		if (sResources.length == 0) {
			System.out.println("no storage reource found");
		} else {
			System.out.println("no of storage resources : " + sResources.length);
		}
		
		if (cResources.length == 0) {
			System.out.println("no computation reource found");
		} else {
			System.out.println("no of computation resources : " + cResources.length);
		}
		Template t = null;
		NetworkCandidateResource ncr = null;
		StorageCandidateResource scr = null;
		ComputeCandidateResource ccr = null;
		
		
		for (int i =0; i < nResources.length; i++) {
			ncr = nResources[i];
			for (int j =0; j < sResources.length; j++) {
				scr = sResources[j];
				for (int k =0; k < cResources.length; k++) {
					ccr = cResources[k];
					if (ncr.getCsp().equalsIgnoreCase(ccr.getCsp())) {
						t = new Template(ccr.getMaxBandwidth(), ncr.getCost(), scr.getStorageSize() ,scr.getCost(), ccr.getCost());
						t.setNetworkResource(ncr.getResourceName());
						t.setNetworkCSP(ncr.getCsp());
						t.setNetworkResourceId(ncr.getResourceId());
						t.setStorageResource(scr.getResourceName());
						t.setStorageDisk(sq.getStorageDisk());
						t.setStorageCSP(scr.getCsp());
						t.setStorageResourceId(scr.getResourceId());
						t.setComputeResource(ccr.getResourceName());
						t.setComputeCSP(ccr.getCsp());
						t.setComputeResourceId(ccr.getResourceId());
						templateList.add(t);
						System.out.println(ncr.getResourceName() + " -> " + sResources[j].getResourceName() + " -> " + cResources[k].getResourceName());
					} else {
						System.out.println("network csp is different form compute csp");
					}
				}
			}
		}
		
		int macFlag = templateDao.insertTemplates(templateDao.getUniqueTemplates(templateList));
		if (macFlag == -1) {
			System.out.println("MacOp template insertion failed");
		} else {
			System.out.println("MacOp templates succesfully inserted into catalog table");
		}
		
		String [] n_resource_ids = new String[nResources.length];
		String [] s_resource_ids = new String[sResources.length];
		String [] c_resource_ids = new String[cResources.length];
		
		for (int i=0; i < nResources.length; i++) {
			n_resource_ids[i] = nResources[i].getResourceId();
		}
		for (int i=0; i < sResources.length; i++) {
			s_resource_ids[i] = sResources[i].getResourceId();
		}
		for (int i=0; i < cResources.length; i++) {
			c_resource_ids[i] = cResources[i].getResourceId();
		}
		
		return knnService.getNearestTemplates(n_resource_ids, cq.getvCPU(), cq.getRam(), cq.getLocalStorage(), cq.getBandwidth(), s_resource_ids, sq.getStorageSize() , sq.getStorageDisk(), c_resource_ids);
		//Map<String,List<CandidateResource>> temp = new HashMap<String,List<CandidateResource>>(); 
		//return temp;
	}
	

}
