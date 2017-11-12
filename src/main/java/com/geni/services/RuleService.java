package com.geni.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.geni.beans.Rule;
import com.geni.dao.RuleDao;

public class RuleService {
	private static Logger logger = Logger.getLogger(QuestionService.class);
	private static RuleDao dao = new RuleDao();

	public static String addRule(Rule rule) {

		String flag = dao.addRule(rule.getRuleId(), rule.getParentQuestionId(), rule.getCondition(), rule.getValue(),
				rule.getChildQuestionId());
		return flag;
	}

	public static List<Rule> getAllRules() {
		List<Rule> ruleList = new ArrayList<Rule>();
		ResultSet rs = dao.getAllRules();
		if (rs != null) {
			try {
				while (rs.next()) {
					Rule rule = new Rule();
					rule.setRuleId(rs.getInt("rule_id"));
					rule.setParentQuestionId(rs.getInt("parent_question_id"));
					rule.setParentQuestionText(rs.getString("parent_question_txt"));
					rule.setCondition(rs.getString("rule_condition"));
					rule.setValue(rs.getString("value"));
					rule.setChildQuestionId(rs.getInt("child_question_id"));
					rule.setChildQuestionText(rs.getString("child_question_txt"));
					
					ruleList.add(rule);
				}
			} catch (SQLException e) {
				logger.error(e.getStackTrace());
				logger.error(e.getMessage());
			}
			logger.info("getAllRules mehtod - resultSet is not null");
		} else {
			logger.info("getAllRules method - resultSet is null");
		}
		return ruleList;
	}
}
