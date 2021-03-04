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
 * Criteria class for the {@link com.wmes.appserver.domain.PublishedCouponInfo} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.PublishedCouponInfoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /published-coupon-infos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PublishedCouponInfoCriteria implements Serializable, Criteria {
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

    private StringFilter publishedCouponName;

    private CouponTypeFilter publishedCouponType;

    private BooleanFilter publishedCouponAllUse;

    private IntegerFilter publishedCouponUseAffiliateId;

    private CouponAmountTypeFilter publishedCouponAmountType;

    private BooleanFilter publishedCouponDuplication;

    private BooleanFilter publishedCouponAutoPublish;

    private BooleanFilter publishedCouponUseTypeLimit;

    private CouponUseTypeFilter publishedCouponUseType;

    private BooleanFilter publishedCouponUsePriceLimit;

    private IntegerFilter publishedCouponUsePrice;

    private BooleanFilter publishedCouponUseExpireLimit;

    private IntegerFilter publishedCouponUseExpireMonth;

    private ZonedDateTimeFilter publishedCouponCreateDt;

    private ZonedDateTimeFilter publishedCouponUpdateDt;

    private ZonedDateTimeFilter publishedCouponCurrentPublishedDt;

    private IntegerFilter publishedCouponAmountNum;

    private IntegerFilter publishedCouponSoldNum;

    private StateCouponFilter couponState;

    private LongFilter couponPublishedHistoriesId;

    public PublishedCouponInfoCriteria(){
    }

    public PublishedCouponInfoCriteria(PublishedCouponInfoCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.publishedCouponName = other.publishedCouponName == null ? null : other.publishedCouponName.copy();
        this.publishedCouponType = other.publishedCouponType == null ? null : other.publishedCouponType.copy();
        this.publishedCouponAllUse = other.publishedCouponAllUse == null ? null : other.publishedCouponAllUse.copy();
        this.publishedCouponUseAffiliateId = other.publishedCouponUseAffiliateId == null ? null : other.publishedCouponUseAffiliateId.copy();
        this.publishedCouponAmountType = other.publishedCouponAmountType == null ? null : other.publishedCouponAmountType.copy();
        this.publishedCouponDuplication = other.publishedCouponDuplication == null ? null : other.publishedCouponDuplication.copy();
        this.publishedCouponAutoPublish = other.publishedCouponAutoPublish == null ? null : other.publishedCouponAutoPublish.copy();
        this.publishedCouponUseTypeLimit = other.publishedCouponUseTypeLimit == null ? null : other.publishedCouponUseTypeLimit.copy();
        this.publishedCouponUseType = other.publishedCouponUseType == null ? null : other.publishedCouponUseType.copy();
        this.publishedCouponUsePriceLimit = other.publishedCouponUsePriceLimit == null ? null : other.publishedCouponUsePriceLimit.copy();
        this.publishedCouponUsePrice = other.publishedCouponUsePrice == null ? null : other.publishedCouponUsePrice.copy();
        this.publishedCouponUseExpireLimit = other.publishedCouponUseExpireLimit == null ? null : other.publishedCouponUseExpireLimit.copy();
        this.publishedCouponUseExpireMonth = other.publishedCouponUseExpireMonth == null ? null : other.publishedCouponUseExpireMonth.copy();
        this.publishedCouponCreateDt = other.publishedCouponCreateDt == null ? null : other.publishedCouponCreateDt.copy();
        this.publishedCouponUpdateDt = other.publishedCouponUpdateDt == null ? null : other.publishedCouponUpdateDt.copy();
        this.publishedCouponCurrentPublishedDt = other.publishedCouponCurrentPublishedDt == null ? null : other.publishedCouponCurrentPublishedDt.copy();
        this.publishedCouponAmountNum = other.publishedCouponAmountNum == null ? null : other.publishedCouponAmountNum.copy();
        this.publishedCouponSoldNum = other.publishedCouponSoldNum == null ? null : other.publishedCouponSoldNum.copy();
        this.couponState = other.couponState == null ? null : other.couponState.copy();
        this.couponPublishedHistoriesId = other.couponPublishedHistoriesId == null ? null : other.couponPublishedHistoriesId.copy();
    }

    @Override
    public PublishedCouponInfoCriteria copy() {
        return new PublishedCouponInfoCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPublishedCouponName() {
        return publishedCouponName;
    }

    public void setPublishedCouponName(StringFilter publishedCouponName) {
        this.publishedCouponName = publishedCouponName;
    }

    public CouponTypeFilter getPublishedCouponType() {
        return publishedCouponType;
    }

    public void setPublishedCouponType(CouponTypeFilter publishedCouponType) {
        this.publishedCouponType = publishedCouponType;
    }

    public BooleanFilter getPublishedCouponAllUse() {
        return publishedCouponAllUse;
    }

    public void setPublishedCouponAllUse(BooleanFilter publishedCouponAllUse) {
        this.publishedCouponAllUse = publishedCouponAllUse;
    }

    public IntegerFilter getPublishedCouponUseAffiliateId() {
        return publishedCouponUseAffiliateId;
    }

    public void setPublishedCouponUseAffiliateId(IntegerFilter publishedCouponUseAffiliateId) {
        this.publishedCouponUseAffiliateId = publishedCouponUseAffiliateId;
    }

    public CouponAmountTypeFilter getPublishedCouponAmountType() {
        return publishedCouponAmountType;
    }

    public void setPublishedCouponAmountType(CouponAmountTypeFilter publishedCouponAmountType) {
        this.publishedCouponAmountType = publishedCouponAmountType;
    }

    public BooleanFilter getPublishedCouponDuplication() {
        return publishedCouponDuplication;
    }

    public void setPublishedCouponDuplication(BooleanFilter publishedCouponDuplication) {
        this.publishedCouponDuplication = publishedCouponDuplication;
    }

    public BooleanFilter getPublishedCouponAutoPublish() {
        return publishedCouponAutoPublish;
    }

    public void setPublishedCouponAutoPublish(BooleanFilter publishedCouponAutoPublish) {
        this.publishedCouponAutoPublish = publishedCouponAutoPublish;
    }

    public BooleanFilter getPublishedCouponUseTypeLimit() {
        return publishedCouponUseTypeLimit;
    }

    public void setPublishedCouponUseTypeLimit(BooleanFilter publishedCouponUseTypeLimit) {
        this.publishedCouponUseTypeLimit = publishedCouponUseTypeLimit;
    }

    public CouponUseTypeFilter getPublishedCouponUseType() {
        return publishedCouponUseType;
    }

    public void setPublishedCouponUseType(CouponUseTypeFilter publishedCouponUseType) {
        this.publishedCouponUseType = publishedCouponUseType;
    }

    public BooleanFilter getPublishedCouponUsePriceLimit() {
        return publishedCouponUsePriceLimit;
    }

    public void setPublishedCouponUsePriceLimit(BooleanFilter publishedCouponUsePriceLimit) {
        this.publishedCouponUsePriceLimit = publishedCouponUsePriceLimit;
    }

    public IntegerFilter getPublishedCouponUsePrice() {
        return publishedCouponUsePrice;
    }

    public void setPublishedCouponUsePrice(IntegerFilter publishedCouponUsePrice) {
        this.publishedCouponUsePrice = publishedCouponUsePrice;
    }

    public BooleanFilter getPublishedCouponUseExpireLimit() {
        return publishedCouponUseExpireLimit;
    }

    public void setPublishedCouponUseExpireLimit(BooleanFilter publishedCouponUseExpireLimit) {
        this.publishedCouponUseExpireLimit = publishedCouponUseExpireLimit;
    }

    public IntegerFilter getPublishedCouponUseExpireMonth() {
        return publishedCouponUseExpireMonth;
    }

    public void setPublishedCouponUseExpireMonth(IntegerFilter publishedCouponUseExpireMonth) {
        this.publishedCouponUseExpireMonth = publishedCouponUseExpireMonth;
    }

    public ZonedDateTimeFilter getPublishedCouponCreateDt() {
        return publishedCouponCreateDt;
    }

    public void setPublishedCouponCreateDt(ZonedDateTimeFilter publishedCouponCreateDt) {
        this.publishedCouponCreateDt = publishedCouponCreateDt;
    }

    public ZonedDateTimeFilter getPublishedCouponUpdateDt() {
        return publishedCouponUpdateDt;
    }

    public void setPublishedCouponUpdateDt(ZonedDateTimeFilter publishedCouponUpdateDt) {
        this.publishedCouponUpdateDt = publishedCouponUpdateDt;
    }

    public ZonedDateTimeFilter getPublishedCouponCurrentPublishedDt() {
        return publishedCouponCurrentPublishedDt;
    }

    public void setPublishedCouponCurrentPublishedDt(ZonedDateTimeFilter publishedCouponCurrentPublishedDt) {
        this.publishedCouponCurrentPublishedDt = publishedCouponCurrentPublishedDt;
    }

    public IntegerFilter getPublishedCouponAmountNum() {
        return publishedCouponAmountNum;
    }

    public void setPublishedCouponAmountNum(IntegerFilter publishedCouponAmountNum) {
        this.publishedCouponAmountNum = publishedCouponAmountNum;
    }

    public IntegerFilter getPublishedCouponSoldNum() {
        return publishedCouponSoldNum;
    }

    public void setPublishedCouponSoldNum(IntegerFilter publishedCouponSoldNum) {
        this.publishedCouponSoldNum = publishedCouponSoldNum;
    }

    public StateCouponFilter getCouponState() {
        return couponState;
    }

    public void setCouponState(StateCouponFilter couponState) {
        this.couponState = couponState;
    }

    public LongFilter getCouponPublishedHistoriesId() {
        return couponPublishedHistoriesId;
    }

    public void setCouponPublishedHistoriesId(LongFilter couponPublishedHistoriesId) {
        this.couponPublishedHistoriesId = couponPublishedHistoriesId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PublishedCouponInfoCriteria that = (PublishedCouponInfoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(publishedCouponName, that.publishedCouponName) &&
            Objects.equals(publishedCouponType, that.publishedCouponType) &&
            Objects.equals(publishedCouponAllUse, that.publishedCouponAllUse) &&
            Objects.equals(publishedCouponUseAffiliateId, that.publishedCouponUseAffiliateId) &&
            Objects.equals(publishedCouponAmountType, that.publishedCouponAmountType) &&
            Objects.equals(publishedCouponDuplication, that.publishedCouponDuplication) &&
            Objects.equals(publishedCouponAutoPublish, that.publishedCouponAutoPublish) &&
            Objects.equals(publishedCouponUseTypeLimit, that.publishedCouponUseTypeLimit) &&
            Objects.equals(publishedCouponUseType, that.publishedCouponUseType) &&
            Objects.equals(publishedCouponUsePriceLimit, that.publishedCouponUsePriceLimit) &&
            Objects.equals(publishedCouponUsePrice, that.publishedCouponUsePrice) &&
            Objects.equals(publishedCouponUseExpireLimit, that.publishedCouponUseExpireLimit) &&
            Objects.equals(publishedCouponUseExpireMonth, that.publishedCouponUseExpireMonth) &&
            Objects.equals(publishedCouponCreateDt, that.publishedCouponCreateDt) &&
            Objects.equals(publishedCouponUpdateDt, that.publishedCouponUpdateDt) &&
            Objects.equals(publishedCouponCurrentPublishedDt, that.publishedCouponCurrentPublishedDt) &&
            Objects.equals(publishedCouponAmountNum, that.publishedCouponAmountNum) &&
            Objects.equals(publishedCouponSoldNum, that.publishedCouponSoldNum) &&
            Objects.equals(couponState, that.couponState) &&
            Objects.equals(couponPublishedHistoriesId, that.couponPublishedHistoriesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        publishedCouponName,
        publishedCouponType,
        publishedCouponAllUse,
        publishedCouponUseAffiliateId,
        publishedCouponAmountType,
        publishedCouponDuplication,
        publishedCouponAutoPublish,
        publishedCouponUseTypeLimit,
        publishedCouponUseType,
        publishedCouponUsePriceLimit,
        publishedCouponUsePrice,
        publishedCouponUseExpireLimit,
        publishedCouponUseExpireMonth,
        publishedCouponCreateDt,
        publishedCouponUpdateDt,
        publishedCouponCurrentPublishedDt,
        publishedCouponAmountNum,
        publishedCouponSoldNum,
        couponState,
        couponPublishedHistoriesId
        );
    }

    @Override
    public String toString() {
        return "PublishedCouponInfoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (publishedCouponName != null ? "publishedCouponName=" + publishedCouponName + ", " : "") +
                (publishedCouponType != null ? "publishedCouponType=" + publishedCouponType + ", " : "") +
                (publishedCouponAllUse != null ? "publishedCouponAllUse=" + publishedCouponAllUse + ", " : "") +
                (publishedCouponUseAffiliateId != null ? "publishedCouponUseAffiliateId=" + publishedCouponUseAffiliateId + ", " : "") +
                (publishedCouponAmountType != null ? "publishedCouponAmountType=" + publishedCouponAmountType + ", " : "") +
                (publishedCouponDuplication != null ? "publishedCouponDuplication=" + publishedCouponDuplication + ", " : "") +
                (publishedCouponAutoPublish != null ? "publishedCouponAutoPublish=" + publishedCouponAutoPublish + ", " : "") +
                (publishedCouponUseTypeLimit != null ? "publishedCouponUseTypeLimit=" + publishedCouponUseTypeLimit + ", " : "") +
                (publishedCouponUseType != null ? "publishedCouponUseType=" + publishedCouponUseType + ", " : "") +
                (publishedCouponUsePriceLimit != null ? "publishedCouponUsePriceLimit=" + publishedCouponUsePriceLimit + ", " : "") +
                (publishedCouponUsePrice != null ? "publishedCouponUsePrice=" + publishedCouponUsePrice + ", " : "") +
                (publishedCouponUseExpireLimit != null ? "publishedCouponUseExpireLimit=" + publishedCouponUseExpireLimit + ", " : "") +
                (publishedCouponUseExpireMonth != null ? "publishedCouponUseExpireMonth=" + publishedCouponUseExpireMonth + ", " : "") +
                (publishedCouponCreateDt != null ? "publishedCouponCreateDt=" + publishedCouponCreateDt + ", " : "") +
                (publishedCouponUpdateDt != null ? "publishedCouponUpdateDt=" + publishedCouponUpdateDt + ", " : "") +
                (publishedCouponCurrentPublishedDt != null ? "publishedCouponCurrentPublishedDt=" + publishedCouponCurrentPublishedDt + ", " : "") +
                (publishedCouponAmountNum != null ? "publishedCouponAmountNum=" + publishedCouponAmountNum + ", " : "") +
                (publishedCouponSoldNum != null ? "publishedCouponSoldNum=" + publishedCouponSoldNum + ", " : "") +
                (couponState != null ? "couponState=" + couponState + ", " : "") +
                (couponPublishedHistoriesId != null ? "couponPublishedHistoriesId=" + couponPublishedHistoriesId + ", " : "") +
            "}";
    }

}
