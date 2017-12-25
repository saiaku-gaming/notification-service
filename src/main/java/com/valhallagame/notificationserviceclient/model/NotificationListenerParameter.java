package com.valhallagame.notificationserviceclient.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationListenerParameter {
	@NotNull
	private String gameSessionId;
	
	@NotNull
	private String address;

	@NotNull
	private int port;
}
