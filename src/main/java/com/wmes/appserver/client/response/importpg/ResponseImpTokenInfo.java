package com.wmes.appserver.client.response.importpg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class ResponseImpTokenInfo implements Serializable {

    @JsonProperty
    private Integer code;

    @JsonProperty
    private String message;

    @JsonProperty
    private ResponseImpTokenDetails response;

    public ResponseImpTokenInfo() {

    }
}

