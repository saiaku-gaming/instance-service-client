package com.valhallagame.instanceserviceclient.message;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPlayersInSameInstanceParameter {
	@NotNull
	private String username;
}
