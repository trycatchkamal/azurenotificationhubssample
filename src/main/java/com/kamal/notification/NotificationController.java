package com.kamal.notification;

import com.windowsazure.messaging.NotificationOutcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RequestMapping("/api")
@RestController
public class NotificationController {

    @Autowired
    private AzureNotificationHubManager hub;

    @RequestMapping(value = "/apple",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String sendNotificationToApple() {
        NotificationOutcome notificationOutcome = hub.pushMessageToApple();
        return MessageFormat.format("Pushed notification Apple-Notification ID: {0}, Tracking ID: {1}", notificationOutcome.getNotificationId(), notificationOutcome.getTrackingId());
    }

    @RequestMapping(value = "/droid",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String sendNotificationToAndroid() {
        NotificationOutcome notificationOutcome = hub.pushMessageToAndroid();
        return MessageFormat.format("Pushed notification Droid-Notification ID: {0}, Tracking ID: {1}", notificationOutcome.getNotificationId(), notificationOutcome.getTrackingId());
    }
}

