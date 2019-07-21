package com.valhallagame.instanceserviceclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;
import com.valhallagame.instanceserviceclient.message.*;
import com.valhallagame.instanceserviceclient.model.FleetData;
import com.valhallagame.instanceserviceclient.model.InstanceData;
import com.valhallagame.instanceserviceclient.model.RelevantDungeonData;
import com.valhallagame.instanceserviceclient.model.SessionAndConnectionData;

import java.io.IOException;
import java.util.List;

public class InstanceServiceClient extends AbstractServiceClient {

	private static InstanceServiceClient instanceServiceClient;

	private InstanceServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.INSTANCE_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		InstanceServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static InstanceServiceClient get() {
		if (instanceServiceClient == null) {
			instanceServiceClient = new InstanceServiceClient();
		}
		return instanceServiceClient;
	}

	public RestResponse<SessionAndConnectionData> getHub(String username, String clientVersion) throws IOException {
		GetHubParameter getHubParameter = new GetHubParameter(username, clientVersion);
		return restCaller.postCall(serviceServerUrl + "/v1/instance/get-hub", getHubParameter,
				SessionAndConnectionData.class);
	}

	public RestResponse<RelevantDungeonData> getRelevantDungeons(String username, String clientVersion)
			throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/get-relevant-dungeons",
				new GetRelevantDungeonsParameter(username, clientVersion), RelevantDungeonData.class);
	}

	public RestResponse<String> activateInstance(String gameSessionId, String address, int port) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/activate-instance",
				new ActivateInstanceParameter(gameSessionId, address, port), String.class);
	}

	public RestResponse<String> updateInstanceState(String gameSessionId, String state) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/update-instance-state",
				new UpdateInstanceStateParameter(gameSessionId, state), String.class);
	}

	public RestResponse<String> startDungeon(String username, String map, String version) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/start-dungeon",
				new StartDungeonParameter(username, map, version), String.class);
	}

	public RestResponse<String> instancePlayerLogin(String token, String gameSessionId) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/instance-player-login",
				new InstancePlayerLoginParameter(token, gameSessionId), String.class);
	}

	public RestResponse<String> instancePlayerLogout(String username, String gameSessionId) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/instance-player-logout",
				new InstancePlayerLogoutParameter(username, gameSessionId), String.class);
	}

	public RestResponse<SessionAndConnectionData> getDungeonConnection(String username, String instanceId,
																	   String version) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/get-dungeon-connection",
				new GetDungeonConnectionParameter(username, instanceId, version), SessionAndConnectionData.class);
	}

	public RestResponse<List<InstanceData>> getAllInstances() throws IOException {
		return restCaller.getCall(serviceServerUrl + "/v1/instance/get-all-instances",
				new TypeReference<List<InstanceData>>() {
				});
	}

	public RestResponse<String> addLocalInstance(AddLocalInstanceParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/add-local-instance", input, String.class);
	}

	public RestResponse<List<String>> getAllPlayersInSameInstance(String senderUsername) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/get-all-players-in-same-instance",
				new GetAllPlayersInSameInstanceParameter(senderUsername), new TypeReference<List<String>>() {
				});
	}
	
	public RestResponse<List<FleetData>> getFleets() throws IOException {
		return restCaller.getCall(serviceServerUrl + "/v1/instance/get-fleets", new TypeReference<List<FleetData>>() {
				});
	}

	public RestResponse<String> latestVersion(LatestVersionParameter input) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/instance/latest-version", input, String.class);
	}
}
