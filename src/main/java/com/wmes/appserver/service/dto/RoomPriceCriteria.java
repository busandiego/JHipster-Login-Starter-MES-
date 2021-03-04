package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.RoomType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.RoomPrice} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.RoomPriceResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /room-prices?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RoomPriceCriteria implements Serializable, Criteria {
    /**
     * Class for filtering RoomType
     */
    public static class RoomTypeFilter extends Filter<RoomType> {

        public RoomTypeFilter() {
        }

        public RoomTypeFilter(RoomTypeFilter filter) {
            super(filter);
        }

        @Override
        public RoomTypeFilter copy() {
            return new RoomTypeFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ZonedDateTimeFilter applyStartDt;

    private ZonedDateTimeFilter applyEndDt;

    private ZonedDateTimeFilter applyDt;

    private IntegerFilter roomNum;

    private IntegerFilter price;

    private IntegerFilter relayPrice;

    private IntegerFilter discountPer;

    private BooleanFilter relayAvailable;

    private RoomTypeFilter roomType;

    private LongFilter roomsId;

    public RoomPriceCriteria(){
    }

    public RoomPriceCriteria(RoomPriceCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.applyStartDt = other.applyStartDt == null ? null : other.applyStartDt.copy();
        this.applyEndDt = other.applyEndDt == null ? null : other.applyEndDt.copy();
        this.applyDt = other.applyDt == null ? null : other.applyDt.copy();
        this.roomNum = other.roomNum == null ? null : other.roomNum.copy();
        this.price = other.price == null ? null : other.price.copy();
        this.relayPrice = other.relayPrice == null ? null : other.relayPrice.copy();
        this.discountPer = other.discountPer == null ? null : other.discountPer.copy();
        this.relayAvailable = other.relayAvailable == null ? null : other.relayAvailable.copy();
        this.roomType = other.roomType == null ? null : other.roomType.copy();
        this.roomsId = other.roomsId == null ? null : other.roomsId.copy();
    }

    @Override
    public RoomPriceCriteria copy() {
        return new RoomPriceCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ZonedDateTimeFilter getApplyStartDt() {
        return applyStartDt;
    }

    public void setApplyStartDt(ZonedDateTimeFilter applyStartDt) {
        this.applyStartDt = applyStartDt;
    }

    public ZonedDateTimeFilter getApplyEndDt() {
        return applyEndDt;
    }

    public void setApplyEndDt(ZonedDateTimeFilter applyEndDt) {
        this.applyEndDt = applyEndDt;
    }

    public ZonedDateTimeFilter getApplyDt() {
        return applyDt;
    }

    public void setApplyDt(ZonedDateTimeFilter applyDt) {
        this.applyDt = applyDt;
    }

    public IntegerFilter getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(IntegerFilter roomNum) {
        this.roomNum = roomNum;
    }

    public IntegerFilter getPrice() {
        return price;
    }

    public void setPrice(IntegerFilter price) {
        this.price = price;
    }

    public IntegerFilter getRelayPrice() {
        return relayPrice;
    }

    public void setRelayPrice(IntegerFilter relayPrice) {
        this.relayPrice = relayPrice;
    }

    public IntegerFilter getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(IntegerFilter discountPer) {
        this.discountPer = discountPer;
    }

    public BooleanFilter getRelayAvailable() {
        return relayAvailable;
    }

    public void setRelayAvailable(BooleanFilter relayAvailable) {
        this.relayAvailable = relayAvailable;
    }

    public RoomTypeFilter getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeFilter roomType) {
        this.roomType = roomType;
    }

    public LongFilter getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(LongFilter roomsId) {
        this.roomsId = roomsId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RoomPriceCriteria that = (RoomPriceCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(applyStartDt, that.applyStartDt) &&
            Objects.equals(applyEndDt, that.applyEndDt) &&
            Objects.equals(applyDt, that.applyDt) &&
            Objects.equals(roomNum, that.roomNum) &&
            Objects.equals(price, that.price) &&
            Objects.equals(relayPrice, that.relayPrice) &&
            Objects.equals(discountPer, that.discountPer) &&
            Objects.equals(relayAvailable, that.relayAvailable) &&
            Objects.equals(roomType, that.roomType) &&
            Objects.equals(roomsId, that.roomsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        applyStartDt,
        applyEndDt,
        applyDt,
        roomNum,
        price,
        relayPrice,
        discountPer,
        relayAvailable,
        roomType,
        roomsId
        );
    }

    @Override
    public String toString() {
        return "RoomPriceCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (applyStartDt != null ? "applyStartDt=" + applyStartDt + ", " : "") +
                (applyEndDt != null ? "applyEndDt=" + applyEndDt + ", " : "") +
                (applyDt != null ? "applyDt=" + applyDt + ", " : "") +
                (roomNum != null ? "roomNum=" + roomNum + ", " : "") +
                (price != null ? "price=" + price + ", " : "") +
                (relayPrice != null ? "relayPrice=" + relayPrice + ", " : "") +
                (discountPer != null ? "discountPer=" + discountPer + ", " : "") +
                (relayAvailable != null ? "relayAvailable=" + relayAvailable + ", " : "") +
                (roomType != null ? "roomType=" + roomType + ", " : "") +
                (roomsId != null ? "roomsId=" + roomsId + ", " : "") +
            "}";
    }

}
