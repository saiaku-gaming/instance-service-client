package com.valhallagame.instanceserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDungeonConnectionParameter {
	@NotBlank
	@CheckLowercase
	private String username;

	@NotNull
	private String instanceId;

	@NotNull
	private String version;
}
