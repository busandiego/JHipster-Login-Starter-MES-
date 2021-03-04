package com.wmes.appserver.service.Result;

import lombok.Data;

import java.util.Map;

@Data
public class PushResultDto {
    private String pushToken;
    private Map<String, Object> data;

}
