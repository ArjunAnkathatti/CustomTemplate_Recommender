package com.geni.services;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyRequest;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyResult;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.ComparisonOperator;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmResult;
import com.amazonaws.services.cloudwatch.model.StandardUnit;
import com.amazonaws.services.cloudwatch.model.Statistic;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;

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

}
