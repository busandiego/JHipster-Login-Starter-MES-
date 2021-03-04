package com.wmes.appserver.client.response.bizcall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class ResponseBizCallInfo implements Serializable {

    @JsonProperty
    private Integer rt;

    @JsonProperty
    private String rs;

    @JsonProperty
    private String vn;

    public ResponseBizCallInfo() {

    }
}

