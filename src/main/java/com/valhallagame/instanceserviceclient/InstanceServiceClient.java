package com.valhallagame.instanceserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.instanceserviceclient.message.SessionAndConnection;
import com.valhallagame.instanceserviceclient.message.StartDungonParameter;
import com.valhallagame.instanceserviceclient.message.StopDungonParameter;
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

	public RestResponse<SessionAndConnection> getGameSession(String username, String clientVersion) throws IOException {
		UsernameAndVersionParameter usernameParam = new UsernameAndVersionParameter(username, clientVersion);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/get-game-session", usernameParam, SessionAndConnection.class);
	}

	public RestResponse<String> startDungeon(String username, String map, String version) throws IOException {
		StartDungonParameter sdp = new StartDungonParameter(username, map, version);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/start-dungeon", sdp, String.class);
	}
	
	public RestResponse<String> stopDungeon(String username, int dungeonId) throws IOException {
		StopDungonParameter sdp = new StopDungonParameter(username, dungeonId);
		return restCaller.postCall(instanceServiceServerUrl + "/v1/instance/stop-dungeon", sdp, String.class);
	}
}
