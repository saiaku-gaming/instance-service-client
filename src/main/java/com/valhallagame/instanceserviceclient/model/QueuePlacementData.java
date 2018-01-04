package com.valhallagame.instanceserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueuePlacementData {
	private String id;
	private String queuerUsername;
	private String status;
	private String mapName;
	private String version;
}

