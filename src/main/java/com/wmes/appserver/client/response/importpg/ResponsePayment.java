package com.wmes.appserver.client.response.importpg;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ResponsePayment implements Serializable {

    @JsonProperty
    String imp_uid;

    @JsonProperty
    String merchant_uid;

    @JsonProperty
    String pay_method;

    @JsonProperty
    String pg_provider;

    @JsonProperty
    String pg_tid;

    @JsonProperty
    boolean escrow;

    @JsonProperty
    String apply_num;

    @JsonProperty
    String bank_code;

    @JsonProperty
    String bank_name;

    @JsonProperty
    String card_code;

    @JsonProperty
    String card_name;

    @JsonProperty
    int card_quota;

    @JsonProperty
    String vbank_code;

    @JsonProperty
    String vbank_name;

    @JsonProperty
    String vbank_num;

    @JsonProperty
    String vbank_holder;

    @JsonProperty
    long vbank_date;

    @JsonProperty
    String name;

    @JsonProperty
    BigDecimal amount;

    @JsonProperty
    BigDecimal cancel_amount;

    @JsonProperty
    String buyer_name;

    @JsonProperty
    String buyer_email;

    @JsonProperty
    String buyer_tel;

    @JsonProperty
    String buyer_addr;

    @JsonProperty
    String buyer_postcode;

    @JsonProperty
    String custom_data;

    @JsonProperty
    String status;

    @JsonProperty
    long paid_at;

    @JsonProperty
    long failed_at;

    @JsonProperty
    long cancelled_at;

    @JsonProperty
    String fail_reason;

    @JsonProperty
    String cancel_reason;

    @JsonProperty
    String receipt_url;

    @JsonProperty
    PaymentCancelDetail[] cancel_history;

    @JsonProperty
    boolean cash_receipt_issued;

    public String getImpUid() {
        return imp_uid;
    }

    public String getMerchantUid() {
        return merchant_uid;
    }

    public String getPayMethod() {
        return pay_method;
    }

    public String getPgProvider() {
        return pg_provider;
    }

    public String getPgTid() {
        return pg_tid;
    }

    public boolean isEscrow() {
        return escrow;
    }

    public String getApplyNum() {
        return apply_num;
    }

    public String getBankCode() {
        return bank_code;
    }

    public String getBankName() {
        return bank_name;
    }

    public String getCardCode() {
        return card_code;
    }

    public String getCardName() {
        return card_name;
    }

    public int getCardQuota() {
        return card_quota;
    }

    public String getVbankCode() {
        return vbank_code;
    }

    public String getVbankName() {
        return vbank_name;
    }

    public String getVbankNum() {
        return vbank_num;
    }

    public String getVbankHolder() {
        return vbank_holder;
    }

    public Date getVbankDate() {
        return new Date( vbank_date * 1000L );
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getCancelAmount() {
        return cancel_amount;
    }

    public String getBuyerName() {
        return buyer_name;
    }

    public String getBuyerEmail() {
        return buyer_email;
    }

    public String getBuyerTel() {
        return buyer_tel;
    }

    public String getBuyerAddr() {
        return buyer_addr;
    }

    public String getBuyerPostcode() {
        return buyer_postcode;
    }

    public String getCustomData() {
        return custom_data;
    }

    public String getStatus() {
        return status;
    }

    public Date getPaidAt() {
        return new Date( paid_at * 1000L );
    }

    public Date getFailedAt() {
        return new Date( failed_at * 1000L );
    }

    public Date getCancelledAt() {
        return new Date( cancelled_at * 1000L );
    }

    public String getFailReason() {
        return fail_reason;
    }

    public String getCancelReason() {
        return cancel_reason;
    }

    public String getReceiptUrl() {
        return receipt_url;
    }

    public PaymentCancelDetail[] getCancelHistory() {
        return cancel_history;
    }

    public boolean isCashReceiptIssued() {
        return cash_receipt_issued;
    }
}
