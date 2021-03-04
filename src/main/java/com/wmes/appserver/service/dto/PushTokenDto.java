package com.wmes.appserver.service.dto;

import lombok.Data;

@Data
public class PushTokenDto {

    private String pushToken;

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }
}
