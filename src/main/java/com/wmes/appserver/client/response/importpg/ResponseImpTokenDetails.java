package com.wmes.appserver.client.response.importpg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class ResponseImpTokenDetails implements Serializable {

    @JsonProperty
    private String access_token;

    @JsonProperty
    private Long now;

    @JsonProperty
    private Long expired_at;

    public ResponseImpTokenDetails() {

    }
}

