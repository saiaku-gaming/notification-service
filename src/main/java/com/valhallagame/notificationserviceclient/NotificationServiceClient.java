package com.valhallagame.notificationserviceclient;

import java.io.IOException;

import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestCaller;
import com.valhallagame.common.RestResponse;
import com.valhallagame.notificationserviceclient.message.NotificationListenerParameter;
import com.valhallagame.notificationserviceclient.message.UnregisterNotificationListenerParameter;

public class NotificationServiceClient {
	private static NotificationServiceClient notificationServiceClient;

	private String notificationServiceServerUrl = "http://localhost:"
			+ DefaultServicePortMappings.NOTIFICATION_SERVICE_PORT;
	private RestCaller restCaller;

	private NotificationServiceClient() {
		restCaller = new RestCaller();
	}

	public static void init(String notificationServiceServerUrl) {
		NotificationServiceClient client = get();
		client.notificationServiceServerUrl = notificationServiceServerUrl;
	}

	public static NotificationServiceClient get() {
		if (notificationServiceClient == null) {
			notificationServiceClient = new NotificationServiceClient();
		}

		return notificationServiceClient;
	}

	public RestResponse<String> registerNotificationListener(String gameSessionId, String address, int port)
			throws IOException {
		return restCaller.postCall(notificationServiceServerUrl + "/v1/notification/register-notification-listener",
				new NotificationListenerParameter(gameSessionId, address, port), String.class);
	}

	public RestResponse<String> unregisterNotificationListener(String gameSessionId) throws IOException {
		return restCaller.postCall(notificationServiceServerUrl + "/v1/notification/unregister-notification-listener",
				new UnregisterNotificationListenerParameter(gameSessionId), String.class);
	}
}
