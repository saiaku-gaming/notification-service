package com.valhallagame.notificationserviceclient.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationListenerParameter {
	@NotBlank
	private String gameSessionId;

	@NotBlank
	private String address;

	@NotNull
	private int port;
}
