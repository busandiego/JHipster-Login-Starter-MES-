package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.CouponHistories} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.CouponHistoriesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /coupon-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CouponHistoriesCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter pushishUniqCode;

    private ZonedDateTimeFilter publishedDt;

    private BooleanFilter useCheck;

    private LongFilter paymentId;

    private LongFilter couponId;

    private LongFilter useMemberId;

    private LongFilter couponPublisherId;

    public CouponHistoriesCriteria(){
    }

    public CouponHistoriesCriteria(CouponHistoriesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.pushishUniqCode = other.pushishUniqCode == null ? null : other.pushishUniqCode.copy();
        this.publishedDt = other.publishedDt == null ? null : other.publishedDt.copy();
        this.useCheck = other.useCheck == null ? null : other.useCheck.copy();
        this.paymentId = other.paymentId == null ? null : other.paymentId.copy();
        this.couponId = other.couponId == null ? null : other.couponId.copy();
        this.useMemberId = other.useMemberId == null ? null : other.useMemberId.copy();
        this.couponPublisherId = other.couponPublisherId == null ? null : other.couponPublisherId.copy();
    }

    @Override
    public CouponHistoriesCriteria copy() {
        return new CouponHistoriesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPushishUniqCode() {
        return pushishUniqCode;
    }

    public void setPushishUniqCode(StringFilter pushishUniqCode) {
        this.pushishUniqCode = pushishUniqCode;
    }

    public ZonedDateTimeFilter getPublishedDt() {
        return publishedDt;
    }

    public void setPublishedDt(ZonedDateTimeFilter publishedDt) {
        this.publishedDt = publishedDt;
    }

    public BooleanFilter getUseCheck() {
        return useCheck;
    }

    public void setUseCheck(BooleanFilter useCheck) {
        this.useCheck = useCheck;
    }

    public LongFilter getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(LongFilter paymentId) {
        this.paymentId = paymentId;
    }

    public LongFilter getCouponId() {
        return couponId;
    }

    public void setCouponId(LongFilter couponId) {
        this.couponId = couponId;
    }

    public LongFilter getUseMemberId() {
        return useMemberId;
    }

    public void setUseMemberId(LongFilter useMemberId) {
        this.useMemberId = useMemberId;
    }

    public LongFilter getCouponPublisherId() {
        return couponPublisherId;
    }

    public void setCouponPublisherId(LongFilter couponPublisherId) {
        this.couponPublisherId = couponPublisherId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CouponHistoriesCriteria that = (CouponHistoriesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(pushishUniqCode, that.pushishUniqCode) &&
            Objects.equals(publishedDt, that.publishedDt) &&
            Objects.equals(useCheck, that.useCheck) &&
            Objects.equals(paymentId, that.paymentId) &&
            Objects.equals(couponId, that.couponId) &&
            Objects.equals(useMemberId, that.useMemberId) &&
            Objects.equals(couponPublisherId, that.couponPublisherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        pushishUniqCode,
        publishedDt,
        useCheck,
        paymentId,
        couponId,
        useMemberId,
        couponPublisherId
        );
    }

    @Override
    public String toString() {
        return "CouponHistoriesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (pushishUniqCode != null ? "pushishUniqCode=" + pushishUniqCode + ", " : "") +
                (publishedDt != null ? "publishedDt=" + publishedDt + ", " : "") +
                (useCheck != null ? "useCheck=" + useCheck + ", " : "") +
                (paymentId != null ? "paymentId=" + paymentId + ", " : "") +
                (couponId != null ? "couponId=" + couponId + ", " : "") +
                (useMemberId != null ? "useMemberId=" + useMemberId + ", " : "") +
                (couponPublisherId != null ? "couponPublisherId=" + couponPublisherId + ", " : "") +
            "}";
    }

}
