package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateRoom;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Rooms} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.RoomsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /rooms?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RoomsCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateRoom
     */
    public static class StateRoomFilter extends Filter<StateRoom> {

        public StateRoomFilter() {
        }

        public StateRoomFilter(StateRoomFilter filter) {
            super(filter);
        }

        @Override
        public StateRoomFilter copy() {
            return new StateRoomFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter roomName;

    private IntegerFilter roomDefaultNum;

    private IntegerFilter roomMaxNum;

    private BooleanFilter roomMainView;

    private StateRoomFilter roomState;

    private LongFilter roomImagesId;

    private LongFilter roomPriceId;

    private LongFilter reviewRoomId;

    private LongFilter accommodationId;

    public RoomsCriteria(){
    }

    public RoomsCriteria(RoomsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.roomName = other.roomName == null ? null : other.roomName.copy();
        this.roomDefaultNum = other.roomDefaultNum == null ? null : other.roomDefaultNum.copy();
        this.roomMaxNum = other.roomMaxNum == null ? null : other.roomMaxNum.copy();
        this.roomMainView = other.roomMainView == null ? null : other.roomMainView.copy();
        this.roomState = other.roomState == null ? null : other.roomState.copy();
        this.roomImagesId = other.roomImagesId == null ? null : other.roomImagesId.copy();
        this.roomPriceId = other.roomPriceId == null ? null : other.roomPriceId.copy();
        this.reviewRoomId = other.reviewRoomId == null ? null : other.reviewRoomId.copy();
        this.accommodationId = other.accommodationId == null ? null : other.accommodationId.copy();
    }

    @Override
    public RoomsCriteria copy() {
        return new RoomsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getRoomName() {
        return roomName;
    }

    public void setRoomName(StringFilter roomName) {
        this.roomName = roomName;
    }

    public IntegerFilter getRoomDefaultNum() {
        return roomDefaultNum;
    }

    public void setRoomDefaultNum(IntegerFilter roomDefaultNum) {
        this.roomDefaultNum = roomDefaultNum;
    }

    public IntegerFilter getRoomMaxNum() {
        return roomMaxNum;
    }

    public void setRoomMaxNum(IntegerFilter roomMaxNum) {
        this.roomMaxNum = roomMaxNum;
    }

    public BooleanFilter getRoomMainView() {
        return roomMainView;
    }

    public void setRoomMainView(BooleanFilter roomMainView) {
        this.roomMainView = roomMainView;
    }

    public StateRoomFilter getRoomState() {
        return roomState;
    }

    public void setRoomState(StateRoomFilter roomState) {
        this.roomState = roomState;
    }

    public LongFilter getRoomImagesId() {
        return roomImagesId;
    }

    public void setRoomImagesId(LongFilter roomImagesId) {
        this.roomImagesId = roomImagesId;
    }

    public LongFilter getRoomPriceId() {
        return roomPriceId;
    }

    public void setRoomPriceId(LongFilter roomPriceId) {
        this.roomPriceId = roomPriceId;
    }

    public LongFilter getReviewRoomId() {
        return reviewRoomId;
    }

    public void setReviewRoomId(LongFilter reviewRoomId) {
        this.reviewRoomId = reviewRoomId;
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
        final RoomsCriteria that = (RoomsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(roomName, that.roomName) &&
            Objects.equals(roomDefaultNum, that.roomDefaultNum) &&
            Objects.equals(roomMaxNum, that.roomMaxNum) &&
            Objects.equals(roomMainView, that.roomMainView) &&
            Objects.equals(roomState, that.roomState) &&
            Objects.equals(roomImagesId, that.roomImagesId) &&
            Objects.equals(roomPriceId, that.roomPriceId) &&
            Objects.equals(reviewRoomId, that.reviewRoomId) &&
            Objects.equals(accommodationId, that.accommodationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        roomName,
        roomDefaultNum,
        roomMaxNum,
        roomMainView,
        roomState,
        roomImagesId,
        roomPriceId,
        reviewRoomId,
        accommodationId
        );
    }

    @Override
    public String toString() {
        return "RoomsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (roomName != null ? "roomName=" + roomName + ", " : "") +
                (roomDefaultNum != null ? "roomDefaultNum=" + roomDefaultNum + ", " : "") +
                (roomMaxNum != null ? "roomMaxNum=" + roomMaxNum + ", " : "") +
                (roomMainView != null ? "roomMainView=" + roomMainView + ", " : "") +
                (roomState != null ? "roomState=" + roomState + ", " : "") +
                (roomImagesId != null ? "roomImagesId=" + roomImagesId + ", " : "") +
                (roomPriceId != null ? "roomPriceId=" + roomPriceId + ", " : "") +
                (reviewRoomId != null ? "reviewRoomId=" + reviewRoomId + ", " : "") +
                (accommodationId != null ? "accommodationId=" + accommodationId + ", " : "") +
            "}";
    }

}
