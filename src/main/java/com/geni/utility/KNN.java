package com.geni.utility;

import java.util.*;

import com.geni.beans.ComputeResource;

class KNN
{

	public static void main(String args[]){ 

		int k = 6;// # of neighbours  
		//list to save city data
		List<ComputeResource> computeResourceList = KNNArjunDao.getComputeResourceList();
		//list to save distance result
		List<Result> resultList = new ArrayList<Result>();
		
		//data about unknown city
		double[] query = {2,4,20,1000};
		
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
		for(int x = 0; x < k; x++){
			System.out.println("Resour Id : " + resultList.get(x).computeResourceName+ " <....> Distance : " + resultList.get(x).distance);
			//get classes of k nearest instances (city names) from the list into an array
			ss[x] = resultList.get(x).computeResourceName;
		}             
	}//end main  

	
	
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
