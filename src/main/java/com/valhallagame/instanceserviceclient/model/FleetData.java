package com.valhallagame.instanceserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FleetData {
	private String version;
	private String status;
	private int instanceCount;
}
