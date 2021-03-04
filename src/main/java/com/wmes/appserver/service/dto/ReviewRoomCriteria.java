package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateReview;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.ReviewRoom} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ReviewRoomResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /review-rooms?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ReviewRoomCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateReview
     */
    public static class StateReviewFilter extends Filter<StateReview> {

        public StateReviewFilter() {
        }

        public StateReviewFilter(StateReviewFilter filter) {
            super(filter);
        }

        @Override
        public StateReviewFilter copy() {
            return new StateReviewFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter reviewScore;

    private StringFilter reviewTitle;

    private StringFilter reviewContents;

    private ZonedDateTimeFilter reviewCreateDt;

    private ZonedDateTimeFilter reviewUpdateDt;

    private StateReviewFilter reviewState;

    private LongFilter reviewResponseId;

    private LongFilter roomsId;

    private LongFilter hoMemberId;

    public ReviewRoomCriteria(){
    }

    public ReviewRoomCriteria(ReviewRoomCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.reviewScore = other.reviewScore == null ? null : other.reviewScore.copy();
        this.reviewTitle = other.reviewTitle == null ? null : other.reviewTitle.copy();
        this.reviewContents = other.reviewContents == null ? null : other.reviewContents.copy();
        this.reviewCreateDt = other.reviewCreateDt == null ? null : other.reviewCreateDt.copy();
        this.reviewUpdateDt = other.reviewUpdateDt == null ? null : other.reviewUpdateDt.copy();
        this.reviewState = other.reviewState == null ? null : other.reviewState.copy();
        this.reviewResponseId = other.reviewResponseId == null ? null : other.reviewResponseId.copy();
        this.roomsId = other.roomsId == null ? null : other.roomsId.copy();
        this.hoMemberId = other.hoMemberId == null ? null : other.hoMemberId.copy();
    }

    @Override
    public ReviewRoomCriteria copy() {
        return new ReviewRoomCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(IntegerFilter reviewScore) {
        this.reviewScore = reviewScore;
    }

    public StringFilter getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(StringFilter reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public StringFilter getReviewContents() {
        return reviewContents;
    }

    public void setReviewContents(StringFilter reviewContents) {
        this.reviewContents = reviewContents;
    }

    public ZonedDateTimeFilter getReviewCreateDt() {
        return reviewCreateDt;
    }

    public void setReviewCreateDt(ZonedDateTimeFilter reviewCreateDt) {
        this.reviewCreateDt = reviewCreateDt;
    }

    public ZonedDateTimeFilter getReviewUpdateDt() {
        return reviewUpdateDt;
    }

    public void setReviewUpdateDt(ZonedDateTimeFilter reviewUpdateDt) {
        this.reviewUpdateDt = reviewUpdateDt;
    }

    public StateReviewFilter getReviewState() {
        return reviewState;
    }

    public void setReviewState(StateReviewFilter reviewState) {
        this.reviewState = reviewState;
    }

    public LongFilter getReviewResponseId() {
        return reviewResponseId;
    }

    public void setReviewResponseId(LongFilter reviewResponseId) {
        this.reviewResponseId = reviewResponseId;
    }

    public LongFilter getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(LongFilter roomsId) {
        this.roomsId = roomsId;
    }

    public LongFilter getHoMemberId() {
        return hoMemberId;
    }

    public void setHoMemberId(LongFilter hoMemberId) {
        this.hoMemberId = hoMemberId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ReviewRoomCriteria that = (ReviewRoomCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(reviewScore, that.reviewScore) &&
            Objects.equals(reviewTitle, that.reviewTitle) &&
            Objects.equals(reviewContents, that.reviewContents) &&
            Objects.equals(reviewCreateDt, that.reviewCreateDt) &&
            Objects.equals(reviewUpdateDt, that.reviewUpdateDt) &&
            Objects.equals(reviewState, that.reviewState) &&
            Objects.equals(reviewResponseId, that.reviewResponseId) &&
            Objects.equals(roomsId, that.roomsId) &&
            Objects.equals(hoMemberId, that.hoMemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        reviewScore,
        reviewTitle,
        reviewContents,
        reviewCreateDt,
        reviewUpdateDt,
        reviewState,
        reviewResponseId,
        roomsId,
        hoMemberId
        );
    }

    @Override
    public String toString() {
        return "ReviewRoomCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (reviewScore != null ? "reviewScore=" + reviewScore + ", " : "") +
                (reviewTitle != null ? "reviewTitle=" + reviewTitle + ", " : "") +
                (reviewContents != null ? "reviewContents=" + reviewContents + ", " : "") +
                (reviewCreateDt != null ? "reviewCreateDt=" + reviewCreateDt + ", " : "") +
                (reviewUpdateDt != null ? "reviewUpdateDt=" + reviewUpdateDt + ", " : "") +
                (reviewState != null ? "reviewState=" + reviewState + ", " : "") +
                (reviewResponseId != null ? "reviewResponseId=" + reviewResponseId + ", " : "") +
                (roomsId != null ? "roomsId=" + roomsId + ", " : "") +
                (hoMemberId != null ? "hoMemberId=" + hoMemberId + ", " : "") +
            "}";
    }

}
