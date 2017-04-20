package com.geni.beans;

public class NetworkQuery {
	private String publicIp;
	private String firewall;
	private String vpn;
	private String sdn;

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getFirewall() {
		return firewall;
	}

	public void setFirewall(String firewall) {
		this.firewall = firewall;
	}

	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getSdn() {
		return sdn;
	}

	public void setSdn(String sdn) {
		this.sdn = sdn;
	}

}
