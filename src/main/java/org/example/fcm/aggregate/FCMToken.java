package org.example.fcm.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FCMToken {
    //
    private String token;
    private List<String> tokens;
    private boolean multi;

    private String title;
    private String message;
}
