package com.geni.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.geni.beans.CandidateResource;
import com.geni.beans.MiniTemplate;

import com.geni.dao.KnnDao;
import com.geni.dao.TemplateDao;

public class KnnService {
	private KnnDao knnDao;
	private TemplateDao templateDao;
	int k;

	public KnnService() {
		this.knnDao = new KnnDao();
		this.templateDao = new TemplateDao();
		k = 10;
	}


	public Map<String, List<CandidateResource>> decisionMaking(List<MiniTemplate> minTemplateList) {
		minTemplateList.sort(new TotalCostComparator());
		//List<MiniTemplate> uniqueList = new ArrayList<MiniTemplate>();
		int n = k / 2;
		System.out.println("Silver Template : " + minTemplateList.get(0).getTemplateId() + " Cost : "
				+ minTemplateList.get(0).getTotalCost());
		System.out.println("Gold Template : " + minTemplateList.get(n).getTemplateId() + " Cost : "
				+ minTemplateList.get(n).getTotalCost());
		System.out.println("Green Template : " + minTemplateList.get(k - 1).getTemplateId() + " Cost : "
				+ minTemplateList.get(k - 1).getTotalCost());

		Map<String, List<CandidateResource>> m = new HashMap<String, List<CandidateResource>>();

		m.put("silver", templateDao.getTemplateInfo(minTemplateList.get(0).getTemplateId()));
		System.out.println("silver inserted into map");
		m.put("gold", templateDao.getTemplateInfo(minTemplateList.get(1).getTemplateId()));
		System.out.println("gold inserted into map");
		m.put("green", templateDao.getTemplateInfo(minTemplateList.get(2).getTemplateId()));
		System.out.println("green inserted into map");

		return m;
	}

	public Map<String, List<CandidateResource>> getNearestTemplates(String[] nResources, float vcpu, double ram, int local_storage, int bandwidth,
			String[] sResources, int storageSize, String storageDisk, String[] cResources) {

		// # of neighbours
		// list to save miniTemplate data
		List<MiniTemplate> templateList = null;
		templateList = knnDao.getEligibleTemplates(nResources, sResources, storageDisk,
				cResources);

		// list to save distance result
		List<Result> resultList = new ArrayList<Result>();

		// data about unknown miniTemplate

		double[] query = {vcpu, ram, local_storage, bandwidth, storageSize };
		// find disnaces
		for (MiniTemplate miniTemplate : templateList) {
			double dist = 0.0;
			for (int j = 0; j < miniTemplate.getTemplateAttributes().length; j++) {
				dist += Math.pow(miniTemplate.getTemplateAttributes()[j] - query[j], 2);
				// System.out.print(miniTemplate.getTemplateAttributes()[j]+"
				// ");
			}
			double distance = Math.sqrt(dist);
			// resultList.add(new
			// Result(distance,miniTemplate.getTemplateId()));
			resultList.add(new Result(distance, miniTemplate));
			// System.out.println(distance);
		}

		// System.out.println(resultList);
		Collections.sort(resultList, new DistanceComparator());
		// String[] ss = new String[k];
		List<MiniTemplate> ss = new ArrayList<MiniTemplate>();
		int len = resultList.size();
		System.out.println("no of templates after first level of filetering");
		if (len < k) {
			k = len;
		}
		for (int x = 0; x < k; x++) {
			System.out.println(resultList.get(x).miniTemplate.getTemplateId() + " .... " + resultList.get(x).distance
					+ " .... " + resultList.get(x).miniTemplate.getTotalCost());
			// get classes of k nearest instances (miniTemplate names) from the
			// list into an array
			// ss[x] = resultList.get(x).miniTemplate.getTemplateId();
			ss.add(resultList.get(x).miniTemplate);
		}
		// String majClass = findMajorityClass(ss);
		// System.out.println("Class of new instance is: "+majClass);

		return decisionMaking(ss);
	}// end main

	// simple class to model results (distance + class)
	static class Result {
		double distance;
		// String templateId;
		MiniTemplate miniTemplate;

		public Result(double distance, MiniTemplate miniTemplate) {
			this.miniTemplate = miniTemplate;
			this.distance = distance;
		}
	}

	// simple comparator class used to compare results via distances
	static class DistanceComparator implements Comparator<Result> {
		@Override
		public int compare(Result a, Result b) {
			return a.distance < b.distance ? -1 : a.distance == b.distance ? 0 : 1;
		}
	}

	static class TotalCostComparator implements Comparator<MiniTemplate> {
		@Override
		public int compare(MiniTemplate a, MiniTemplate b) {
			// TODO Auto-generated method stub
			return a.getTotalCost() < b.getTotalCost() ? -1 : a.getTotalCost() == b.getTotalCost() ? 0 : 1;
		}

	}

}
