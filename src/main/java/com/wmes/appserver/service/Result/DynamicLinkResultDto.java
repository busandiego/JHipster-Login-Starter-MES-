package com.wmes.appserver.service.Result;

import lombok.Data;

import java.util.Map;

@Data
public class DynamicLinkResultDto {
    private String domainUriPrefix;
    private String link;
    private Map<String, Object> androidInfo;
    private Map<String, Object> iosInfo;
    private Map<String, Object> navigationInfo;
    private Map<String, Object> analyticsInfo;
    private Map<String, Object> itunesConnectAnalytics;
    private Map<String, Object> socialMetaTagInfo;
}
