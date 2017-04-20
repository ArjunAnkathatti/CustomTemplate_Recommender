package com.geni.services;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.geni.beans.ResourceSpace;

import com.geni.dao.ResourceSpaceDao;

public class ResourceSpaceGeneration {
	private List<List<String>> fileData;
	private ResourceSpaceDao rsd;
	private ResourceSpace rs;
	public ResourceSpaceGeneration(){}
	
	public ResourceSpaceGeneration(String rsfilepath){
		readCSV(rsfilepath);
		
		ResourceSpaceGenerate(new ResourceSpace());
	}
	
	public void readCSV(String rsfilepath){
		try{
			File csv = new File(rsfilepath);
			
			BufferedReader br = new BufferedReader(new FileReader(csv));
			
			String readLine = null;
			List<List<String>> tempFileData = new ArrayList<List<String>>();
			
			int i = 0;
			while((readLine = br.readLine()) != null){
				String[] temp = readLine.split(",");
				List<String> eachData = new ArrayList<String>();
				for(int j = 0; j < temp.length; j++){
					eachData.add(temp[j]);
					//System.out.println(temp[j]);
				}
				tempFileData.add(eachData);
				i++;
			}
			
			setFileData(tempFileData);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void ResourceSpaceGenerate(ResourceSpace rs){
		setRsd(new ResourceSpaceDao());
		setRs(rs);
		
		for(int i = 0; i < this.fileData.size(); i++){
			String rconstraint = "";
			for(int j = 0; j < this.fileData.get(i).size(); j++){
				if(j == 0){
					this.getRs().setDomain(this.fileData.get(i).get(j));
				}else if(j == 1){
					this.getRs().setResource(this.fileData.get(i).get(j));
				}else if(j > 1 && j < this.fileData.get(i).size() - 1){
					//System.out.println("j = " + j + " || " + this.fileData.get(i).get(j) + this.fileData.size());
					rconstraint = rconstraint + this.fileData.get(i).get(j) + ",";
				}else{
					rconstraint = rconstraint + this.fileData.get(i).get(j);
				}
			}
			this.getRs().setRconstraint(rconstraint);
			//this.getRsd().InsertData2DB(this.getRs());
		}
		
		
		
	} 
	public List<List<String>> getFileData() {
		return fileData;
	}

	public void setFileData(List<List<String>> fileData) {
		this.fileData = fileData;
	}

	public ResourceSpaceDao getRsd() {
		return rsd;
	}

	public void setRsd(ResourceSpaceDao rsd) {
		this.rsd = rsd;
	}

	public ResourceSpace getRs() {
		return rs;
	}

	public void setRs(ResourceSpace rs) {
		this.rs = rs;
	}
}
