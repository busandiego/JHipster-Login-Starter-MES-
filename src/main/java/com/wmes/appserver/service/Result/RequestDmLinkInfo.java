package com.wmes.appserver.service.Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RequestDmLinkInfo {
    @JsonProperty
    private String domainUriPrefix;
    @JsonProperty
    private String link;
//    @JsonProperty
//    private Map<String, Object> androidInfo;
//    @JsonProperty
//    private Map<String, Object> iosInfo;
//    @JsonProperty
//    private Map<String, Object> navigationInfo;
//    @JsonProperty
//    private Map<String, Object> analyticsInfo;
//    @JsonProperty
//    private Map<String, Object> itunesConnectAnalytics;
    @JsonProperty
    private SocialMetaInfo socialMetaTagInfo;

    public RequestDmLinkInfo() {

    }
}
