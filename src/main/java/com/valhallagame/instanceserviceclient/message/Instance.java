package com.valhallagame.instanceserviceclient.message;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instance {
	private String id;
	private String version;
	private String level;
	private String address;
	private int port;
	private String state;
	private List<String> members;
}
