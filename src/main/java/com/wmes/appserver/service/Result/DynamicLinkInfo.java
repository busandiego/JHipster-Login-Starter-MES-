package com.wmes.appserver.service.Result;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class DynamicLinkInfo implements Serializable {

    @JsonProperty
    private String shortLink;

    @JsonProperty
    private String previewLink;

    public DynamicLinkInfo() {

    }
}

