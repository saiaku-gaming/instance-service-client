package com.valhallagame.instanceserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionAndConnectionData {
	private String address;
	private int port;
	private String playerSession;
}
