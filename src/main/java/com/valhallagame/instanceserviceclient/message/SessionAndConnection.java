package com.valhallagame.instanceserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionAndConnection {
	private String address;
	private int port;
	private String playerSession;
}
