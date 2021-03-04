package com.wmes.appserver.client.response.bizcall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter @Getter
public class RequestBizCallInfo implements Serializable {

    @JsonProperty
    private String iid; //인터페이스 아이디 (필수)

    @JsonProperty
    private String rn; // 착신번호 (필수)

    @JsonProperty
    private String expire_hour; // 해지만료시간 (필수) ex) 12시간 뒤 자동 해지 -> 12

    @JsonProperty
    private String memo; // 업체용 추가 텍스트

    @JsonProperty
    private String memo2;

    @JsonProperty
    private String black_rn;

    @JsonProperty
    private String white_rn;

    @JsonProperty
    private String auth; //iid+rn를 MD5 암호화 한 후 BASE64 인코딩된 값

    public RequestBizCallInfo() {

    }
}

