package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.SellState;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.RoomSellDetails} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.RoomSellDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /room-sell-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RoomSellDetailsCriteria implements Serializable, Criteria {
    /**
     * Class for filtering SellState
     */
    public static class SellStateFilter extends Filter<SellState> {

        public SellStateFilter() {
        }

        public SellStateFilter(SellStateFilter filter) {
            super(filter);
        }

        @Override
        public SellStateFilter copy() {
            return new SellStateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ZonedDateTimeFilter sellDt;

    private IntegerFilter sellAmount;

    private IntegerFilter sellSoldNum;

    private IntegerFilter sellStartTime;

    private IntegerFilter sellEndTime;

    private IntegerFilter sellUseTime;

    private IntegerFilter couponBoolean;

    private SellStateFilter sellState;

    public RoomSellDetailsCriteria(){
    }

    public RoomSellDetailsCriteria(RoomSellDetailsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.sellDt = other.sellDt == null ? null : other.sellDt.copy();
        this.sellAmount = other.sellAmount == null ? null : other.sellAmount.copy();
        this.sellSoldNum = other.sellSoldNum == null ? null : other.sellSoldNum.copy();
        this.sellStartTime = other.sellStartTime == null ? null : other.sellStartTime.copy();
        this.sellEndTime = other.sellEndTime == null ? null : other.sellEndTime.copy();
        this.sellUseTime = other.sellUseTime == null ? null : other.sellUseTime.copy();
        this.couponBoolean = other.couponBoolean == null ? null : other.couponBoolean.copy();
        this.sellState = other.sellState == null ? null : other.sellState.copy();
    }

    @Override
    public RoomSellDetailsCriteria copy() {
        return new RoomSellDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ZonedDateTimeFilter getSellDt() {
        return sellDt;
    }

    public void setSellDt(ZonedDateTimeFilter sellDt) {
        this.sellDt = sellDt;
    }

    public IntegerFilter getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(IntegerFilter sellAmount) {
        this.sellAmount = sellAmount;
    }

    public IntegerFilter getSellSoldNum() {
        return sellSoldNum;
    }

    public void setSellSoldNum(IntegerFilter sellSoldNum) {
        this.sellSoldNum = sellSoldNum;
    }

    public IntegerFilter getSellStartTime() {
        return sellStartTime;
    }

    public void setSellStartTime(IntegerFilter sellStartTime) {
        this.sellStartTime = sellStartTime;
    }

    public IntegerFilter getSellEndTime() {
        return sellEndTime;
    }

    public void setSellEndTime(IntegerFilter sellEndTime) {
        this.sellEndTime = sellEndTime;
    }

    public IntegerFilter getSellUseTime() {
        return sellUseTime;
    }

    public void setSellUseTime(IntegerFilter sellUseTime) {
        this.sellUseTime = sellUseTime;
    }

    public IntegerFilter getCouponBoolean() {
        return couponBoolean;
    }

    public void setCouponBoolean(IntegerFilter couponBoolean) {
        this.couponBoolean = couponBoolean;
    }

    public SellStateFilter getSellState() {
        return sellState;
    }

    public void setSellState(SellStateFilter sellState) {
        this.sellState = sellState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RoomSellDetailsCriteria that = (RoomSellDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(sellDt, that.sellDt) &&
            Objects.equals(sellAmount, that.sellAmount) &&
            Objects.equals(sellSoldNum, that.sellSoldNum) &&
            Objects.equals(sellStartTime, that.sellStartTime) &&
            Objects.equals(sellEndTime, that.sellEndTime) &&
            Objects.equals(sellUseTime, that.sellUseTime) &&
            Objects.equals(couponBoolean, that.couponBoolean) &&
            Objects.equals(sellState, that.sellState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        sellDt,
        sellAmount,
        sellSoldNum,
        sellStartTime,
        sellEndTime,
        sellUseTime,
        couponBoolean,
        sellState
        );
    }

    @Override
    public String toString() {
        return "RoomSellDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (sellDt != null ? "sellDt=" + sellDt + ", " : "") +
                (sellAmount != null ? "sellAmount=" + sellAmount + ", " : "") +
                (sellSoldNum != null ? "sellSoldNum=" + sellSoldNum + ", " : "") +
                (sellStartTime != null ? "sellStartTime=" + sellStartTime + ", " : "") +
                (sellEndTime != null ? "sellEndTime=" + sellEndTime + ", " : "") +
                (sellUseTime != null ? "sellUseTime=" + sellUseTime + ", " : "") +
                (couponBoolean != null ? "couponBoolean=" + couponBoolean + ", " : "") +
                (sellState != null ? "sellState=" + sellState + ", " : "") +
            "}";
    }

}
