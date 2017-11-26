package com.valhallagame.instanceserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.instanceserviceclient.message.Instance;
import com.valhallagame.instanceserviceclient.message.UsernameAndVersionParameter;

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

	public RestResponse<Instance> getSelectedInstance(String username, String clientVersion) throws IOException {
		UsernameAndVersionParameter usernameParam = new UsernameAndVersionParameter(username, clientVersion);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-selected-instance", usernameParam, Instance.class);
	}
}
