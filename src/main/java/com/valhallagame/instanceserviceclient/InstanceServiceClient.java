package com.valhallagame.instanceserviceclient;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.valhallagame.instanceserviceclient.message.InstanceAndOwnerParameter;
import com.valhallagame.instanceserviceclient.message.InstanceNameParameter;
import com.valhallagame.instanceserviceclient.message.Instance;
import com.valhallagame.instanceserviceclient.message.UsernameParameter;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;

public class InstanceServiceClient {
	
	private static RestCaller restCaller = new RestCaller();
	
	private static InstanceServiceClient instanceServiceClient;

	private String instanceServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.CHARACTER_SERVICE_PORT;

	private InstanceServiceClient() {
	}

	public static void init(String instanceServiceServerUrl) {
		InstanceServiceClient client = get();
		client.instanceServiceServerUrl = instanceServiceServerUrl;
	}

	public static InstanceServiceClient get() {
		if (instanceServiceClient == null) {
			instanceServiceClient = new InstanceServiceClient();
		}
		return instanceServiceClient;
	}

	
	public RestResponse<Instance> getInstance(String username, String instanceName) throws IOException {
		InstanceAndOwnerParameter instanceAndOwner =  new InstanceAndOwnerParameter(instanceName, username);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get", instanceAndOwner, Instance.class);
	}

	public RestResponse<JsonNode> getAll(String username) throws IOException {
		UsernameParameter usernameParam = new UsernameParameter(username);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-all", usernameParam, JsonNode.class);
	}

	public RestResponse<String> create(String username, String instanceName) throws IOException {
		InstanceAndOwnerParameter instanceAndOwner =  new InstanceAndOwnerParameter(instanceName, username);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/create", instanceAndOwner, String.class);
	}

	public RestResponse<String> delete(String username, String instanceName) throws IOException {
		InstanceAndOwnerParameter instanceAndOwner =  new InstanceAndOwnerParameter(instanceName, username);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/delete", instanceAndOwner, String.class);
	}

	public RestResponse<String> instanceAvailable(String instanceName) throws IOException {
		InstanceNameParameter cnp = new InstanceNameParameter(instanceName);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/instance-available", cnp, String.class);
	}

	public RestResponse<String> selectInstance(String username, String instanceName) throws IOException {
		InstanceAndOwnerParameter instanceAndOwner =  new InstanceAndOwnerParameter(instanceName, username);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/select-instance", instanceAndOwner, String.class);
	}

	public RestResponse<Instance> getSelectedInstance(String username) throws IOException {
		UsernameParameter usernameParam = new UsernameParameter(username);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-selected-instance", usernameParam, Instance.class);
	}
}
