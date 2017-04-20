package com.geni.actions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessBuilderDemo extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String pythonScriptResult;
	private long deployTime;

	public String getPythonScriptResult() {
		return pythonScriptResult;
	}

	public void setPythonScriptResult(String pythonScriptResult) {
		this.pythonScriptResult = pythonScriptResult;
	}
	


	public long getDeployTime() {
		return deployTime;
	}

	public void setDeployTime(long deployTime) {
		this.deployTime = deployTime;
	}

	public String pythonScript() {
		long deployStartTime = System.currentTimeMillis();
		
		//ComputationARI computation = (ComputationARI) ctx.get("computation");
		ActionContext ctx = ActionContext.getContext();
		//String noOfNodes = "" + (int)ctx.get("nodes");
		
		ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/python2.7", "/Users/arjun_ac/Desktop/geni_deployment.py", "3");
		pb.redirectErrorStream(true);
		
		System.out.println("Running the deployment script");
		try {
			Process process = pb.start();
			/*File f = new File("/Users/arjun_ac/Desktop/");
			pb.directory(f);*/
			int errCode = process.waitFor();
			System.out.println("Echo command executed, any errors?" + (errCode == 0 ? "No" : "Yes"));
			//System.out.println("Echo output:\n" + output(process.getInputStream()));
			this.pythonScriptResult = output(process.getInputStream());
			ServletActionContext.getResponse().getWriter().print(this.pythonScriptResult);
			
			
			
			long deployEndTime = System.currentTimeMillis();
			this.deployTime = deployEndTime - deployStartTime;
			
			System.out.println("Deployment time : " + this.deployTime);
			return SUCCESS;
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("python script error");
			return ERROR;
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("python script error");
			return ERROR;
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
}
