package com.valhallagame.instanceserviceclient.message;

import com.valhallagame.common.validation.CheckLowercase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDungeonConnectionParameter {
	@NotBlank
	@CheckLowercase
	private String username;

    @NotBlank
	private String instanceId;

    @NotBlank
	private String version;
}
