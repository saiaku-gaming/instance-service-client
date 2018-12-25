package com.valhallagame.instanceserviceclient.message;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstancePlayerLoginParameter {
	@NotBlank
	private String token;
	
	@NotBlank
	private String gameSessionId;
}
