package com.kamal.notification;

import com.windowsazure.messaging.NotificationHub;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationTestApplication {

	@Value("${azure.notificationhub.defaultlistensharedaccesssignature}")
	private String accessSignature;

	@Value("${azure.notificationhubname}")
	private String hubpath;

	public static void main(String[] args) {
		SpringApplication.run(NotificationTestApplication.class, args);
	}

	@Bean
	public NotificationHub getNotificationHub(){
		return new NotificationHub(accessSignature,hubpath);
	}
}
