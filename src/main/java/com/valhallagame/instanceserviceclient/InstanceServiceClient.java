package com.valhallagame.instanceserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.instanceserviceclient.message.ActivateInstanceParameter;
import com.valhallagame.instanceserviceclient.message.GetPlayerSessionAndConnectionParameter;
import com.valhallagame.instanceserviceclient.message.SessionAndConnection;

public class InstanceServiceClient {

	private static RestCaller restCaller = new RestCaller();

	private static InstanceServiceClient instanceServiceClient;

	private String instanceServiceServerUrl = "http://localhost:" + DefaultServicePortMappings.INSTANCE_SERVICE_PORT;

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

	public RestResponse<SessionAndConnection> getPlayerSessionAndConnection(String username, String clientVersion)
			throws IOException {
		GetPlayerSessionAndConnectionParameter usernameParam = new GetPlayerSessionAndConnectionParameter(username,
				clientVersion);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-player-session-and-connection",
				usernameParam, SessionAndConnection.class);
	}

	public RestResponse<String> activateInstance(String gameSessionId, String address, int port) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/stop-dungeon",
				new ActivateInstanceParameter(gameSessionId, address, port), String.class);
	}
}
