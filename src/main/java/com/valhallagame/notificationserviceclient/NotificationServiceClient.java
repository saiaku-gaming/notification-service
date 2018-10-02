package com.valhallagame.notificationserviceclient;

import com.valhallagame.common.AbstractServiceClient;
import com.valhallagame.common.DefaultServicePortMappings;
import com.valhallagame.common.RestResponse;
import com.valhallagame.notificationserviceclient.message.NotificationListenerParameter;
import com.valhallagame.notificationserviceclient.message.UnregisterNotificationListenerParameter;

import java.io.IOException;

public class NotificationServiceClient extends AbstractServiceClient {
	private static NotificationServiceClient notificationServiceClient;

	private NotificationServiceClient() {
		serviceServerUrl = "http://localhost:" + DefaultServicePortMappings.NOTIFICATION_SERVICE_PORT;
	}

	public static void init(String serviceServerUrl) {
		NotificationServiceClient client = get();
		client.serviceServerUrl = serviceServerUrl;
	}

	public static NotificationServiceClient get() {
		if (notificationServiceClient == null) {
			notificationServiceClient = new NotificationServiceClient();
		}
		return notificationServiceClient;
	}

	public RestResponse<String> registerNotificationListener(String gameSessionId, String address, int port)
			throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/notification/register-notification-listener",
				new NotificationListenerParameter(gameSessionId, address, port), String.class);
	}

	public RestResponse<String> unregisterNotificationListener(String gameSessionId) throws IOException {
		return restCaller.postCall(serviceServerUrl + "/v1/notification/unregister-notification-listener",
				new UnregisterNotificationListenerParameter(gameSessionId), String.class);
	}
}
