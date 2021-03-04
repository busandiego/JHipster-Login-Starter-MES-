package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.CouponPublishedHistoriesState;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.CouponPublishedHistories} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.CouponPublishedHistoriesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /coupon-published-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CouponPublishedHistoriesCriteria implements Serializable, Criteria {
    /**
     * Class for filtering CouponPublishedHistoriesState
     */
    public static class CouponPublishedHistoriesStateFilter extends Filter<CouponPublishedHistoriesState> {

        public CouponPublishedHistoriesStateFilter() {
        }

        public CouponPublishedHistoriesStateFilter(CouponPublishedHistoriesStateFilter filter) {
            super(filter);
        }

        @Override
        public CouponPublishedHistoriesStateFilter copy() {
            return new CouponPublishedHistoriesStateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter publishedName;

    private IntegerFilter totalPublishedNum;

    private IntegerFilter oneThousandNum;

    private IntegerFilter threeThousandNum;

    private IntegerFilter fiveThousandNum;

    private IntegerFilter sevenThousandNum;

    private IntegerFilter tenThousandNum;

    private IntegerFilter autoPublishedNum;

    private IntegerFilter totalPublishedPrice;

    private ZonedDateTimeFilter publishedDt;

    private ZonedDateTimeFilter expireDt;

    private CouponPublishedHistoriesStateFilter CouponPublishedHistoriesState;

    public CouponPublishedHistoriesCriteria(){
    }

    public CouponPublishedHistoriesCriteria(CouponPublishedHistoriesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.publishedName = other.publishedName == null ? null : other.publishedName.copy();
        this.totalPublishedNum = other.totalPublishedNum == null ? null : other.totalPublishedNum.copy();
        this.oneThousandNum = other.oneThousandNum == null ? null : other.oneThousandNum.copy();
        this.threeThousandNum = other.threeThousandNum == null ? null : other.threeThousandNum.copy();
        this.fiveThousandNum = other.fiveThousandNum == null ? null : other.fiveThousandNum.copy();
        this.sevenThousandNum = other.sevenThousandNum == null ? null : other.sevenThousandNum.copy();
        this.tenThousandNum = other.tenThousandNum == null ? null : other.tenThousandNum.copy();
        this.autoPublishedNum = other.autoPublishedNum == null ? null : other.autoPublishedNum.copy();
        this.totalPublishedPrice = other.totalPublishedPrice == null ? null : other.totalPublishedPrice.copy();
        this.publishedDt = other.publishedDt == null ? null : other.publishedDt.copy();
        this.expireDt = other.expireDt == null ? null : other.expireDt.copy();
        this.CouponPublishedHistoriesState = other.CouponPublishedHistoriesState == null ? null : other.CouponPublishedHistoriesState.copy();
    }

    @Override
    public CouponPublishedHistoriesCriteria copy() {
        return new CouponPublishedHistoriesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPublishedName() {
        return publishedName;
    }

    public void setPublishedName(StringFilter publishedName) {
        this.publishedName = publishedName;
    }

    public IntegerFilter getTotalPublishedNum() {
        return totalPublishedNum;
    }

    public void setTotalPublishedNum(IntegerFilter totalPublishedNum) {
        this.totalPublishedNum = totalPublishedNum;
    }

    public IntegerFilter getOneThousandNum() {
        return oneThousandNum;
    }

    public void setOneThousandNum(IntegerFilter oneThousandNum) {
        this.oneThousandNum = oneThousandNum;
    }

    public IntegerFilter getThreeThousandNum() {
        return threeThousandNum;
    }

    public void setThreeThousandNum(IntegerFilter threeThousandNum) {
        this.threeThousandNum = threeThousandNum;
    }

    public IntegerFilter getFiveThousandNum() {
        return fiveThousandNum;
    }

    public void setFiveThousandNum(IntegerFilter fiveThousandNum) {
        this.fiveThousandNum = fiveThousandNum;
    }

    public IntegerFilter getSevenThousandNum() {
        return sevenThousandNum;
    }

    public void setSevenThousandNum(IntegerFilter sevenThousandNum) {
        this.sevenThousandNum = sevenThousandNum;
    }

    public IntegerFilter getTenThousandNum() {
        return tenThousandNum;
    }

    public void setTenThousandNum(IntegerFilter tenThousandNum) {
        this.tenThousandNum = tenThousandNum;
    }

    public IntegerFilter getAutoPublishedNum() {
        return autoPublishedNum;
    }

    public void setAutoPublishedNum(IntegerFilter autoPublishedNum) {
        this.autoPublishedNum = autoPublishedNum;
    }

    public IntegerFilter getTotalPublishedPrice() {
        return totalPublishedPrice;
    }

    public void setTotalPublishedPrice(IntegerFilter totalPublishedPrice) {
        this.totalPublishedPrice = totalPublishedPrice;
    }

    public ZonedDateTimeFilter getPublishedDt() {
        return publishedDt;
    }

    public void setPublishedDt(ZonedDateTimeFilter publishedDt) {
        this.publishedDt = publishedDt;
    }

    public ZonedDateTimeFilter getExpireDt() {
        return expireDt;
    }

    public void setExpireDt(ZonedDateTimeFilter expireDt) {
        this.expireDt = expireDt;
    }

    public CouponPublishedHistoriesStateFilter getCouponPublishedHistoriesState() {
        return CouponPublishedHistoriesState;
    }

    public void setCouponPublishedHistoriesState(CouponPublishedHistoriesStateFilter CouponPublishedHistoriesState) {
        this.CouponPublishedHistoriesState = CouponPublishedHistoriesState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CouponPublishedHistoriesCriteria that = (CouponPublishedHistoriesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(publishedName, that.publishedName) &&
            Objects.equals(totalPublishedNum, that.totalPublishedNum) &&
            Objects.equals(oneThousandNum, that.oneThousandNum) &&
            Objects.equals(threeThousandNum, that.threeThousandNum) &&
            Objects.equals(fiveThousandNum, that.fiveThousandNum) &&
            Objects.equals(sevenThousandNum, that.sevenThousandNum) &&
            Objects.equals(tenThousandNum, that.tenThousandNum) &&
            Objects.equals(autoPublishedNum, that.autoPublishedNum) &&
            Objects.equals(totalPublishedPrice, that.totalPublishedPrice) &&
            Objects.equals(publishedDt, that.publishedDt) &&
            Objects.equals(expireDt, that.expireDt) &&
            Objects.equals(CouponPublishedHistoriesState, that.CouponPublishedHistoriesState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        publishedName,
        totalPublishedNum,
        oneThousandNum,
        threeThousandNum,
        fiveThousandNum,
        sevenThousandNum,
        tenThousandNum,
        autoPublishedNum,
        totalPublishedPrice,
        publishedDt,
        expireDt,
        CouponPublishedHistoriesState
        );
    }

    @Override
    public String toString() {
        return "CouponPublishedHistoriesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (publishedName != null ? "publishedName=" + publishedName + ", " : "") +
                (totalPublishedNum != null ? "totalPublishedNum=" + totalPublishedNum + ", " : "") +
                (oneThousandNum != null ? "oneThousandNum=" + oneThousandNum + ", " : "") +
                (threeThousandNum != null ? "threeThousandNum=" + threeThousandNum + ", " : "") +
                (fiveThousandNum != null ? "fiveThousandNum=" + fiveThousandNum + ", " : "") +
                (sevenThousandNum != null ? "sevenThousandNum=" + sevenThousandNum + ", " : "") +
                (tenThousandNum != null ? "tenThousandNum=" + tenThousandNum + ", " : "") +
                (autoPublishedNum != null ? "autoPublishedNum=" + autoPublishedNum + ", " : "") +
                (totalPublishedPrice != null ? "totalPublishedPrice=" + totalPublishedPrice + ", " : "") +
                (publishedDt != null ? "publishedDt=" + publishedDt + ", " : "") +
                (expireDt != null ? "expireDt=" + expireDt + ", " : "") +
                (CouponPublishedHistoriesState != null ? "CouponPublishedHistoriesState=" + CouponPublishedHistoriesState + ", " : "") +
            "}";
    }

}
