package com.geni.services;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.autoscaling.AmazonAutoScalingClient;
import com.amazonaws.services.autoscaling.model.CreateAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.CreateLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.CreateLaunchConfigurationResult;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;

public class AWSInstanceManager {

	static AmazonEC2 ec2;
	//static AmazonElasticLoadBalancingClient  	elb; 
    static AmazonAutoScalingClient				as;
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
        as = new AmazonAutoScalingClient(credentials);
	}

    private static String createLaunchConfiguration (String instanceType ) throws AmazonClientException {
    	
    	String securityGroups = prop.getProperty("AWS_SECURITY_GROUP_NAME");
    	String launchConfigurationName = prop.getProperty("AWS_LAUNCH_CONFIG_NAME");
    	String amiImageId = prop.getProperty("AWS_AMI_IMAGE_ID");
    	String keyName = prop.getProperty("AWS_KEY_NAME");
    	
    	CreateLaunchConfigurationRequest launchConfigRequest = new CreateLaunchConfigurationRequest()
    	.withImageId(amiImageId)
    	.withInstanceType(instanceType)
    	.withKeyName(keyName) //Not required
    	.withSecurityGroups(securityGroups) //can use more than one, presented as a comma delimited string
    	.withLaunchConfigurationName(launchConfigurationName);
    	
    	CreateLaunchConfigurationResult result = as.createLaunchConfiguration(launchConfigRequest);
    	try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Created Launch Configuration \n");
    	return launchConfigurationName;
    }
    
    private static String createAutoScalingGroup(String autoScalingGroupName, String launchConfigurationName, String loadBalancerName, 
    		String availabilityZones, int minSGSize, int maxSGSize) throws AmazonClientException {
    	
    	try {
        CreateAutoScalingGroupRequest asgRequest = new CreateAutoScalingGroupRequest()
        .withAutoScalingGroupName(autoScalingGroupName)
        .withLaunchConfigurationName(launchConfigurationName)
        .withAvailabilityZones(availabilityZones)
        //.withDesiredCapacity(resource.desiredSize) //number of instances desired - not a required field. Something between min and max
        .withMinSize(minSGSize)
        .withMaxSize(maxSGSize)
        .withDefaultCooldown(60)
        .withHealthCheckGracePeriod(300)    // give 5 mins for server and application startup
        .withLoadBalancerNames(loadBalancerName);
        //.withTerminationPolicies(ASGroup.TERMINATE_POLICY_OLDEST_INSTANCE)      // always remove oldest instance, OldestLaunchConfiguration should not be used due to during deployment the old LaunchConfig can be deleted first, the ASG may fail to compare, and terminate unwanted instance
        //.withTags(new Tag().withKey("cloud-manager:env").withValue(context.env.name).withPropagateAtLaunch(true), helper.nameTag(resource));
        as.createAutoScalingGroup(asgRequest);
        TimeUnit.SECONDS.sleep(20);
    	}
    	catch (AmazonServiceException ase) {
        System.out.println("Caught Exception: " + ase.getMessage());
        System.out.println("Reponse Status Code: " + ase.getStatusCode());
        System.out.println("Error Code: " + ase.getErrorCode());
        System.out.println("Request ID: " + ase.getRequestId());
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		e.printStackTrace();
    	}
    	return autoScalingGroupName;
    }
    
	public static String launchNewEC2Instance() {
		init();
		String instanceType = prop.getProperty("AWS_INSTANCE_TYPE");
		String autoScalingGroupName = "MyAutoScalingGroup1";
		String availabilityZone = prop.getProperty("AWS_AVIALABILITY_ZONE");
		String loadBalancer = prop.getProperty("AWS_LOADBALANCER_NAME");
		int minSize = 1;
		int maxSize = 2;
		String launchConfigName = createLaunchConfiguration(instanceType);
		createAutoScalingGroup(autoScalingGroupName, launchConfigName, loadBalancer, availabilityZone, minSize, maxSize);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return "success";
	}
	
	public static String stopEC2Instance(String instanceID) {
		init();
		try {

			StopInstancesRequest request = new StopInstancesRequest().withInstanceIds(instanceID);
			StopInstancesResult response = ec2.stopInstances(request);
			for (InstanceStateChange stateChange : response.getStoppingInstances()) {
				System.out.println("Stopping instance: " + stateChange.getInstanceId() + " Instance state: "
						+ stateChange.getCurrentState().getName() + "\n");
			}
			return "success";

		} catch (AmazonServiceException ase) {
			System.out.println("Caught Exception: " + ase.getMessage());
			System.out.println("Reponse Status Code: " + ase.getStatusCode());
			System.out.println("Error Code: " + ase.getErrorCode());
			System.out.println("Request ID: " + ase.getRequestId());
			return "failure";
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			return "failure";
		}
	}

	public static String startEC2Instance(String instanceID) {
		// starts one instance. Must be in a valid state: stopped or will throw
		// Exception
		// see
		// http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html
		init();
		StartInstancesRequest request = new StartInstancesRequest();
		request.withInstanceIds(instanceID);
		try {
			StartInstancesResult response = ec2.startInstances(request);
			for (InstanceStateChange stateChange : response.getStartingInstances()) {
				System.out.println("Starting instance: " + stateChange.getInstanceId() + " Instance state: "
						+ stateChange.getCurrentState().getName() + "\n");
			}
			return "success";
		} catch (AmazonServiceException ase) {
			System.out.println("Caught Exception: " + ase.getMessage());
			System.out.println("Reponse Status Code: " + ase.getStatusCode());
			System.out.println("Error Code: " + ase.getErrorCode());
			System.out.println("Request ID: " + ase.getRequestId());
			return "failure";
		} catch (Exception e) {
			System.out.println("Exceptoin : " + e.getMessage());
			return "failure";
		}
	}

	public static String terminateEC2Instance(String instanceID) {
		// terminates one instance. Must be in a valid state: running or stopped
		// or will throw Exception
		// see
		// http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html
		init();
		TerminateInstancesRequest request = new TerminateInstancesRequest();
		request.withInstanceIds(instanceID);
		try {
			TerminateInstancesResult response = ec2.terminateInstances(request);
			for (InstanceStateChange stateChange : response.getTerminatingInstances()) {
				System.out.println("Terminated instance: " + stateChange.getInstanceId() + " Instance state: "
						+ stateChange.getCurrentState().getName() + "\n");
			}
			return "success";
		} catch (AmazonServiceException ase) {
			System.out.println("Caught Exception: " + ase.getMessage());
			System.out.println("Reponse Status Code: " + ase.getStatusCode());
			System.out.println("Error Code: " + ase.getErrorCode());
			System.out.println("Request ID: " + ase.getRequestId());
			return "failure";
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			return "failure";
		}
	}

	public static String shutdownEC2Instance(String instanceID) {
		// shuts down one instance. Must be in a valid state: running or will
		// throw Exception. See
		// http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html
		init();
		StopInstancesRequest request = new StopInstancesRequest();
		request.withInstanceIds(instanceID);
		try {
			StopInstancesResult response = ec2.stopInstances(request);
			for (InstanceStateChange stateChange : response.getStoppingInstances()) {
				System.out.println("Stopping instance: " + stateChange.getInstanceId() + " Instance state: "
						+ stateChange.getCurrentState().getName() + "\n");
			}
			return "success";
		} catch (AmazonServiceException ase) {
			System.out.println("Caught Exception: " + ase.getMessage());
			System.out.println("Reponse Status Code: " + ase.getStatusCode());
			System.out.println("Error Code: " + ase.getErrorCode());
			System.out.println("Request ID: " + ase.getRequestId());
			return "failure";
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			return "failure";
		}
	}
	
	public static void main(String[] args) {
		launchNewEC2Instance();
	}
}
