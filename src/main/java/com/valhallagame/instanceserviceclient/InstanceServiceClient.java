package com.valhallagame.instanceserviceclient;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.instanceserviceclient.message.ActivateInstanceParameter;
import com.valhallagame.instanceserviceclient.message.GetAllPlayersInSameInstanceParameter;
import com.valhallagame.instanceserviceclient.message.GetDungeonConnectionParameter;
import com.valhallagame.instanceserviceclient.message.GetHubParameter;
import com.valhallagame.instanceserviceclient.message.GetRelevantDungeonsParameter;
import com.valhallagame.instanceserviceclient.message.InstancePlayerLoginParameter;
import com.valhallagame.instanceserviceclient.message.InstancePlayerLogoutParameter;
import com.valhallagame.instanceserviceclient.message.SessionAndConnection;
import com.valhallagame.instanceserviceclient.message.StartDungeonParameter;
import com.valhallagame.instanceserviceclient.message.UpdateInstanceStateParameter;

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

	public RestResponse<SessionAndConnection> getHub(String username, String clientVersion) throws IOException {
		GetHubParameter getHubParameter = new GetHubParameter(username, clientVersion);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-hub", getHubParameter,
				SessionAndConnection.class);
	}

	public RestResponse<List<String>> getRelevantDungeons(String username, String clientVersion) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-relevant-dungeons",
				new GetRelevantDungeonsParameter(username, clientVersion), new TypeReference<List<String>>() {
				});
	}

	public RestResponse<String> activateInstance(String gameSessionId, String address, int port) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/activate-instance",
				new ActivateInstanceParameter(gameSessionId, address, port), String.class);
	}

	public RestResponse<String> updateInstanceState(String gameSessionId, String state) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/update-instance-state",
				new UpdateInstanceStateParameter(gameSessionId, state), String.class);
	}

	public RestResponse<String> startDungeon(String username, String map, String version) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/start-dungeon",
				new StartDungeonParameter(username, map, version), String.class);
	}

	public RestResponse<String> instancePlayerLogin(String username, String gameSessionId) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/instance-player-login",
				new InstancePlayerLoginParameter(username, gameSessionId), String.class);
	}

	public RestResponse<String> instancePlayerLogout(String username, String gameSessionId) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/instance-player-logout",
				new InstancePlayerLogoutParameter(username, gameSessionId), String.class);
	}

	public RestResponse<SessionAndConnection> getDungeonConnection(String username, String gameSessionId,
			String version) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-dungeon-connection",
				new GetDungeonConnectionParameter(username, gameSessionId, version), SessionAndConnection.class);
	}

	public RestResponse<List<String>> getAllPlayersInSameInstance(String senderUsername) throws IOException {
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-all-players-in-same-instance",
				new GetAllPlayersInSameInstanceParameter(senderUsername), new TypeReference<List<String>>() {});
	}
}
