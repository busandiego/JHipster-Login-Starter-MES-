package com.wmes.appserver.service.Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RequestDmInfo {
    @JsonProperty
    private RequestDmLinkInfo dynamicLinkInfo;
    @JsonProperty
    private RequestSuffixInfo suffix;

    public RequestDmInfo() {

    }
}
