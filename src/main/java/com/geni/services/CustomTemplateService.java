package com.geni.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.geni.beans.AdditionalSoftware;
import com.geni.beans.ApplicationReqIdentifier;
import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.beans.SoftwareARI;
import com.geni.beans.StorageARI;

public class CustomTemplateService {
	
	/*public File createTemplate(ApplicationReqIdentifier appRI) {
		return buildTemplate(appRI);
	}*/
	
	public String deployResources(ApplicationReqIdentifier appRI) {
		ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/python2.7", "/Users/arjun_ac/Desktop/geni_deployment.py", appRI.getComputationARI().getNoOfNodes());
		pb.redirectErrorStream(true);
		System.out.println("Running the deployment script");
		try {
			Process process = pb.start();
			/*File f = new File("/Users/arjun_ac/Desktop/");
			pb.directory(f);*/
			int errCode = process.waitFor();
			System.out.println("Echo command executed, any errors?" + (errCode == 0 ? "No" : "Yes"));
			String output = output(process.getInputStream());
			System.out.println("Echo output:\n" + output);
			
			//ServletActionContext.getResponse().getWriter().print(output);
			//ActionContext ctx = ActionContext.getContext();
			//ctx.getSession().put("pythonResult", output);
			//return output(process.getInputStream());
			return output;
		} catch (IOException e) {
			e.printStackTrace();
			return "python script error";
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "python script error";
		}
	}
	
