package com.wmes.appserver.service.Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SocialMetaInfo {
    @JsonProperty
    private String socialTitle;
    @JsonProperty
    private String socialDescription;
    @JsonProperty
    private String socialImageLink;


    public SocialMetaInfo() {

    }
}
