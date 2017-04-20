package com.geni.beans;

public class NetworkCandidateResource extends CandidateResource {

	private String publicIp;
	private String vpn;
	private String firewall;
	private String sdn;

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
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

	public String toString() {
		String ip = (this.publicIp.equalsIgnoreCase("yes")) ? "Public IP " : "Private IP ";
		String f = (this.firewall.equalsIgnoreCase("yes")) ? "Firewall " : "";
		String v = (this.vpn.equalsIgnoreCase("yes")) ? "VPN " : "";
		String s = (this.sdn.equalsIgnoreCase("yes")) ? "SDN" : "";
		return ip + f + v + s + " : " + getCsp();
	}

}
