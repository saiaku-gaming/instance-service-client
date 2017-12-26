package com.valhallagame.instanceserviceclient.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstanceData {
	private String id;
	private String version;
	private String level;
	private String address;
	private int port;
	private String state;
	private List<String> members;
}
