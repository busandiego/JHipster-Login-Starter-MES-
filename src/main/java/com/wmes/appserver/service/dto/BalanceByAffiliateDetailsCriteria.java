package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.CouponType;
import com.wmes.appserver.domain.enumeration.StateBalance;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.BalanceByAffiliateDetails} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.BalanceByAffiliateDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /balance-by-affiliate-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BalanceByAffiliateDetailsCriteria implements Serializable, Criteria {
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
     * Class for filtering StateBalance
     */
    public static class StateBalanceFilter extends Filter<StateBalance> {

        public StateBalanceFilter() {
        }

        public StateBalanceFilter(StateBalanceFilter filter) {
            super(filter);
        }

        @Override
        public StateBalanceFilter copy() {
            return new StateBalanceFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter reserveUserName;

    private StringFilter reserveUserNum;

    private StringFilter roomName;

    private ZonedDateTimeFilter reservationDt;

    private IntegerFilter sellingPrice;

    private IntegerFilter couponDiscount;

    private CouponTypeFilter couponType;

    private IntegerFilter commission;

    private IntegerFilter paymentMoney;

    private StateBalanceFilter balanceState;

    private LongFilter totalBalanceByAffiliateId;

    public BalanceByAffiliateDetailsCriteria(){
    }

    public BalanceByAffiliateDetailsCriteria(BalanceByAffiliateDetailsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.reserveUserName = other.reserveUserName == null ? null : other.reserveUserName.copy();
        this.reserveUserNum = other.reserveUserNum == null ? null : other.reserveUserNum.copy();
        this.roomName = other.roomName == null ? null : other.roomName.copy();
        this.reservationDt = other.reservationDt == null ? null : other.reservationDt.copy();
        this.sellingPrice = other.sellingPrice == null ? null : other.sellingPrice.copy();
        this.couponDiscount = other.couponDiscount == null ? null : other.couponDiscount.copy();
        this.couponType = other.couponType == null ? null : other.couponType.copy();
        this.commission = other.commission == null ? null : other.commission.copy();
        this.paymentMoney = other.paymentMoney == null ? null : other.paymentMoney.copy();
        this.balanceState = other.balanceState == null ? null : other.balanceState.copy();
        this.totalBalanceByAffiliateId = other.totalBalanceByAffiliateId == null ? null : other.totalBalanceByAffiliateId.copy();
    }

    @Override
    public BalanceByAffiliateDetailsCriteria copy() {
        return new BalanceByAffiliateDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getReserveUserName() {
        return reserveUserName;
    }

    public void setReserveUserName(StringFilter reserveUserName) {
        this.reserveUserName = reserveUserName;
    }

    public StringFilter getReserveUserNum() {
        return reserveUserNum;
    }

    public void setReserveUserNum(StringFilter reserveUserNum) {
        this.reserveUserNum = reserveUserNum;
    }

    public StringFilter getRoomName() {
        return roomName;
    }

    public void setRoomName(StringFilter roomName) {
        this.roomName = roomName;
    }

    public ZonedDateTimeFilter getReservationDt() {
        return reservationDt;
    }

    public void setReservationDt(ZonedDateTimeFilter reservationDt) {
        this.reservationDt = reservationDt;
    }

    public IntegerFilter getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(IntegerFilter sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public IntegerFilter getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(IntegerFilter couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public CouponTypeFilter getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponTypeFilter couponType) {
        this.couponType = couponType;
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

    public StateBalanceFilter getBalanceState() {
        return balanceState;
    }

    public void setBalanceState(StateBalanceFilter balanceState) {
        this.balanceState = balanceState;
    }

    public LongFilter getTotalBalanceByAffiliateId() {
        return totalBalanceByAffiliateId;
    }

    public void setTotalBalanceByAffiliateId(LongFilter totalBalanceByAffiliateId) {
        this.totalBalanceByAffiliateId = totalBalanceByAffiliateId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BalanceByAffiliateDetailsCriteria that = (BalanceByAffiliateDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(reserveUserName, that.reserveUserName) &&
            Objects.equals(reserveUserNum, that.reserveUserNum) &&
            Objects.equals(roomName, that.roomName) &&
            Objects.equals(reservationDt, that.reservationDt) &&
            Objects.equals(sellingPrice, that.sellingPrice) &&
            Objects.equals(couponDiscount, that.couponDiscount) &&
            Objects.equals(couponType, that.couponType) &&
            Objects.equals(commission, that.commission) &&
            Objects.equals(paymentMoney, that.paymentMoney) &&
            Objects.equals(balanceState, that.balanceState) &&
            Objects.equals(totalBalanceByAffiliateId, that.totalBalanceByAffiliateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        reserveUserName,
        reserveUserNum,
        roomName,
        reservationDt,
        sellingPrice,
        couponDiscount,
        couponType,
        commission,
        paymentMoney,
        balanceState,
        totalBalanceByAffiliateId
        );
    }

    @Override
    public String toString() {
        return "BalanceByAffiliateDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (reserveUserName != null ? "reserveUserName=" + reserveUserName + ", " : "") +
                (reserveUserNum != null ? "reserveUserNum=" + reserveUserNum + ", " : "") +
                (roomName != null ? "roomName=" + roomName + ", " : "") +
                (reservationDt != null ? "reservationDt=" + reservationDt + ", " : "") +
                (sellingPrice != null ? "sellingPrice=" + sellingPrice + ", " : "") +
                (couponDiscount != null ? "couponDiscount=" + couponDiscount + ", " : "") +
                (couponType != null ? "couponType=" + couponType + ", " : "") +
                (commission != null ? "commission=" + commission + ", " : "") +
                (paymentMoney != null ? "paymentMoney=" + paymentMoney + ", " : "") +
                (balanceState != null ? "balanceState=" + balanceState + ", " : "") +
                (totalBalanceByAffiliateId != null ? "totalBalanceByAffiliateId=" + totalBalanceByAffiliateId + ", " : "") +
            "}";
    }

}
