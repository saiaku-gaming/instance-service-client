package com.valhallagame.instanceserviceclient.message;

import javax.validation.constraints.NotNull;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartDungeonParameter {
	@NotNull
	@CheckLowercase
	private String username;

	@NotNull
	private String map;

	@NotNull
	private String version;
}
