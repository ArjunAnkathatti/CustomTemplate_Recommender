package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.services.PrePopulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NetworkRequirement extends ActionSupport implements ModelDriven<NetworkARI> {

	private static final long serialVersionUID = 1L;

	private NetworkARI network = new NetworkARI();
	private List<String> yesOrNoList;
	private List<String> ipList;
	private List<String> networkTypeList;

	public NetworkARI getNetwork() {
		return network;
	}

	public void setNetwork(NetworkARI network) {
		this.network = network;
	}

	public List<String> getYesOrNoList() {
		return yesOrNoList;
	}

	public void setYesOrNoList(List<String> yesOrNoList) {
		this.yesOrNoList = yesOrNoList;
	}

	public List<String> getIpList() {
		return ipList;
	}

	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}

	public List<String> getNetworkTypeList() {
		return networkTypeList;
	}

	public void setNetworkTypeList(List<String> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public NetworkRequirement() {

		yesOrNoList = new ArrayList<String>();
		yesOrNoList.add(getText("list.yes"));
		yesOrNoList.add(getText("list.no"));
		yesOrNoList.add(getText("list.unknown"));

		ipList = new ArrayList<String>();
		ipList.add(getText("ip.public"));
		ipList.add(getText("ip.private"));
		ipList.add(getText("list.unknown"));

		networkTypeList = new ArrayList<String>();
		networkTypeList.add(getText("networkType.wired"));
		networkTypeList.add(getText("networkType.sdn"));
		networkTypeList.add(getText("list.unknown"));
	}

/*	public String getDefaultBandwidth() {
		return getText("bandwidth.opt1");
	}

	public String getDefaultVpn() {
		return getText("list.no");
	}

	public String getDefaultIp() {
		return getText("ip.public");
	}

	public String getDefaultNfv() {
		return getText("list.yes");
	}

	public String getDefaultNetworkType() {
		return getText("networkType.wired");
	}*/

	public boolean isValid() {
		boolean val = true;
		
		if (network.getVpn().equals("null")) {
			addFieldError("vpn", getText("error.vpn"));
			val = false;
		}
		if (network.getPublicIp().equals("null")) {
			addFieldError("publicIp", getText("error.publicIp"));
			val = false;
		}
		if (network.getFirewall().equals("null")) {
			addFieldError("firewall", getText("error.firewall"));
			val = false;
		}
		if (network.getSdn().equals("null")) {
			addFieldError("sdn", getText("error.sdn"));
		}
		/*if (network.getLayer().equals("null")) {
			addFieldError("layer", getText("error.layer"));
			val = false;
		}*/
		return val;
	}

	public String display() {
		ActionContext ctx = ActionContext.getContext();
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		NetworkARI network = PrePopulateService.getNetworkReq(general);
		if (network != null) {
			this.network.setVpn(network.getVpn());
			//this.network.setLayer(network.getLayer());
			this.network.setPublicIp(network.getPublicIp());
			this.network.setFirewall(network.getFirewall());
			this.network.setSdn(network.getSdn());
		}
		return NONE;
	}

	public String setNetworkReq() {

		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(network.getPublicIp());
			System.out.println(network.getVpn());
			//System.out.println(network.getLayer());
			System.out.println(network.getFirewall());
			System.out.println(network.getSdn());

			// set default isolated
			String unknownVal = getText("list.unknown");
			if (network.getVpn().equals(unknownVal)) {
				network.setVpn("No");
			}

			/*// set default layer
			if (network.getLayer().equals(unknownVal)) {
				network.setLayer("l3");
			}*/

			// set default ip
			if (network.getPublicIp().equals(unknownVal)) {
				network.setPublicIp("Yes");
			}

			// set default nfv
			if (network.getFirewall().equals(unknownVal)) {
				network.setFirewall("No");
			}

			// set default networkType
			if (network.getSdn().equals(unknownVal)) {
				network.setSdn("Yes");
			}

			/*// set isolated or vpn and layer
			if (network.getVpn().equals("yes") || network.getLayer().equals("l2")) {
				network.setLayer("l2");
			} else {
				network.setLayer("l3");
			}*/

			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("network", network);

			return SUCCESS;
		}
	}

	@Override
	public NetworkARI getModel() {
		return network;
	}

}
