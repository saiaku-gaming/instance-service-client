package com.valhallagame.instanceserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstancePlayerLogoutParameter {
	@NotNull
	private String username;
	
	@NotNull
	private String gameSessionId;
}
