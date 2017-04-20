package com.geni.beans;

public class NetworkMac {
	private String resourceName;
	private String minBandwidth;
	private String maxBandwidth;
	private String vpn;
	private String firewall;
	private String sdn;
	private String csp;
	private float networkCost;
	private int resource_id;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getMinBandwidth() {
		return minBandwidth;
	}

	public void setMinBandwidth(String minBandwidth) {
		this.minBandwidth = minBandwidth;
	}

	public String getMaxBandwidth() {
		return maxBandwidth;
	}

	public void setMaxBandwidth(String maxBandwidth) {
		this.maxBandwidth = maxBandwidth;
	}

	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getFirewall() {
		return firewall;
	}

	public void setFirewall(String firewall) {
		this.firewall = firewall;
	}

	public String getSdn() {
		return sdn;
	}

	public void setSdn(String sdn) {
		this.sdn = sdn;
	}

	public String getCsp() {
		return csp;
	}

	public void setCsp(String csp) {
		this.csp = csp;
	}

	public float getNetworkCost() {
		return networkCost;
	}

	public void setNetworkCost(float networkCost) {
		this.networkCost = networkCost;
	}

	public int getResource_id() {
		return resource_id;
	}

	public void setResource_id(int resource_id) {
		this.resource_id = resource_id;
	}

}
