package com.geni.services;

import java.io.InputStream;
import java.util.Properties;

import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.beans.StorageARI;

public class PrePopulateService {
	public static Properties prop;
	public static InputStream is; 
	
	private static final String appKind_commonApp = "Web Application";
	private static final String appKind_dataIntensiveApp = "Data Intensive";
	private static final String appKind_missionCriticalApp = "Mission-critical";
	private static final String appKind_streamingApp = "Live/Streaming Application";
	private static final String appKind_virtualDesktop = "Virtual Desktop";
	
	private static final String appPriority_performance = "High Performance";
	private static final String appPriority_availability = "High Availability";
	private static final String appPriority_throughput = "High Throughput";

	public static final NetworkARI getNetworkReq(GeneralARI general) {
		
		NetworkARI network;
		String appKind = general.getAppKind();
		String appPriority = general.getAppPriority();

		if (appKind.equals(appKind_commonApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				//network.setBandwidth("10-20 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_performance)) {
				//network.setBandwidth("10-20 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//network.setBandwidth("20-50 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			}
		} else if (appKind.equals(appKind_dataIntensiveApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				//network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("No");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_performance)) {
				//network.setBandwidth("20-50 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("No");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			}
		} else if (appKind.equals(appKind_missionCriticalApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				//network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_performance)) {
				//network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//network.setBandwidth("10 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l2");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			}
		} else if (appKind.equals(appKind_streamingApp)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				//network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_performance)) {
				//network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l2");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//network.setBandwidth("10 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("Yes");
				network.setFirewall("No");
				network.setSdn("Yes");
			}
		} else if (appKind.equals(appKind_virtualDesktop)) {
			network = new NetworkARI();
			if (appPriority.equals(appPriority_availability)) {
				//network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("No");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_performance)) {
				//network.setBandwidth("50-100 Mbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("No");
				network.setFirewall("No");
				network.setSdn("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//network.setBandwidth("1 Gbps (xy Gb data in t seconds)");
				network.setVpn("No");
				network.setLayer("l3");
				network.setPublicIp("No");
				network.setFirewall("No");
				network.setSdn("Yes");
			}
		} else {
			network = null;
		}
		return network;

	}
	
	public static final StorageARI getStorageReq(GeneralARI general) {
		StorageARI storage;
		String appKind = general.getAppKind();
		String appPriority = general.getAppPriority();

		if (appKind.equals(appKind_commonApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				//storage.setStorageSize("5GB");
				storage.setStorageSize(5);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_performance)) {
				//storage.setStorageSize("5GB");
				storage.setStorageSize(5);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_throughput)) {
				//storage.setStorageSize("5GB");
				storage.setStorageSize(5);
				storage.setStorageDisk("No");
			}
		} else if (appKind.equals(appKind_dataIntensiveApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				//storage.setStorageSize("10GB - 20GB");
				storage.setStorageSize(20);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_performance)) {
				//storage.setStorageSize("5GB - 10GB");
				storage.setStorageSize(10);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_throughput)) {
				//storage.setStorageSize("5GB - 10GB");
				storage.setStorageSize(10);
				storage.setStorageDisk("No");
			}
		} else if (appKind.equals(appKind_missionCriticalApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				//storage.setStorageSize("100GB - 250GB");
				storage.setStorageSize(200);
				storage.setStorageDisk("Yes");
			} else if (appPriority.equals(appPriority_performance)) {
				//storage.setStorageSize("50GB - 100GB");
				storage.setStorageSize(100);
				storage.setStorageDisk("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//storage.setStorageSize("50GB - 100GB");
				storage.setStorageSize(100);
				storage.setStorageDisk("Yes");
			}
		} else if (appKind.equals(appKind_streamingApp)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				//storage.setStorageSize("500GB - 1TB");
				storage.setStorageSize(1000);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_performance)) {
				//storage.setStorageSize("250GB - 500GB");
				storage.setStorageSize(500);
				storage.setStorageDisk("Yes");
			} else if (appPriority.equals(appPriority_throughput)) {
				//storage.setStorageSize("250GB - 500GB");
				storage.setStorageSize(500);
				storage.setStorageDisk("Yes");
			}
		} else if (appKind.equals(appKind_virtualDesktop)) {
			storage = new StorageARI();
			if (appPriority.equals(appPriority_availability)) {
				//storage.setStorageSize("5GB");
				storage.setStorageSize(5);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_performance)) {
				//storage.setStorageSize("5GB");
				storage.setStorageSize(5);
				storage.setStorageDisk("No");
			} else if (appPriority.equals(appPriority_throughput)) {
				//storage.setStorageSize("5GB");
				storage.setStorageSize(5);
				storage.setStorageDisk("No");
			}
		} else {
			storage = null;
		}
		return storage;

	}
	
	public static final ComputationARI getComputationReq(GeneralARI general) {
		ComputationARI computation;
		String appKind = general.getAppKind();
		String appPriority = general.getAppPriority();

		if (appKind.equals(appKind_commonApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("2");
				computation.setNoOfCores(2);
				computation.setDedicatedServer("No");
				computation.setRamSize(1.5);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(3);
				computation.setDedicatedServer("No");
				computation.setRamSize(3.5);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(2);
				computation.setDedicatedServer("No");
				computation.setRamSize(1.5);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_dataIntensiveApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("4");
				computation.setNoOfCores(4);
				computation.setDedicatedServer("No");
				computation.setRamSize(7);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("3");
				computation.setNoOfCores(4);
				computation.setDedicatedServer("No");
				computation.setRamSize(12);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("3");
				computation.setNoOfCores(4);
				computation.setDedicatedServer("No");
				computation.setRamSize(7);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_missionCriticalApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("2");
				computation.setNoOfCores(8);
				computation.setDedicatedServer("Yes");
				computation.setRamSize(28);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("2");
				computation.setNoOfCores(10);
				computation.setDedicatedServer("Yes");
				computation.setRamSize(113);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(10);
				computation.setDedicatedServer("Yes");
				computation.setRamSize(58);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_streamingApp)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("2");
				computation.setNoOfCores(6);
				computation.setDedicatedServer("No");
				computation.setRamSize(28);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(8);
				computation.setDedicatedServer("No");
				computation.setRamSize(58);
				computation.setOperatingSystem("Linux");
				computation.setGpu("Yes");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(6);
				computation.setDedicatedServer("No");
				computation.setRamSize(28);
				computation.setOperatingSystem("Linux");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else if (appKind.equals(appKind_virtualDesktop)) {
			computation = new ComputationARI();
			if (appPriority.equals(appPriority_availability)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("2");
				computation.setNoOfCores(4);
				computation.setDedicatedServer("No");
				computation.setRamSize(7);
				computation.setOperatingSystem("Windows");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_performance)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(8);
				computation.setDedicatedServer("No");
				computation.setRamSize(28);
				computation.setOperatingSystem("Windows");
				computation.setGpu("Yes");
				//computation.setGpuSize(gpuSize);
			} else if (appPriority.equals(appPriority_throughput)) {
				computation.setBandwidth(450);
				computation.setNoOfNodes("1");
				computation.setNoOfCores(4);
				computation.setDedicatedServer("No");
				computation.setRamSize(7);
				computation.setOperatingSystem("Windows");
				computation.setGpu("No");
				//computation.setGpuSize(gpuSize);
			}
		} else {
			computation = null;
		}
		return computation;

	}
}
