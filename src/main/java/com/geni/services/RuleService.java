package com.geni.services;

import org.apache.log4j.Logger;

import com.geni.beans.Rule;
import com.geni.dao.RuleDao;

public class RuleService {
	private static Logger logger = Logger.getLogger(QuestionService.class);
	private static RuleDao dao = new RuleDao();
	
	public static String addRule(Rule rule){
		String flag = dao.addRule(rule.getRule_id(), rule.getQuestion_id(), rule.getCondition(), rule.getValue());
		return flag;
	}
}
