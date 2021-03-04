package com.wmes.appserver.client.response.importpg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class RequestTokenInfo implements Serializable {

    @JsonProperty
    private String imp_key; //인터페이스 아이디 (필수)

    @JsonProperty
    private String imp_secret; // 착신번호 (필수)

    public RequestTokenInfo() {

    }
}

