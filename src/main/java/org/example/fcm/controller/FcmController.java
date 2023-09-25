package org.example.fcm.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.example.fcm.aggregate.FCMToken;
import org.example.fcm.service.FcmService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fcm")
public class FcmController {
    //
    private final FcmService fcmService;

    public FcmController(FcmService fcmService) {
        //
        this.fcmService = fcmService;
    }

    @PostMapping
    public void pushMessage(@RequestBody FCMToken token) throws FirebaseMessagingException {
        //
        fcmService.send(token);
    }
}