	private String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}
	
	public boolean buildTemplate(GeneralARI general, NetworkARI network, StorageARI storage, ComputationARI computation, SoftwareARI software) {
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try {
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Node mainRootElement = doc.createElementNS("http://mizzou.com/MizzouCreateXMLDOM", "customTemplate");
			doc.appendChild(mainRootElement);

			// append child elements to root element
			mainRootElement.appendChild(getTemplateId(doc,"temp_12345"));
			mainRootElement.appendChild(getAppInfo(doc, general));
			mainRootElement.appendChild(getHardwareResource(doc, network, storage, computation));
			mainRootElement.appendChild(getSoftwareResource(doc, software));

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			File xmlFile = new File("/Users/arjun_ac/Desktop/CT_sample.xml");
			StreamResult file = new StreamResult(xmlFile);
			transformer.transform(source, file);

			System.out.println("\nXML DOM Created Successfully..");
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Node getTemplateId(Document doc, String tempID) {
		Node node = doc.createElement("template_id");
        node.appendChild(doc.createTextNode(tempID));
        return node;
	}
	
	public static Node getAppInfo(Document doc, GeneralARI general) {
		Node rootNode = doc.createElement("application_info");
		
		Node child1 = doc.createElement("appName");
		child1.appendChild(doc.createTextNode(general.getAppName()));
		
		Node child2 = doc.createElement("appKind");
		child2.appendChild(doc.createTextNode(general.getAppKind()));
		
		Node child3 = doc.createElement("appPriority");
		child3.appendChild(doc.createTextNode(general.getAppPriority()));
		
		Node child4 = doc.createElement("appDataSize");
		child4.appendChild(doc.createTextNode(general.getAppDataSize()));
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
		rootNode.appendChild(child4);
		
		return rootNode;
	}
	
	public static Node getHardwareResource(Document doc, NetworkARI network, StorageARI storage, ComputationARI computation) {
		Node rootNode = doc.createElement("hardware_resources");
		
		rootNode.appendChild(getNetwork(doc, network));
		rootNode.appendChild(getStorage(doc, storage));
		rootNode.appendChild(getComputation(doc, computation));
		
		return rootNode;
	}
	
	public static Node getNetwork(Document doc, NetworkARI network) {
		Node rootNode = doc.createElement("network_resources");
		
		Node child1 = doc.createElement("bandwidth");
		//child1.appendChild(doc.createTextNode(network.getBandwidth()));
		
		Node child2 = doc.createElement("P2P");
		//child2.appendChild(doc.createTextNode(network.getIsolated()));
		
		Node child3 = doc.createElement("layer");
		child3.appendChild(doc.createTextNode(network.getLayer()));
		
/*		Node child4 = doc.createElement("ip");
		child4.appendChild(doc.createTextNode(network.getIp()));
		
		Node child5 = doc.createElement("nfv");
		child5.appendChild(doc.createTextNode(network.getNfv()));
		
		Node child6 = doc.createElement("networkType");
		child6.appendChild(doc.createTextNode(network.getNetworkType()));*/
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
/*		rootNode.appendChild(child4);
		rootNode.appendChild(child5);
		rootNode.appendChild(child6);*/
		
		return rootNode;
	}
	
	public static Node getStorage(Document doc, StorageARI storage) {
		Node rootNode = doc.createElement("storage_resources");
		
		Node parent1 = doc.createElement("local_storage");
		Node parent2 = doc.createElement("remote_storage");
		
		Node child1 = doc.createElement("storageSize");
		//child1.appendChild(doc.createTextNode(storage.getLocalStorageSize()));
		
		Node child2 = doc.createElement("storageDisk");
		//child2.appendChild(doc.createTextNode(storage.getLocalStorageDisk()));
		
		if (true) {//if (storage.getRemoteStorage().equals("Yes")) {
			Node child3 = doc.createElement("storageSize");
			//child3.appendChild(doc.createTextNode(storage.getRemoteStorageSize()));
			
			Node child4 = doc.createElement("storageDisk");
			//child4.appendChild(doc.createTextNode(storage.getRemoteStorageDisk()));
			
			Node child5 = doc.createElement("storageLocation");
			//child5.appendChild(doc.createTextNode(storage.getRemoteStorageLocation()));
			
			parent2.appendChild(child3);
			parent2.appendChild(child4);
			parent2.appendChild(child5);
		}
		
		
		parent1.appendChild(child1);
		parent1.appendChild(child2);
		
		rootNode.appendChild(parent1);
		rootNode.appendChild(parent2);
		
		return rootNode;
	}
	
	public static Node getComputation(Document doc, ComputationARI computation) {
		Node rootNode = doc.createElement("computation_resources");
		
		Node child1 = doc.createElement("noOfNodes");
		child1.appendChild(doc.createTextNode(""+computation.getNoOfNodes()));
		
		Node child2 = doc.createElement("noOfCores");
		//child2.appendChild(doc.createTextNode(computation.getNoOfCores()));
		
		Node child3 = doc.createElement("dedicatedServer");
		child3.appendChild(doc.createTextNode(computation.getDedicatedServer()));
		
		Node child4 = doc.createElement("operatingSystem");
		child4.appendChild(doc.createTextNode(computation.getOperatingSystem()));
		
		Node child5 = doc.createElement("osArchitecture");
		//child5.appendChild(doc.createTextNode(computation.getOsArchitecture()));
		
		Node child6 = doc.createElement("ramSize");
		//child6.appendChild(doc.createTextNode(computation.getRamSize()));
		
		Node child7 = doc.createElement("gpuSize");
		if (computation.getGpu().equals("Yes")) {
			child7.appendChild(doc.createTextNode(computation.getGpuSize()));
		}
		
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
		rootNode.appendChild(child4);
		rootNode.appendChild(child5);
		rootNode.appendChild(child6);
		rootNode.appendChild(child7);
		
		return rootNode;
	}
	
	public static Node getSoftwareResource(Document doc, SoftwareARI software) {
		Node rootNode = doc.createElement("software_resources");
		
		Node child1 = doc.createElement("webServer");
		child1.appendChild(doc.createTextNode(software.getWebServer()));
		
		Node child2 = doc.createElement("dbServer");
		child2.appendChild(doc.createTextNode(software.getDatabaseServer()));
		
		Node child3 = doc.createElement("additionalSoftwares");
		
		for (AdditionalSoftware as : software.getAdditionalSoftware() ) {
			Node name = doc.createElement("name");
			name.appendChild(doc.createTextNode(as.getName()));
			
			Node url = doc.createElement("gitUrl");
			url.appendChild(doc.createTextNode(as.getGithubURL()));
			
			child3.appendChild(name);
			child3.appendChild(url);
		}
		
		rootNode.appendChild(child1);
		rootNode.appendChild(child2);
		rootNode.appendChild(child3);
		
		return rootNode;
	}
}
