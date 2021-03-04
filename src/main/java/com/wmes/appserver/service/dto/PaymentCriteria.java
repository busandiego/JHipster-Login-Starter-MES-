package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.StatePayment;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Payment} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.PaymentResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /payments?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PaymentCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StatePayment
     */
    public static class StatePaymentFilter extends Filter<StatePayment> {

        public StatePaymentFilter() {
        }

        public StatePaymentFilter(StatePaymentFilter filter) {
            super(filter);
        }

        @Override
        public StatePaymentFilter copy() {
            return new StatePaymentFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter sellingPrice;

    private IntegerFilter commission;

    private IntegerFilter paymentMoney;

    private StringFilter paymentType;

    private ZonedDateTimeFilter paymentDt;

    private IntegerFilter couponDiscount;

    private StringFilter transactionNum;

    private StringFilter paymentMethod;

    private StringFilter remark;

    private LongFilter reservationId;

    private StatePaymentFilter paymentState;

    public PaymentCriteria(){
    }

    public PaymentCriteria(PaymentCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.sellingPrice = other.sellingPrice == null ? null : other.sellingPrice.copy();
        this.commission = other.commission == null ? null : other.commission.copy();
        this.paymentMoney = other.paymentMoney == null ? null : other.paymentMoney.copy();
        this.paymentType = other.paymentType == null ? null : other.paymentType.copy();
        this.paymentDt = other.paymentDt == null ? null : other.paymentDt.copy();
        this.couponDiscount = other.couponDiscount == null ? null : other.couponDiscount.copy();
        this.transactionNum = other.transactionNum == null ? null : other.transactionNum.copy();
        this.paymentMethod = other.paymentMethod == null ? null : other.paymentMethod.copy();
        this.remark = other.remark == null ? null : other.remark.copy();
        this.reservationId = other.reservationId == null ? null : other.reservationId.copy();
        this.paymentState = other.paymentState == null ? null : other.paymentState.copy();
    }

    @Override
    public PaymentCriteria copy() {
        return new PaymentCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(IntegerFilter sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public IntegerFilter getCommission() {
        return commission;
    }

    public void setCommission(IntegerFilter commission) {
        this.commission = commission;
    }

    public IntegerFilter getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(IntegerFilter paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public StringFilter getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(StringFilter paymentType) {
        this.paymentType = paymentType;
    }

    public ZonedDateTimeFilter getPaymentDt() {
        return paymentDt;
    }

    public void setPaymentDt(ZonedDateTimeFilter paymentDt) {
        this.paymentDt = paymentDt;
    }

    public IntegerFilter getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(IntegerFilter couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public StringFilter getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(StringFilter transactionNum) {
        this.transactionNum = transactionNum;
    }

    public StringFilter getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(StringFilter paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public StringFilter getRemark() {
        return remark;
    }

    public void setRemark(StringFilter remark) {
        this.remark = remark;
    }

    public LongFilter getReservationId() {
        return reservationId;
    }

    public void setReservationId(LongFilter reservationId) {
        this.reservationId = reservationId;
    }

    public StatePaymentFilter getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(StatePaymentFilter paymentState) {
        this.paymentState = paymentState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PaymentCriteria that = (PaymentCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(sellingPrice, that.sellingPrice) &&
            Objects.equals(commission, that.commission) &&
            Objects.equals(paymentMoney, that.paymentMoney) &&
            Objects.equals(paymentType, that.paymentType) &&
            Objects.equals(paymentDt, that.paymentDt) &&
            Objects.equals(couponDiscount, that.couponDiscount) &&
            Objects.equals(transactionNum, that.transactionNum) &&
            Objects.equals(paymentMethod, that.paymentMethod) &&
            Objects.equals(remark, that.remark) &&
            Objects.equals(reservationId, that.reservationId) &&
            Objects.equals(paymentState, that.paymentState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        sellingPrice,
        commission,
        paymentMoney,
        paymentType,
        paymentDt,
        couponDiscount,
        transactionNum,
        paymentMethod,
        remark,
        reservationId,
        paymentState
        );
    }

    @Override
    public String toString() {
        return "PaymentCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (sellingPrice != null ? "sellingPrice=" + sellingPrice + ", " : "") +
                (commission != null ? "commission=" + commission + ", " : "") +
                (paymentMoney != null ? "paymentMoney=" + paymentMoney + ", " : "") +
                (paymentType != null ? "paymentType=" + paymentType + ", " : "") +
                (paymentDt != null ? "paymentDt=" + paymentDt + ", " : "") +
                (couponDiscount != null ? "couponDiscount=" + couponDiscount + ", " : "") +
                (transactionNum != null ? "transactionNum=" + transactionNum + ", " : "") +
                (paymentMethod != null ? "paymentMethod=" + paymentMethod + ", " : "") +
                (remark != null ? "remark=" + remark + ", " : "") +
                (reservationId != null ? "reservationId=" + reservationId + ", " : "") +
                (paymentState != null ? "paymentState=" + paymentState + ", " : "") +
            "}";
    }

}
