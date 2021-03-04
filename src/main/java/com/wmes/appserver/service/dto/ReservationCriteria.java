package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.StateOrder;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Reservation} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ReservationResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /reservations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ReservationCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateOrder
     */
    public static class StateOrderFilter extends Filter<StateOrder> {

        public StateOrderFilter() {
        }

        public StateOrderFilter(StateOrderFilter filter) {
            super(filter);
        }

        @Override
        public StateOrderFilter copy() {
            return new StateOrderFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter orderUniqNum;

    private StringFilter orderUserName;

    private StringFilter orderUserNum;

    private StringFilter transportation;

    private StringFilter accommodationName;

    private StringFilter roomName;

    private IntegerFilter reservationPrice;

    private IntegerFilter roomDiscountPer;

    private BooleanFilter couponApply;

    private StringFilter couponName;

    private IntegerFilter couponDiscountPrice;

    private StringFilter couponType;

    private IntegerFilter paymentPrice;

    private StringFilter paymentType;

    private IntegerFilter affiliateCommission;

    private IntegerFilter managerCommission;

    private IntegerFilter investmentCommission;

    private ZonedDateTimeFilter useStartTime;

    private ZonedDateTimeFilter useEndTime;

    private ZonedDateTimeFilter orderCreateDt;

    private ZonedDateTimeFilter checkInDt;

    private ZonedDateTimeFilter checkOutDt;

    private StateOrderFilter orderState;

    private LongFilter hoMemberId;

    private LongFilter managerId;

    private LongFilter affiliateId;

    private LongFilter accommodationId;

    public ReservationCriteria(){
    }

    public ReservationCriteria(ReservationCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.orderUniqNum = other.orderUniqNum == null ? null : other.orderUniqNum.copy();
        this.orderUserName = other.orderUserName == null ? null : other.orderUserName.copy();
        this.orderUserNum = other.orderUserNum == null ? null : other.orderUserNum.copy();
        this.transportation = other.transportation == null ? null : other.transportation.copy();
        this.accommodationName = other.accommodationName == null ? null : other.accommodationName.copy();
        this.roomName = other.roomName == null ? null : other.roomName.copy();
        this.reservationPrice = other.reservationPrice == null ? null : other.reservationPrice.copy();
        this.roomDiscountPer = other.roomDiscountPer == null ? null : other.roomDiscountPer.copy();
        this.couponApply = other.couponApply == null ? null : other.couponApply.copy();
        this.couponName = other.couponName == null ? null : other.couponName.copy();
        this.couponDiscountPrice = other.couponDiscountPrice == null ? null : other.couponDiscountPrice.copy();
        this.couponType = other.couponType == null ? null : other.couponType.copy();
        this.paymentPrice = other.paymentPrice == null ? null : other.paymentPrice.copy();
        this.paymentType = other.paymentType == null ? null : other.paymentType.copy();
        this.affiliateCommission = other.affiliateCommission == null ? null : other.affiliateCommission.copy();
        this.managerCommission = other.managerCommission == null ? null : other.managerCommission.copy();
        this.investmentCommission = other.investmentCommission == null ? null : other.investmentCommission.copy();
        this.useStartTime = other.useStartTime == null ? null : other.useStartTime.copy();
        this.useEndTime = other.useEndTime == null ? null : other.useEndTime.copy();
        this.orderCreateDt = other.orderCreateDt == null ? null : other.orderCreateDt.copy();
        this.checkInDt = other.checkInDt == null ? null : other.checkInDt.copy();
        this.checkOutDt = other.checkOutDt == null ? null : other.checkOutDt.copy();
        this.orderState = other.orderState == null ? null : other.orderState.copy();
        this.hoMemberId = other.hoMemberId == null ? null : other.hoMemberId.copy();
        this.managerId = other.managerId == null ? null : other.managerId.copy();
        this.affiliateId = other.affiliateId == null ? null : other.affiliateId.copy();
        this.accommodationId = other.accommodationId == null ? null : other.accommodationId.copy();
    }

    @Override
    public ReservationCriteria copy() {
        return new ReservationCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getOrderUniqNum() {
        return orderUniqNum;
    }

    public void setOrderUniqNum(StringFilter orderUniqNum) {
        this.orderUniqNum = orderUniqNum;
    }

    public StringFilter getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(StringFilter orderUserName) {
        this.orderUserName = orderUserName;
    }

    public StringFilter getOrderUserNum() {
        return orderUserNum;
    }

    public void setOrderUserNum(StringFilter orderUserNum) {
        this.orderUserNum = orderUserNum;
    }

    public StringFilter getTransportation() {
        return transportation;
    }

    public void setTransportation(StringFilter transportation) {
        this.transportation = transportation;
    }

    public StringFilter getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(StringFilter accommodationName) {
        this.accommodationName = accommodationName;
    }

    public StringFilter getRoomName() {
        return roomName;
    }

    public void setRoomName(StringFilter roomName) {
        this.roomName = roomName;
    }

    public IntegerFilter getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(IntegerFilter reservationPrice) {
        this.reservationPrice = reservationPrice;
    }

    public IntegerFilter getRoomDiscountPer() {
        return roomDiscountPer;
    }

    public void setRoomDiscountPer(IntegerFilter roomDiscountPer) {
        this.roomDiscountPer = roomDiscountPer;
    }

    public BooleanFilter getCouponApply() {
        return couponApply;
    }

    public void setCouponApply(BooleanFilter couponApply) {
        this.couponApply = couponApply;
    }

    public StringFilter getCouponName() {
        return couponName;
    }

    public void setCouponName(StringFilter couponName) {
        this.couponName = couponName;
    }

    public IntegerFilter getCouponDiscountPrice() {
        return couponDiscountPrice;
    }

    public void setCouponDiscountPrice(IntegerFilter couponDiscountPrice) {
        this.couponDiscountPrice = couponDiscountPrice;
    }

    public StringFilter getCouponType() {
        return couponType;
    }

    public void setCouponType(StringFilter couponType) {
        this.couponType = couponType;
    }

    public IntegerFilter getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(IntegerFilter paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public StringFilter getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(StringFilter paymentType) {
        this.paymentType = paymentType;
    }

    public IntegerFilter getAffiliateCommission() {
        return affiliateCommission;
    }

    public void setAffiliateCommission(IntegerFilter affiliateCommission) {
        this.affiliateCommission = affiliateCommission;
    }

    public IntegerFilter getManagerCommission() {
        return managerCommission;
    }

    public void setManagerCommission(IntegerFilter managerCommission) {
        this.managerCommission = managerCommission;
    }

    public IntegerFilter getInvestmentCommission() {
        return investmentCommission;
    }

    public void setInvestmentCommission(IntegerFilter investmentCommission) {
        this.investmentCommission = investmentCommission;
    }

    public ZonedDateTimeFilter getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(ZonedDateTimeFilter useStartTime) {
        this.useStartTime = useStartTime;
    }

    public ZonedDateTimeFilter getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(ZonedDateTimeFilter useEndTime) {
        this.useEndTime = useEndTime;
    }

    public ZonedDateTimeFilter getOrderCreateDt() {
        return orderCreateDt;
    }

    public void setOrderCreateDt(ZonedDateTimeFilter orderCreateDt) {
        this.orderCreateDt = orderCreateDt;
    }

    public ZonedDateTimeFilter getCheckInDt() {
        return checkInDt;
    }

    public void setCheckInDt(ZonedDateTimeFilter checkInDt) {
        this.checkInDt = checkInDt;
    }

    public ZonedDateTimeFilter getCheckOutDt() {
        return checkOutDt;
    }

    public void setCheckOutDt(ZonedDateTimeFilter checkOutDt) {
        this.checkOutDt = checkOutDt;
    }

    public StateOrderFilter getOrderState() {
        return orderState;
    }

    public void setOrderState(StateOrderFilter orderState) {
        this.orderState = orderState;
    }

    public LongFilter getHoMemberId() {
        return hoMemberId;
    }

    public void setHoMemberId(LongFilter hoMemberId) {
        this.hoMemberId = hoMemberId;
    }

    public LongFilter getManagerId() {
        return managerId;
    }

    public void setManagerId(LongFilter managerId) {
        this.managerId = managerId;
    }

    public LongFilter getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(LongFilter affiliateId) {
        this.affiliateId = affiliateId;
    }

    public LongFilter getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(LongFilter accommodationId) {
        this.accommodationId = accommodationId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ReservationCriteria that = (ReservationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(orderUniqNum, that.orderUniqNum) &&
            Objects.equals(orderUserName, that.orderUserName) &&
            Objects.equals(orderUserNum, that.orderUserNum) &&
            Objects.equals(transportation, that.transportation) &&
            Objects.equals(accommodationName, that.accommodationName) &&
            Objects.equals(roomName, that.roomName) &&
            Objects.equals(reservationPrice, that.reservationPrice) &&
            Objects.equals(roomDiscountPer, that.roomDiscountPer) &&
            Objects.equals(couponApply, that.couponApply) &&
            Objects.equals(couponName, that.couponName) &&
            Objects.equals(couponDiscountPrice, that.couponDiscountPrice) &&
            Objects.equals(couponType, that.couponType) &&
            Objects.equals(paymentPrice, that.paymentPrice) &&
            Objects.equals(paymentType, that.paymentType) &&
            Objects.equals(affiliateCommission, that.affiliateCommission) &&
            Objects.equals(managerCommission, that.managerCommission) &&
            Objects.equals(investmentCommission, that.investmentCommission) &&
            Objects.equals(useStartTime, that.useStartTime) &&
            Objects.equals(useEndTime, that.useEndTime) &&
            Objects.equals(orderCreateDt, that.orderCreateDt) &&
            Objects.equals(checkInDt, that.checkInDt) &&
            Objects.equals(checkOutDt, that.checkOutDt) &&
            Objects.equals(orderState, that.orderState) &&
            Objects.equals(hoMemberId, that.hoMemberId) &&
            Objects.equals(managerId, that.managerId) &&
            Objects.equals(affiliateId, that.affiliateId) &&
            Objects.equals(accommodationId, that.accommodationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        orderUniqNum,
        orderUserName,
        orderUserNum,
        transportation,
        accommodationName,
        roomName,
        reservationPrice,
        roomDiscountPer,
        couponApply,
        couponName,
        couponDiscountPrice,
        couponType,
        paymentPrice,
        paymentType,
        affiliateCommission,
        managerCommission,
        investmentCommission,
        useStartTime,
        useEndTime,
        orderCreateDt,
        checkInDt,
        checkOutDt,
        orderState,
        hoMemberId,
        managerId,
        affiliateId,
        accommodationId
        );
    }

    @Override
    public String toString() {
        return "ReservationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (orderUniqNum != null ? "orderUniqNum=" + orderUniqNum + ", " : "") +
                (orderUserName != null ? "orderUserName=" + orderUserName + ", " : "") +
                (orderUserNum != null ? "orderUserNum=" + orderUserNum + ", " : "") +
                (transportation != null ? "transportation=" + transportation + ", " : "") +
                (accommodationName != null ? "accommodationName=" + accommodationName + ", " : "") +
                (roomName != null ? "roomName=" + roomName + ", " : "") +
                (reservationPrice != null ? "reservationPrice=" + reservationPrice + ", " : "") +
                (roomDiscountPer != null ? "roomDiscountPer=" + roomDiscountPer + ", " : "") +
                (couponApply != null ? "couponApply=" + couponApply + ", " : "") +
                (couponName != null ? "couponName=" + couponName + ", " : "") +
                (couponDiscountPrice != null ? "couponDiscountPrice=" + couponDiscountPrice + ", " : "") +
                (couponType != null ? "couponType=" + couponType + ", " : "") +
                (paymentPrice != null ? "paymentPrice=" + paymentPrice + ", " : "") +
                (paymentType != null ? "paymentType=" + paymentType + ", " : "") +
                (affiliateCommission != null ? "affiliateCommission=" + affiliateCommission + ", " : "") +
                (managerCommission != null ? "managerCommission=" + managerCommission + ", " : "") +
                (investmentCommission != null ? "investmentCommission=" + investmentCommission + ", " : "") +
                (useStartTime != null ? "useStartTime=" + useStartTime + ", " : "") +
                (useEndTime != null ? "useEndTime=" + useEndTime + ", " : "") +
                (orderCreateDt != null ? "orderCreateDt=" + orderCreateDt + ", " : "") +
                (checkInDt != null ? "checkInDt=" + checkInDt + ", " : "") +
                (checkOutDt != null ? "checkOutDt=" + checkOutDt + ", " : "") +
                (orderState != null ? "orderState=" + orderState + ", " : "") +
                (hoMemberId != null ? "hoMemberId=" + hoMemberId + ", " : "") +
                (managerId != null ? "managerId=" + managerId + ", " : "") +
                (affiliateId != null ? "affiliateId=" + affiliateId + ", " : "") +
                (accommodationId != null ? "accommodationId=" + accommodationId + ", " : "") +
            "}";
    }

}
