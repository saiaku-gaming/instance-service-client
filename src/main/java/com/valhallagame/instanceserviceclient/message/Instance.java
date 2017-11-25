package com.valhallagame.instanceserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instance {
	private String owner;
	
	//Case sensative as it overrides DisplayUsername
	private String instanceName;
	
    private String chestItem;

    private String mainhandArmament;
    
    private String offHandArmament;
}
