package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.CouponAmountType;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.PublishedCouponHistories} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.PublishedCouponHistoriesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /published-coupon-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PublishedCouponHistoriesCriteria implements Serializable, Criteria {
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

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter publishedUniqCode;

    private CouponAmountTypeFilter publishedCouponAmountType;

    private ZonedDateTimeFilter useDt;

    private BooleanFilter publishedCouponAllUse;

    private IntegerFilter publishedCouponUseAffiliateId;

    private ZonedDateTimeFilter publishedDt;

    private BooleanFilter useCheck;

    private LongFilter couponPublishedHistoriesId;

    public PublishedCouponHistoriesCriteria(){
    }

    public PublishedCouponHistoriesCriteria(PublishedCouponHistoriesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.publishedUniqCode = other.publishedUniqCode == null ? null : other.publishedUniqCode.copy();
        this.publishedCouponAmountType = other.publishedCouponAmountType == null ? null : other.publishedCouponAmountType.copy();
        this.useDt = other.useDt == null ? null : other.useDt.copy();
        this.publishedCouponAllUse = other.publishedCouponAllUse == null ? null : other.publishedCouponAllUse.copy();
        this.publishedCouponUseAffiliateId = other.publishedCouponUseAffiliateId == null ? null : other.publishedCouponUseAffiliateId.copy();
        this.publishedDt = other.publishedDt == null ? null : other.publishedDt.copy();
        this.useCheck = other.useCheck == null ? null : other.useCheck.copy();
        this.couponPublishedHistoriesId = other.couponPublishedHistoriesId == null ? null : other.couponPublishedHistoriesId.copy();
    }

    @Override
    public PublishedCouponHistoriesCriteria copy() {
        return new PublishedCouponHistoriesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPublishedUniqCode() {
        return publishedUniqCode;
    }

    public void setPublishedUniqCode(StringFilter publishedUniqCode) {
        this.publishedUniqCode = publishedUniqCode;
    }

    public CouponAmountTypeFilter getPublishedCouponAmountType() {
        return publishedCouponAmountType;
    }

    public void setPublishedCouponAmountType(CouponAmountTypeFilter publishedCouponAmountType) {
        this.publishedCouponAmountType = publishedCouponAmountType;
    }

    public ZonedDateTimeFilter getUseDt() {
        return useDt;
    }

    public void setUseDt(ZonedDateTimeFilter useDt) {
        this.useDt = useDt;
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
        final PublishedCouponHistoriesCriteria that = (PublishedCouponHistoriesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(publishedUniqCode, that.publishedUniqCode) &&
            Objects.equals(publishedCouponAmountType, that.publishedCouponAmountType) &&
            Objects.equals(useDt, that.useDt) &&
            Objects.equals(publishedCouponAllUse, that.publishedCouponAllUse) &&
            Objects.equals(publishedCouponUseAffiliateId, that.publishedCouponUseAffiliateId) &&
            Objects.equals(publishedDt, that.publishedDt) &&
            Objects.equals(useCheck, that.useCheck) &&
            Objects.equals(couponPublishedHistoriesId, that.couponPublishedHistoriesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        publishedUniqCode,
        publishedCouponAmountType,
        useDt,
        publishedCouponAllUse,
        publishedCouponUseAffiliateId,
        publishedDt,
        useCheck,
        couponPublishedHistoriesId
        );
    }

    @Override
    public String toString() {
        return "PublishedCouponHistoriesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (publishedUniqCode != null ? "publishedUniqCode=" + publishedUniqCode + ", " : "") +
                (publishedCouponAmountType != null ? "publishedCouponAmountType=" + publishedCouponAmountType + ", " : "") +
                (useDt != null ? "useDt=" + useDt + ", " : "") +
                (publishedCouponAllUse != null ? "publishedCouponAllUse=" + publishedCouponAllUse + ", " : "") +
                (publishedCouponUseAffiliateId != null ? "publishedCouponUseAffiliateId=" + publishedCouponUseAffiliateId + ", " : "") +
                (publishedDt != null ? "publishedDt=" + publishedDt + ", " : "") +
                (useCheck != null ? "useCheck=" + useCheck + ", " : "") +
                (couponPublishedHistoriesId != null ? "couponPublishedHistoriesId=" + couponPublishedHistoriesId + ", " : "") +
            "}";
    }

}
