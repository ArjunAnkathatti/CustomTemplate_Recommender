package com.geni.beans;

public class NetworkARI {

	private String vpn;
	private String layer; // layer 2, layer 3, and all (mapped to isolated
							// network)
	private String publicIp;
	private String firewall;
	private String sdn; // SDN or Wired

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

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public NetworkQuery getNetworkQuery() {
		NetworkQuery nq = new NetworkQuery();
		nq.setPublicIp(this.publicIp);
		nq.setFirewall(this.firewall);
		nq.setVpn(this.vpn);
		nq.setSdn(this.sdn);
		return nq;
	}

}
