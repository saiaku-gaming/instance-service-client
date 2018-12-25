package com.valhallagame.instanceserviceclient.message;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.valhallagame.common.validation.CheckLowercase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHubParameter {
	@NotBlank
	@CheckLowercase
	private String username;

	@NotBlank
	private String version;
}
