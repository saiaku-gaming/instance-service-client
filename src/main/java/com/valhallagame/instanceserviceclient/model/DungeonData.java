package com.valhallagame.instanceserviceclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DungeonData {
	private Integer id;
	private InstanceData instance;
	private String ownerUsername;
	private Integer ownerPartyId;
	private String creatorUsername;
}
