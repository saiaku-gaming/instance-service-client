package com.valhallagame.instanceserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.instanceserviceclient.message.ActivateInstanceParameter;
import com.valhallagame.instanceserviceclient.message.DeactivateInstanceParameter;
import com.valhallagame.instanceserviceclient.message.GetPlayerSessionAndConnectionParameter;
import com.valhallagame.instanceserviceclient.message.SessionAndConnection;
import com.valhallagame.instanceserviceclient.message.StartDungeonParameter;

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
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/activate-instance",
				new ActivateInstanceParameter(gameSessionId, address, port), String.class);
	}

	public RestResponse<String> deactivateInstance(String gameSessionId) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/deactivate-instance",
				new DeactivateInstanceParameter(gameSessionId), String.class);
	}

	public RestResponse<String> startDungeon(String username, String map, String version) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/start-dungeon",
				new StartDungeonParameter(username, map, version), String.class);
	}
}
