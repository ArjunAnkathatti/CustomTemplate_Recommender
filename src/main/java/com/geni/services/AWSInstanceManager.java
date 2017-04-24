package com.geni.services;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.InstanceStateChange;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;

public class AWSInstanceManager {

	static AmazonEC2 ec2;

	private static void init() {

		/*
		 * The ProfileCredentialsProvider will return your [Sue Student Acct]
		 * credential profile by reading from the credentials file located at
		 * (C:\\Users\\windo\\.aws\\credentials).
		 */
		AWSCredentials credentials = null;
		try {
			credentials = new ProfileCredentialsProvider("Eclipse").getCredentials();
		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (C:\\Users\\windo\\.aws\\credentials), and is in valid format.", e);
		}
		ec2 = new AmazonEC2Client(credentials);
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

	public static String terminateEC2Instance(Instance instance) {
		// terminates one instance. Must be in a valid state: running or stopped
		// or will throw Exception
		// see
		// http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html
		init();
		TerminateInstancesRequest request = new TerminateInstancesRequest();
		request.withInstanceIds(instance.getInstanceId());
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

	public static String shutdownEC2Instance(Instance instance) {
		// shuts down one instance. Must be in a valid state: running or will
		// throw Exception. See
		// http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-lifecycle.html
		init();
		StopInstancesRequest request = new StopInstancesRequest();
		request.withInstanceIds(instance.getInstanceId());
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
}
