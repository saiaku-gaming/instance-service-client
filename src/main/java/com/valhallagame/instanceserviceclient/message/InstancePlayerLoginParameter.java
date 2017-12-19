package com.valhallagame.instanceserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstancePlayerLoginParameter {
	private String username;
	private String gameSessionId;
}
