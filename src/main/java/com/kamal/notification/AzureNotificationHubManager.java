package com.kamal.notification;

import com.windowsazure.messaging.Notification;
import com.windowsazure.messaging.NotificationHub;
import com.windowsazure.messaging.NotificationOutcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AzureNotificationHubManager {

    private static final Logger logger = Logger.getLogger(AzureNotificationHubManager.class.getCanonicalName());

    @Autowired
    private NotificationHub notificationHub;

    public NotificationOutcome pushMessageToApple(){
        NotificationOutcome notificationOutcome=new NotificationOutcome("","");
        try {
            String message = "{\"aps\":{\"alert\":\"Notification Hub test notification\"}}";
            Notification iosNotification = Notification.createAppleNotifiation(message);
            notificationOutcome = notificationHub.sendNotification(iosNotification, "");
            logger.log(Level.INFO, MessageFormat.format("notification id: {0},track id {1},message: {2}", notificationOutcome.getNotificationId(), notificationOutcome.getTrackingId(), message));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Azure Push Notification iOS devices failed.", e);
        }

        return notificationOutcome;
    }

    public NotificationOutcome pushMessageToAndroid(){
        NotificationOutcome notificationOutcome=new NotificationOutcome("","");
        try {
            String message = "{\"data\":{\"message\":\"Notification Hub test notification\"}}";
            Notification androidNotification = Notification.createGcmNotifiation(message);
            notificationOutcome = notificationHub.sendNotification(androidNotification, "");
            logger.log(Level.INFO, MessageFormat.format("notification id: {0},track id {1},message: {2}", notificationOutcome.getNotificationId(), notificationOutcome.getTrackingId(), message));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Azure Push Notification android devices failed.", e);
        }

        return notificationOutcome;
    }

}
