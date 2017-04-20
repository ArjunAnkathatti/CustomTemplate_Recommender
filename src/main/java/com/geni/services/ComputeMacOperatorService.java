package com.geni.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.geni.beans.ComputationQuery;
import com.geni.beans.ComputeCandidateResource;
import com.geni.beans.ComputeResource;

import com.geni.dao.MacroOperatorDao;

public class ComputeMacOperatorService {
	
		private MacroOperatorDao macOpDao;
		
		public ComputeMacOperatorService() {
			this.macOpDao = new MacroOperatorDao();
		}

		public ComputeCandidateResource [] getCandidateComputationResource(ComputationQuery cq){ 

			int k = 5;// # of neighbours  
			//list to save computeresource list data
			List<ComputeResource> computeResourceList = macOpDao.getAllComputeResources(cq.getOs());
			//list to save distance result
			List<Result> resultList = new ArrayList<Result>();
			
			//data about unknown user query
			// v = (vcpu, ram, local_storage, bandwidth)
			double[] query = {cq.getvCPU(),cq.getRam(),cq.getLocalStorage(),cq.getBandwidth()};
			
			//find disnaces
			for(ComputeResource computeResource : computeResourceList){
				double dist = 0.0;  
				for(int j = 0; j < computeResource.computeAttributes.length; j++){    	     
					dist += Math.pow(computeResource.computeAttributes[j] - query[j], 2) ;
					//System.out.print(city.cityAttributes[j]+" ");    	     
				}
				double distance = Math.sqrt( dist );
				resultList.add(new Result(distance,computeResource.computeResourceName));
				//System.out.println(distance);
			} 

			//System.out.println(resultList);
			Collections.sort(resultList, new DistanceComparator());
			String[] ss = new String[k];
			StringBuilder eligibleComputeResourceIds = new StringBuilder();
			for(int x = 0; x < k; x++){
				System.out.println("Resour Id : " + resultList.get(x).computeResourceName+ " <....> Distance : " + resultList.get(x).distance);
				//get classes of k nearest instances (city names) from the list into an array
				ss[x] = resultList.get(x).computeResourceName;
				eligibleComputeResourceIds.append(resultList.get(x).computeResourceName);
				eligibleComputeResourceIds.append(",");
			}   
			eligibleComputeResourceIds.deleteCharAt(eligibleComputeResourceIds.length() - 1);
			return macOpDao.getEligibleComputeResources(eligibleComputeResourceIds.toString(), cq.getOs());
			
		}//end getComputationResource()  

		
		
		//simple class to model results (distance + class)
		static class Result {	
			double distance;
			String computeResourceName;
			public Result(double distance, String computeResourceName){
				this.computeResourceName = computeResourceName;
				this.distance = distance;	    	    
			}
		}
		//simple comparator class used to compare results via distances
		static class DistanceComparator implements Comparator<Result> {
			@Override
			public int compare(Result a, Result b) {
				return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
			}
		}

	}
