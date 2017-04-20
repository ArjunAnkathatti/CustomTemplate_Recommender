package com.geni.actions;

import java.util.List;
import java.util.Map;

import com.geni.beans.CandidateResource;
import com.geni.beans.ComputationARI;
import com.geni.beans.ComputeCandidateResource;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.beans.NetworkCandidateResource;
import com.geni.beans.SoftwareARI;
import com.geni.beans.StorageARI;
import com.geni.beans.StorageCandidateResource;
import com.geni.services.ARI_Generation_Service;
import com.geni.services.MacroOperatorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateARI extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int greenCost;
	private int goldCost;
	private int silverCost;

	private String greenNetwork;
	private String greenStorage;
	private String greenCompute;

	private String goldNetwork;
	private String goldStorage;
	private String goldCompute;

	private String silverNetwork;
	private String silverStorage;
	private String silverCompute;

	public int getGreenCost() {
		return greenCost;
	}

	public void setGreenCost(int greenCost) {
		this.greenCost = greenCost;
	}

	public int getGoldCost() {
		return goldCost;
	}

	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}

	public int getSilverCost() {
		return silverCost;
	}

	public void setSilverCost(int silverCost) {
		this.silverCost = silverCost;
	}

	public String getGreenNetwork() {
		return greenNetwork;
	}

	public void setGreenNetwork(String greenNetwork) {
		this.greenNetwork = greenNetwork;
	}

	public String getGreenStorage() {
		return greenStorage;
	}

	public void setGreenStorage(String greenStorage) {
		this.greenStorage = greenStorage;
	}

	public String getGreenCompute() {
		return greenCompute;
	}

	public void setGreenCompute(String greenCompute) {
		this.greenCompute = greenCompute;
	}

	public String getGoldNetwork() {
		return goldNetwork;
	}

	public void setGoldNetwork(String goldNetwork) {
		this.goldNetwork = goldNetwork;
	}

	public String getGoldStorage() {
		return goldStorage;
	}

	public void setGoldStorage(String goldStorage) {
		this.goldStorage = goldStorage;
	}

	public String getGoldCompute() {
		return goldCompute;
	}

	public void setGoldCompute(String goldCompute) {
		this.goldCompute = goldCompute;
	}

	public String getSilverNetwork() {
		return silverNetwork;
	}

	public void setSilverNetwork(String silverNetwork) {
		this.silverNetwork = silverNetwork;
	}

	public String getSilverStorage() {
		return silverStorage;
	}

	public void setSilverStorage(String silverStorage) {
		this.silverStorage = silverStorage;
	}

	public String getSilverCompute() {
		return silverCompute;
	}

	public void setSilverCompute(String silverCompute) {
		this.silverCompute = silverCompute;
	}

	public final String generateARI() {
		
		String flag = SUCCESS;

		System.out.println("inside generateARI() function of CreateARI class");

		ARI_Generation_Service ariService = new ARI_Generation_Service();

		ActionContext ctx = ActionContext.getContext();

		
		long kisStartTime = (long) ctx.getSession().remove("kisStartTime");
		long kisEndTime = System.currentTimeMillis();
		long kisTime = kisEndTime - kisStartTime;
		System.out.println("KIS Requ collection time" + kisTime);
		
		
		long compositionStartTime = System.currentTimeMillis();
		
		String emailID = (String) ctx.getSession().get("emailid");
		GeneralARI general = (GeneralARI) ctx.getSession().remove("general");
		NetworkARI network = (NetworkARI) ctx.getSession().remove("network");
		StorageARI storage = (StorageARI) ctx.getSession().remove("storage");
		ComputationARI computation = (ComputationARI) ctx.getSession().remove("computation");
		SoftwareARI software = (SoftwareARI) ctx.getSession().remove("software");

		int ariId = ariService.generateARI(emailID, general, network, storage, computation, software);
		if (ariId == -1) {
			System.out.println("ariId = -1 : ARI Generation failed");
			flag = ERROR;
		} else {
			MacroOperatorService macro_service = new MacroOperatorService();
			Map<String, List<CandidateResource>> finalTemplates = macro_service.generateMacroOperator(network, storage,
					computation, software, ariId);
			if (finalTemplates.isEmpty()) {
				System.out.println("no templates to present");
				flag = ERROR;
			} else {
				 /*
				 * CustomTemplateService ctService = new
				 * CustomTemplateService(); if (ctService.buildTemplate(general,
				 * network, storage, computation, software)) { System.out.
				 * println("CT_Sample.xml file is generated at Desktop location"
				 * ); } else { System.out.println("Template generation failed");
				 * flag = ERROR; }
				 */
				this.greenNetwork = ((NetworkCandidateResource) finalTemplates.get("green").get(0)).toString();
				this.greenStorage = ((StorageCandidateResource) finalTemplates.get("green").get(1)).toString();
				this.greenCompute = computation.getOperatingSystem() + ((ComputeCandidateResource) finalTemplates.get("green").get(2)).toString();
				this.greenCost = Math.round(finalTemplates.get("green").get(0).getCost() + 
						+ finalTemplates.get("green").get(1).getCost() 
						+ (finalTemplates.get("green").get(2).getCost() * 24 * 7 * 4));

				this.goldNetwork = ((NetworkCandidateResource) finalTemplates.get("gold").get(0)).toString();
				this.goldStorage = ((StorageCandidateResource) finalTemplates.get("gold").get(1)).toString();
				this.goldCompute = computation.getOperatingSystem() + ((ComputeCandidateResource) finalTemplates.get("gold").get(2)).toString();
				this.goldCost = Math.round(finalTemplates.get("gold").get(0).getCost() +
						+ finalTemplates.get("gold").get(1).getCost()  
						+ (finalTemplates.get("gold").get(2).getCost() * 24 * 7 * 4));
				
				this.silverNetwork = ((NetworkCandidateResource) finalTemplates.get("silver").get(0)).toString();
				this.silverStorage = ((StorageCandidateResource) finalTemplates.get("silver").get(1)).toString();
				this.silverCompute = computation.getOperatingSystem() + ((ComputeCandidateResource) finalTemplates.get("silver").get(2)).toString();
				this.silverCost =  Math.round(finalTemplates.get("silver").get(0).getCost() +
						+ finalTemplates.get("silver").get(1).getCost() 
						+ (finalTemplates.get("silver").get(2).getCost() * 24 * 7 * 4));
				
			}
		}
		long compositionEndTime   = System.currentTimeMillis();
		long compositionTime = compositionEndTime - compositionStartTime;
		System.out.println("Composition execution time" + compositionTime);
		return flag;
	}

}
