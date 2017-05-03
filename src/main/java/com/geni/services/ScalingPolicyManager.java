package com.geni.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.autoscaling.model.Alarm;
import com.amazonaws.services.autoscaling.model.AutoScalingGroup;
import com.amazonaws.services.autoscaling.model.DescribePoliciesResult;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyRequest;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyResult;
import com.amazonaws.services.autoscaling.model.ScalingPolicy;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.ComparisonOperator;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazonaws.services.cloudwatch.model.MetricAlarm;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmResult;
import com.amazonaws.services.cloudwatch.model.StandardUnit;
import com.amazonaws.services.cloudwatch.model.Statistic;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.s3.model.GetBucketAccelerateConfigurationRequest;
import com.geni.beans.ScalingRule;

public class ScalingPolicyManager {
	
	static AmazonEC2 ec2;
	//static AmazonElasticLoadBalancingClient  	elb; 
    static AmazonAutoScalingClient				as;
    static AmazonCloudWatch cw;
    private static Properties prop;
	private static InputStream input;
	
	private static void init() {

		/*
		 * The ProfileCredentialsProvider will return your [Sue Student Acct]
		 * credential profile by reading from the credentials file located at
		 * (C:\\Users\\windo\\.aws\\credentials).
		 */
		AWSCredentials credentials = null;
		try {
			credentials = new ProfileCredentialsProvider("Eclipse").getCredentials();
			String filename = "config.properties";
			input = AWSInstanceManager.class.getClassLoader().getResourceAsStream(filename);
	        prop = new Properties();
			prop.load(input);
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (C:\\Users\\windo\\.aws\\credentials), and is in valid format.", e);
		}
		ec2 = new AmazonEC2Client(credentials);
		//elb = new AmazonElasticLoadBalancingClient(credentials);
		 cw = new AmazonCloudWatchClient(credentials);
        as = new AmazonAutoScalingClient(credentials);
	}
	
	public static List<ScalingRule> listScalingPolicies() throws AmazonClientException {
		init();
		List<ScalingRule> scalingRuleList = new ArrayList<ScalingRule>();
        DescribePoliciesResult describePoliciesResult = as.describePolicies();
        List<ScalingPolicy> scalingpolicies = describePoliciesResult.getScalingPolicies();
        System.out.println("You have " + scalingpolicies.size() + " Scaling Policies");
        for(ScalingPolicy scalingpolicy : scalingpolicies) {
              System.out.println(scalingpolicy);
              ScalingRule sr = new ScalingRule();
              sr.setRuleName(scalingpolicy.getPolicyName());
              MetricAlarm alarm = getAlarmAssociatedToPolicy(scalingpolicy.getPolicyName());
              int adjustment = scalingpolicy.getScalingAdjustment();
              int noOfInstances = 1;
              if (adjustment > 0) {
            	  sr.setAction("Add");
            	  noOfInstances *= adjustment;
              } else {
            	  sr.setAction("Remove");
            	  noOfInstances = noOfInstances * -1 * adjustment;
              }
              sr.setNoOfInstances(noOfInstances);
              sr.setMetricType("CPU Utilization");
              if  (alarm != null) {
            	  sr.setCondition(alarm.getComparisonOperator().toString());
            	  sr.setThreshold(alarm.getThreshold());
            	  sr.setPeriod(alarm.getPeriod());
            	  sr.setEvaluationPeriod(alarm.getEvaluationPeriods());
              }
              scalingRuleList.add(sr);
        }
        System.out.println("\n");
            return scalingRuleList;
 }
	
	private static MetricAlarm getAlarmAssociatedToPolicy(String policyName) throws AmazonClientException {
		DescribeAlarmsResult result = cw.describeAlarms();
		List<MetricAlarm> alarms = result.getMetricAlarms();
		for (MetricAlarm alarm : alarms) {
			if (alarm.getAlarmName().startsWith(policyName)) {
				return alarm;
			} else {
				continue;
			}
			/*System.out.println("Alarm Name: " + alarm.getAlarmName() + " Alarm Comparison: "
					+ alarm.getComparisonOperator() + " Alarm Action: " + alarm.getAlarmActions().get(0)
					+ " Alarm Metric: " + alarm.getMetricName() + " Alarm Threshhold " + alarm.getThreshold());*/
		}
		return null;
	}
	
    public static String createScalingPolicy(String policyName, int scalingAdjustment) throws AmazonClientException {
    	init();
    	
    	PutScalingPolicyResult result = new PutScalingPolicyResult();
    	
    	int coolDown = 300;

    	PutScalingPolicyRequest request = new PutScalingPolicyRequest()
    			.withAdjustmentType("ChangeInCapacity") //ChangeInCapacity, ExactCapacity, and PercentChangeInCapacity.
    			//auto scaling group
    			.withAutoScalingGroupName(prop.getProperty("AWS_AUTOSCALING_GROUP_NAME"))
    			.withCooldown(coolDown) 
    			.withScalingAdjustment(scalingAdjustment)
    			.withPolicyName(policyName);
    	
    	 result = as.putScalingPolicy(request);
    	try {
    		TimeUnit.SECONDS.sleep(5);
    	} catch(InterruptedException e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}
    	return result.getPolicyARN();
    }
	
	public static PutMetricAlarmResult createAlarm(String alarmName, String metricName,ComparisonOperator comparisonOperator, String alarmDescription, double threshold, String scalingPolicyARN)
	{
		init();
	 
	             /*Dimension dimension = new Dimension()
	                 .withName("InstanceId")
	                 .withValue("i-0514d7150c5ad41e2");*/
	 
	             PutMetricAlarmRequest request = new PutMetricAlarmRequest()
	                 .withAlarmName(alarmName)
	                 .withComparisonOperator(comparisonOperator)
	                 .withEvaluationPeriods(1)
	                 .withMetricName(metricName)
	                 .withNamespace("AWS/EC2")
	                 .withPeriod(60)
	                 .withStatistic(Statistic.Average)
	                 .withThreshold(threshold)
	                 .withActionsEnabled(false)
	                 .withAlarmDescription(alarmDescription)
	                 .withUnit(StandardUnit.Seconds)
	                 .withAlarmActions(scalingPolicyARN);
	 
	             PutMetricAlarmResult response = cw.putMetricAlarm(request);
	       
	        try {
	        	TimeUnit.SECONDS.sleep(5);
	        } catch (InterruptedException e) {
	        	System.out.println(e.getMessage());
	        	e.printStackTrace();
	        }
	      
	       return response;
	}
	
/*	public static void main(String [] args) {
		List<ScalingRule> srList = listScalingPolicies();
		for (ScalingRule sr : srList) {
			System.out.println(sr.getRuleName());
		}
	}*/

}
