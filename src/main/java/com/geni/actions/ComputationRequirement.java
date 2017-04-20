package com.geni.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.services.PrePopulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ComputationRequirement extends ActionSupport implements ModelDriven<ComputationARI> {

	private static final long serialVersionUID = 1L;

	private ComputationARI computation = new ComputationARI();
	private List<String> noOfNodesList;
	private TreeMap<Integer, String> bandwidthList;
	private List<Number> noOfCoresList;
	private List<String> yesOrNoList;
	private List<String> osList;
	private TreeMap<Double, String> ramSizeList;
	private TreeMap<String, Object> gpuMap;
	private List<String> gpuSizeList;
	private TreeMap<Integer, String> localStorageMap;
	private List<String> computeDataCenterList;

	public List<String> getNoOfNodesList() {
		return noOfNodesList;
	}

	public void setNoOfNodesList(List<String> noOfNodesList) {
		this.noOfNodesList = noOfNodesList;
	}

	public TreeMap<Integer, String> getBandwidthList() {
		return bandwidthList;
	}

	public void setBandwidthList(TreeMap<Integer, String> bandwidthList) {
		this.bandwidthList = bandwidthList;
	}

	@SuppressWarnings("rawtypes")
	public TreeMap getGpuMap() {
		return gpuMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setGpuMap(TreeMap gpuMap) {
		this.gpuMap = gpuMap;
	}

	public List<String> getGpuSizeList() {
		return gpuSizeList;
	}

	public void setGpuSizeList(List<String> gpuSizeList) {
		this.gpuSizeList = gpuSizeList;
	}

	public List<Number> getNoOfCoresList() {
		return noOfCoresList;
	}

	public void setNoOfCoresList(List<Number> noOfCoresList) {
		this.noOfCoresList = noOfCoresList;
	}

	public List<String> getYesOrNoList() {
		return yesOrNoList;
	}

	public void setYesOrNoList(List<String> yesOrNoList) {
		this.yesOrNoList = yesOrNoList;
	}

	public List<String> getOsList() {
		return osList;
	}

	public void setOsList(List<String> osList) {
		this.osList = osList;
	}

	public TreeMap<Double, String> getRamSizeList() {
		return ramSizeList;
	}

	public void setRamSizeList(TreeMap<Double, String> ramSizeList) {
		this.ramSizeList = ramSizeList;
	}

	public ComputationARI getComputation() {
		return computation;
	}

	public void setComputation(ComputationARI computation) {
		this.computation = computation;
	}

	public TreeMap<Integer, String> getLocalStorageMap() {
		return localStorageMap;
	}

	public void setLocalStorageMap(TreeMap<Integer, String> localStorageMap) {
		this.localStorageMap = localStorageMap;
	}

	public List<String> getComputeDataCenterList() {
		return computeDataCenterList;
	}

	public void setComputeDataCenterList(List<String> computeDataCenterList) {
		this.computeDataCenterList = computeDataCenterList;
	}

	public ComputationRequirement() {

		noOfNodesList = new ArrayList<String>();
		noOfNodesList.add("1");
		noOfNodesList.add("2");
		noOfNodesList.add("3");
		noOfNodesList.add("4");
		noOfNodesList.add(getText("list.unknown"));

		bandwidthList = new TreeMap<Integer, String>();
		bandwidthList.put(30, getText("bandwidth.opt1"));
		bandwidthList.put(100, getText("bandwidth.opt2"));
		bandwidthList.put(450, getText("bandwidth.opt3"));
		bandwidthList.put(1500, getText("bandwidth.opt4"));
		bandwidthList.put(10000, getText("bandwidth.opt5"));
		bandwidthList.put(20000, getText("bandwidth.opt6"));

		noOfCoresList = new ArrayList<>();
		noOfCoresList.add(1);
		noOfCoresList.add(2);
		noOfCoresList.add(3);
		noOfCoresList.add(4);
		noOfCoresList.add(5);
		noOfCoresList.add(6);
		noOfCoresList.add(7);
		noOfCoresList.add(8);
		noOfCoresList.add(9);
		noOfCoresList.add(10);
		noOfCoresList.add(12);
		// noOfCoresList.add(getText("list.unknown"));

		yesOrNoList = new ArrayList<String>();
		yesOrNoList.add(getText("list.no"));
		yesOrNoList.add(getText("list.yes"));
		yesOrNoList.add(getText("list.unknown"));

		osList = new ArrayList<String>();
		osList.add(getText("os.linux"));
		osList.add(getText("os.rhel"));
		osList.add(getText("os.windows"));
		osList.add(getText("os.suse"));
		osList.add(getText("list.unknown"));

		ramSizeList = new TreeMap<Double, String>();
		ramSizeList.put(0.75, getText("ram.opt1"));
		ramSizeList.put(1.5, getText("ram.opt2"));
		ramSizeList.put(3.5, getText("ram.opt3"));
		ramSizeList.put(7.0, getText("ram.opt4"));
		ramSizeList.put(12.0, getText("ram.opt5"));
		ramSizeList.put(14.5, getText("ram.opt6"));
		ramSizeList.put(28.0, getText("ram.opt7"));
		ramSizeList.put(58.0, getText("ram.opt8"));
		ramSizeList.put(113.0, getText("ram.opt9"));
		ramSizeList.put(150.0, getText("ram.opt10"));
		ramSizeList.put(236.0, getText("ram.opt11"));
		ramSizeList.put(468.0, getText("ram.opt12"));
		ramSizeList.put(850.0, getText("ram.opt13"));
		ramSizeList.put(2000.0, getText("ram.opt14"));

		gpuSizeList = new ArrayList<String>();
		gpuSizeList.add(getText("gpu.opt1"));
		gpuSizeList.add(getText("gpu.opt2"));
		gpuSizeList.add(getText("gpu.opt3"));
		gpuSizeList.add(getText("gpu.opt4"));
		gpuSizeList.add(getText("gpu.opt5"));
		gpuSizeList.add(getText("gpu.opt6"));
		gpuSizeList.add(getText("gpu.opt7"));
		gpuSizeList.add(getText("list.unknown"));

		gpuMap = new TreeMap<String, Object>();
		gpuMap.put(getText("list.no"), "Not Applicable");
		gpuMap.put(getText("list.yes"), gpuSizeList);
		gpuMap.put(getText("list.unknown"), "Not Applicable");
		
		localStorageMap = new TreeMap<Integer, String>();
		localStorageMap.put(5, getText("localStorage.opt1"));
		localStorageMap.put(15, getText("localStorage.opt2"));
		localStorageMap.put(50, getText("localStorage.opt3"));
		localStorageMap.put(105, getText("localStorage.opt4"));
		localStorageMap.put(180, getText("localStorage.opt5"));
		localStorageMap.put(280, getText("localStorage.opt6"));
		localStorageMap.put(370, getText("localStorage.opt7"));
		localStorageMap.put(700, getText("localStorage.opt8"));
		localStorageMap.put(1000, getText("localStorage.opt9"));
		localStorageMap.put(1750, getText("localStorage.opt10"));
		localStorageMap.put(3000, getText("localStorage.opt11"));
		localStorageMap.put(6000, getText("localStorage.opt12"));
		localStorageMap.put(12000, getText("localStorage.opt13"));
		localStorageMap.put(24000, getText("localStorage.opt14"));
		localStorageMap.put(48000, getText("localStorage.opt15"));
		
		computeDataCenterList = new ArrayList<String>();
		computeDataCenterList.add(getText("cdc.opt1"));
		computeDataCenterList.add(getText("cdc.opt2"));
		computeDataCenterList.add(getText("cdc.opt3"));
		computeDataCenterList.add(getText("cdc.opt4"));

	}

	/*
	 * public String getDefaultNoOfCores() { return "1"; } public String
	 * getDefaultDedicatedServer() { return getText("list.no"); } public String
	 * getDefaultOs() { return getText("os.ubuntu14"); } public String
	 * getDefaultOsArch() { return getText("osArch.64bit"); } public String
	 * getDefaultRamSize() { return getText("ram.opt1"); } public String
	 * getDefaultGpu() { return getText("list.no"); } public String
	 * getDefaultGpuSize() { return getText("gpu.opt1"); }
	 */

	public boolean isValid() {
		boolean val = true;
		if (computation.getNoOfCores() == -1) {
			addFieldError("noOfCores", getText("error.noOfCores"));
			val = false;
		}
		if (computation.getBandwidth() == -1) {
			addFieldError("bandwidth", getText("error.bandwidth"));
			val = false;
		}
		if (computation.getDedicatedServer().equals("null")) {
			addFieldError("dedicatedServer", getText("error.dedicatedServer"));
			val = false;
		}
		if (computation.getOperatingSystem().equals("null")) {
			addFieldError("operatingSystem", getText("error.os"));
			val = false;
		}
		if (computation.getRamSize() == -1) {
			addFieldError("ramSize", getText("error.ramSize"));
			val = false;
		}
		if (computation.getLocalStorage() == -1) {
			addFieldError("localStorage", getText("error.localStorage"));
			val = false;
		}
		if (computation.getGpu().equals("null")) {
			addFieldError("gpu", getText("error.gpu"));
			val = false;
		}
		if (computation.getComputeDataCenter().equals("null")) {
			addFieldError("computeDataCenter", getText("error.computeDataCenter"));
			val = false;
		}
		/*
		 * if (computation.getGpuSize().equals("null")) {
		 * addFieldError("gpuSize", getText("error.gpuSize")); val = false; }
		 */
		return val;
	}

	public String display() {
		ActionContext ctx = ActionContext.getContext();
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		ComputationARI computation = PrePopulateService.getComputationReq(general);
		if (computation != null) {
			this.computation.setNoOfNodes(computation.getNoOfNodes());
			this.computation.setNoOfCores(computation.getNoOfCores());
			this.computation.setDedicatedServer(computation.getDedicatedServer());
			this.computation.setRamSize(computation.getRamSize());
			this.computation.setOperatingSystem(computation.getOperatingSystem());
			this.computation.setGpu(computation.getGpu());
			// this.computation.setGpuSize(computation.getGpuSize());
		}
		return NONE;
	}

	public String setComputationReq() {

		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(computation.getNoOfCores());
			System.out.println(computation.getDedicatedServer());
			System.out.println(computation.getOperatingSystem());
			System.out.println(computation.getRamSize());
			System.out.println(computation.getGpu());
			System.out.println(computation.getGpuSize());
			System.out.println(computation.getLocalStorage());
			System.out.println(computation.getComputeDataCenter());

			// set default vm cores
			if (computation.getNoOfCores() == -1) {
				computation.setNoOfCores(1);
			}
			
			// set default vm cores
						if (computation.getBandwidth() == 0) {
							computation.setBandwidth(30);
						}

			// set default dedicated server
			if (computation.getDedicatedServer().equals("null")) {
				computation.setDedicatedServer("No");
			}

			// set default operating system
			if (computation.getOperatingSystem().equals("null")) {
				computation.setOperatingSystem("Linux");
			}
			

			// set default GPU
			if (computation.getGpu().equals("null")) {
				computation.setGpu("No");
			}

			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("computation", computation);
			ctx.getSession().put("nodes", computation.getNoOfNodes());

			return SUCCESS;

			/*
			 * //generate ARI if(this.generateARI() == true){ return SUCCESS;
			 * }else{ return ERROR; }
			 */
		}

	}

	@Override
	public ComputationARI getModel() {
		return computation;
	}

}
