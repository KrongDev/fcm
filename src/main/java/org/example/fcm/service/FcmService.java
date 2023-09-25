package org.example.fcm.service;

import com.google.firebase.messaging.*;
import lombok.extern.slf4j.Slf4j;
import org.example.fcm.aggregate.FCMToken;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class FcmService {
    //
    private final FirebaseMessaging firebaseMessaging;

    public FcmService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public void send(FCMToken token) throws FirebaseMessagingException {
        //
        if(token.isMulti()) sendMultiMessage(token);
        else sendMessage(token);
    }

    private void sendMessage(FCMToken token) throws FirebaseMessagingException {
        //
        Notification notification = Notification.builder()
                .setTitle(token.getTitle())
                .setBody(token.getMessage())
                .build();
        Message message = Message.builder()
                .setNotification(notification)
                .setToken(token.getToken())
                .build();

        String response = firebaseMessaging.send(message);
        log.info(response);
    }

    private void sendMultiMessage(FCMToken token) throws FirebaseMessagingException {
        //
        Notification notification = Notification.builder()
                .setTitle(token.getTitle())
                .setBody(token.getMessage())
                .build();

        MulticastMessage message = MulticastMessage.builder()
                .setNotification(notification)
                .addAllTokens(token.getTokens())
                .build();

        BatchResponse response = firebaseMessaging.sendEachForMulticast(message);
        log.info(response.getSuccessCount() + "");
    }
}
