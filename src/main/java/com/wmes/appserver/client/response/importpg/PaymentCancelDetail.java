package com.wmes.appserver.client.response.importpg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentCancelDetail implements Serializable {

    @JsonProperty("pg_tid")
    String pg_tid;

    @JsonProperty("amount")
    BigDecimal amount;

    @JsonProperty("cancelled_at")
    long cancelled_at;

    @JsonProperty("reason")
    String reason;

    @JsonProperty("receipt_url")
    String receipt_url;
}
