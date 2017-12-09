package com.valhallagame.instanceserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StartDungonParameter {
	String username;
	String map;
	String version;
}
