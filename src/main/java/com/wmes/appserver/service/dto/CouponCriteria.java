package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.CouponAmountType;
import com.wmes.appserver.domain.enumeration.CouponType;
import com.wmes.appserver.domain.enumeration.CouponUseType;
import com.wmes.appserver.domain.enumeration.StateCoupon;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Coupon} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.CouponResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /coupons?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CouponCriteria implements Serializable, Criteria {
    /**
     * Class for filtering CouponType
     */
    public static class CouponTypeFilter extends Filter<CouponType> {

        public CouponTypeFilter() {
        }

        public CouponTypeFilter(CouponTypeFilter filter) {
            super(filter);
        }

        @Override
        public CouponTypeFilter copy() {
            return new CouponTypeFilter(this);
        }

    }
    /**
     * Class for filtering CouponAmountType
     */
    public static class CouponAmountTypeFilter extends Filter<CouponAmountType> {

        public CouponAmountTypeFilter() {
        }

        public CouponAmountTypeFilter(CouponAmountTypeFilter filter) {
            super(filter);
        }

        @Override
        public CouponAmountTypeFilter copy() {
            return new CouponAmountTypeFilter(this);
        }

    }
    /**
     * Class for filtering CouponUseType
     */
    public static class CouponUseTypeFilter extends Filter<CouponUseType> {

        public CouponUseTypeFilter() {
        }

        public CouponUseTypeFilter(CouponUseTypeFilter filter) {
            super(filter);
        }

        @Override
        public CouponUseTypeFilter copy() {
            return new CouponUseTypeFilter(this);
        }

    }
    /**
     * Class for filtering StateCoupon
     */
    public static class StateCouponFilter extends Filter<StateCoupon> {

        public StateCouponFilter() {
        }

        public StateCouponFilter(StateCouponFilter filter) {
            super(filter);
        }

        @Override
        public StateCouponFilter copy() {
            return new StateCouponFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter couponName;

    private CouponTypeFilter couponType;

    private BooleanFilter couponAllUse;

    private IntegerFilter couponUseAffiliateId;

    private CouponAmountTypeFilter couponAmountType;

    private BooleanFilter couponDuplication;

    private BooleanFilter couponAutoPublish;

    private BooleanFilter couponUseTypeLimit;

    private CouponUseTypeFilter couponUseType;

    private BooleanFilter couponUsePriceLimit;

    private IntegerFilter couponUsePrice;

    private BooleanFilter couponUseExpireLimit;

    private IntegerFilter couponUseExpireMonth;

    private ZonedDateTimeFilter couponCreateDt;

    private ZonedDateTimeFilter couponUpdateDt;

    private ZonedDateTimeFilter couponCurrentPublishedDt;

    private StateCouponFilter couponState;

    public CouponCriteria(){
    }

    public CouponCriteria(CouponCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.couponName = other.couponName == null ? null : other.couponName.copy();
        this.couponType = other.couponType == null ? null : other.couponType.copy();
        this.couponAllUse = other.couponAllUse == null ? null : other.couponAllUse.copy();
        this.couponUseAffiliateId = other.couponUseAffiliateId == null ? null : other.couponUseAffiliateId.copy();
        this.couponAmountType = other.couponAmountType == null ? null : other.couponAmountType.copy();
        this.couponDuplication = other.couponDuplication == null ? null : other.couponDuplication.copy();
        this.couponAutoPublish = other.couponAutoPublish == null ? null : other.couponAutoPublish.copy();
        this.couponUseTypeLimit = other.couponUseTypeLimit == null ? null : other.couponUseTypeLimit.copy();
        this.couponUseType = other.couponUseType == null ? null : other.couponUseType.copy();
        this.couponUsePriceLimit = other.couponUsePriceLimit == null ? null : other.couponUsePriceLimit.copy();
        this.couponUsePrice = other.couponUsePrice == null ? null : other.couponUsePrice.copy();
        this.couponUseExpireLimit = other.couponUseExpireLimit == null ? null : other.couponUseExpireLimit.copy();
        this.couponUseExpireMonth = other.couponUseExpireMonth == null ? null : other.couponUseExpireMonth.copy();
        this.couponCreateDt = other.couponCreateDt == null ? null : other.couponCreateDt.copy();
        this.couponUpdateDt = other.couponUpdateDt == null ? null : other.couponUpdateDt.copy();
        this.couponCurrentPublishedDt = other.couponCurrentPublishedDt == null ? null : other.couponCurrentPublishedDt.copy();
        this.couponState = other.couponState == null ? null : other.couponState.copy();
    }

    @Override
    public CouponCriteria copy() {
        return new CouponCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCouponName() {
        return couponName;
    }

    public void setCouponName(StringFilter couponName) {
        this.couponName = couponName;
    }

    public CouponTypeFilter getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponTypeFilter couponType) {
        this.couponType = couponType;
    }

    public BooleanFilter getCouponAllUse() {
        return couponAllUse;
    }

    public void setCouponAllUse(BooleanFilter couponAllUse) {
        this.couponAllUse = couponAllUse;
    }

    public IntegerFilter getCouponUseAffiliateId() {
        return couponUseAffiliateId;
    }

    public void setCouponUseAffiliateId(IntegerFilter couponUseAffiliateId) {
        this.couponUseAffiliateId = couponUseAffiliateId;
    }

    public CouponAmountTypeFilter getCouponAmountType() {
        return couponAmountType;
    }

    public void setCouponAmountType(CouponAmountTypeFilter couponAmountType) {
        this.couponAmountType = couponAmountType;
    }

    public BooleanFilter getCouponDuplication() {
        return couponDuplication;
    }

    public void setCouponDuplication(BooleanFilter couponDuplication) {
        this.couponDuplication = couponDuplication;
    }

    public BooleanFilter getCouponAutoPublish() {
        return couponAutoPublish;
    }

    public void setCouponAutoPublish(BooleanFilter couponAutoPublish) {
        this.couponAutoPublish = couponAutoPublish;
    }

    public BooleanFilter getCouponUseTypeLimit() {
        return couponUseTypeLimit;
    }

    public void setCouponUseTypeLimit(BooleanFilter couponUseTypeLimit) {
        this.couponUseTypeLimit = couponUseTypeLimit;
    }

    public CouponUseTypeFilter getCouponUseType() {
        return couponUseType;
    }

    public void setCouponUseType(CouponUseTypeFilter couponUseType) {
        this.couponUseType = couponUseType;
    }

    public BooleanFilter getCouponUsePriceLimit() {
        return couponUsePriceLimit;
    }

    public void setCouponUsePriceLimit(BooleanFilter couponUsePriceLimit) {
        this.couponUsePriceLimit = couponUsePriceLimit;
    }

    public IntegerFilter getCouponUsePrice() {
        return couponUsePrice;
    }

    public void setCouponUsePrice(IntegerFilter couponUsePrice) {
        this.couponUsePrice = couponUsePrice;
    }

    public BooleanFilter getCouponUseExpireLimit() {
        return couponUseExpireLimit;
    }

    public void setCouponUseExpireLimit(BooleanFilter couponUseExpireLimit) {
        this.couponUseExpireLimit = couponUseExpireLimit;
    }

    public IntegerFilter getCouponUseExpireMonth() {
        return couponUseExpireMonth;
    }

    public void setCouponUseExpireMonth(IntegerFilter couponUseExpireMonth) {
        this.couponUseExpireMonth = couponUseExpireMonth;
    }

    public ZonedDateTimeFilter getCouponCreateDt() {
        return couponCreateDt;
    }

    public void setCouponCreateDt(ZonedDateTimeFilter couponCreateDt) {
        this.couponCreateDt = couponCreateDt;
    }

    public ZonedDateTimeFilter getCouponUpdateDt() {
        return couponUpdateDt;
    }

    public void setCouponUpdateDt(ZonedDateTimeFilter couponUpdateDt) {
        this.couponUpdateDt = couponUpdateDt;
    }

    public ZonedDateTimeFilter getCouponCurrentPublishedDt() {
        return couponCurrentPublishedDt;
    }

    public void setCouponCurrentPublishedDt(ZonedDateTimeFilter couponCurrentPublishedDt) {
        this.couponCurrentPublishedDt = couponCurrentPublishedDt;
    }

    public StateCouponFilter getCouponState() {
        return couponState;
    }

    public void setCouponState(StateCouponFilter couponState) {
        this.couponState = couponState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CouponCriteria that = (CouponCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(couponName, that.couponName) &&
            Objects.equals(couponType, that.couponType) &&
            Objects.equals(couponAllUse, that.couponAllUse) &&
            Objects.equals(couponUseAffiliateId, that.couponUseAffiliateId) &&
            Objects.equals(couponAmountType, that.couponAmountType) &&
            Objects.equals(couponDuplication, that.couponDuplication) &&
            Objects.equals(couponAutoPublish, that.couponAutoPublish) &&
            Objects.equals(couponUseTypeLimit, that.couponUseTypeLimit) &&
            Objects.equals(couponUseType, that.couponUseType) &&
            Objects.equals(couponUsePriceLimit, that.couponUsePriceLimit) &&
            Objects.equals(couponUsePrice, that.couponUsePrice) &&
            Objects.equals(couponUseExpireLimit, that.couponUseExpireLimit) &&
            Objects.equals(couponUseExpireMonth, that.couponUseExpireMonth) &&
            Objects.equals(couponCreateDt, that.couponCreateDt) &&
            Objects.equals(couponUpdateDt, that.couponUpdateDt) &&
            Objects.equals(couponCurrentPublishedDt, that.couponCurrentPublishedDt) &&
            Objects.equals(couponState, that.couponState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        couponName,
        couponType,
        couponAllUse,
        couponUseAffiliateId,
        couponAmountType,
        couponDuplication,
        couponAutoPublish,
        couponUseTypeLimit,
        couponUseType,
        couponUsePriceLimit,
        couponUsePrice,
        couponUseExpireLimit,
        couponUseExpireMonth,
        couponCreateDt,
        couponUpdateDt,
        couponCurrentPublishedDt,
        couponState
        );
    }

    @Override
    public String toString() {
        return "CouponCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (couponName != null ? "couponName=" + couponName + ", " : "") +
                (couponType != null ? "couponType=" + couponType + ", " : "") +
                (couponAllUse != null ? "couponAllUse=" + couponAllUse + ", " : "") +
                (couponUseAffiliateId != null ? "couponUseAffiliateId=" + couponUseAffiliateId + ", " : "") +
                (couponAmountType != null ? "couponAmountType=" + couponAmountType + ", " : "") +
                (couponDuplication != null ? "couponDuplication=" + couponDuplication + ", " : "") +
                (couponAutoPublish != null ? "couponAutoPublish=" + couponAutoPublish + ", " : "") +
                (couponUseTypeLimit != null ? "couponUseTypeLimit=" + couponUseTypeLimit + ", " : "") +
                (couponUseType != null ? "couponUseType=" + couponUseType + ", " : "") +
                (couponUsePriceLimit != null ? "couponUsePriceLimit=" + couponUsePriceLimit + ", " : "") +
                (couponUsePrice != null ? "couponUsePrice=" + couponUsePrice + ", " : "") +
                (couponUseExpireLimit != null ? "couponUseExpireLimit=" + couponUseExpireLimit + ", " : "") +
                (couponUseExpireMonth != null ? "couponUseExpireMonth=" + couponUseExpireMonth + ", " : "") +
                (couponCreateDt != null ? "couponCreateDt=" + couponCreateDt + ", " : "") +
                (couponUpdateDt != null ? "couponUpdateDt=" + couponUpdateDt + ", " : "") +
                (couponCurrentPublishedDt != null ? "couponCurrentPublishedDt=" + couponCurrentPublishedDt + ", " : "") +
                (couponState != null ? "couponState=" + couponState + ", " : "") +
            "}";
    }

}
