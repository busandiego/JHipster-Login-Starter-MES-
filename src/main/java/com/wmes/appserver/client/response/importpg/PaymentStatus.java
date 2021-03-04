package com.wmes.appserver.client.response.importpg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class PaymentStatus implements Serializable {

    @JsonProperty
    private String imp_uid;

    @JsonProperty
    private String merchant_uid;

    @JsonProperty
    private String status;
}
