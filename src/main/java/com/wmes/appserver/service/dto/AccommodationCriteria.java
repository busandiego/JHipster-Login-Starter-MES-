package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.AccommodationType;
import com.wmes.appserver.domain.enumeration.StateAccommodation;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.BigDecimalFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Accommodation} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.AccommodationResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /accommodations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AccommodationCriteria implements Serializable, Criteria {
    /**
     * Class for filtering AccommodationType
     */
    public static class AccommodationTypeFilter extends Filter<AccommodationType> {

        public AccommodationTypeFilter() {
        }

        public AccommodationTypeFilter(AccommodationTypeFilter filter) {
            super(filter);
        }

        @Override
        public AccommodationTypeFilter copy() {
            return new AccommodationTypeFilter(this);
        }

    }
    /**
     * Class for filtering StateAccommodation
     */
    public static class StateAccommodationFilter extends Filter<StateAccommodation> {

        public StateAccommodationFilter() {
        }

        public StateAccommodationFilter(StateAccommodationFilter filter) {
            super(filter);
        }

        @Override
        public StateAccommodationFilter copy() {
            return new StateAccommodationFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter accommodationName;

    private StringFilter promotionalPhrase;

    private StringFilter accommodationIntroTitle;

    private StringFilter accommodationRoadAddress;

    private StringFilter accommodationZipAddress;

    private StringFilter accommodationLineComment;

    private BooleanFilter accommodationFullRoom;

    private BooleanFilter accommodationFullDayuse;

    private AccommodationTypeFilter accommodationType;

    private BooleanFilter affiliateCheck;

    private ZonedDateTimeFilter accommodationCreateDt;

    private ZonedDateTimeFilter accommodationUpdateDt;

    private IntegerFilter alignmentNum;

    private BigDecimalFilter accommodationLatitude;

    private BigDecimalFilter accommodationLongitude;

    private BooleanFilter accommodationPreReservation;

    private IntegerFilter accommodationPreReservationDate;

    private StateAccommodationFilter accommodationState;

    private LongFilter adminUserId;

    private LongFilter accommodationDescriptionId;

    private LongFilter accommodationImageId;

    private LongFilter accommodationAmenityId;

    private LongFilter accommodationServiceInfoId;

    private LongFilter roomsId;

    private LongFilter accommodationSalesId;

    private LongFilter affiliateId;

    public AccommodationCriteria(){
    }

    public AccommodationCriteria(AccommodationCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.accommodationName = other.accommodationName == null ? null : other.accommodationName.copy();
        this.promotionalPhrase = other.promotionalPhrase == null ? null : other.promotionalPhrase.copy();
        this.accommodationIntroTitle = other.accommodationIntroTitle == null ? null : other.accommodationIntroTitle.copy();
        this.accommodationRoadAddress = other.accommodationRoadAddress == null ? null : other.accommodationRoadAddress.copy();
        this.accommodationZipAddress = other.accommodationZipAddress == null ? null : other.accommodationZipAddress.copy();
        this.accommodationLineComment = other.accommodationLineComment == null ? null : other.accommodationLineComment.copy();
        this.accommodationFullRoom = other.accommodationFullRoom == null ? null : other.accommodationFullRoom.copy();
        this.accommodationFullDayuse = other.accommodationFullDayuse == null ? null : other.accommodationFullDayuse.copy();
        this.accommodationType = other.accommodationType == null ? null : other.accommodationType.copy();
        this.affiliateCheck = other.affiliateCheck == null ? null : other.affiliateCheck.copy();
        this.accommodationCreateDt = other.accommodationCreateDt == null ? null : other.accommodationCreateDt.copy();
        this.accommodationUpdateDt = other.accommodationUpdateDt == null ? null : other.accommodationUpdateDt.copy();
        this.alignmentNum = other.alignmentNum == null ? null : other.alignmentNum.copy();
        this.accommodationLatitude = other.accommodationLatitude == null ? null : other.accommodationLatitude.copy();
        this.accommodationLongitude = other.accommodationLongitude == null ? null : other.accommodationLongitude.copy();
        this.accommodationPreReservation = other.accommodationPreReservation == null ? null : other.accommodationPreReservation.copy();
        this.accommodationPreReservationDate = other.accommodationPreReservationDate == null ? null : other.accommodationPreReservationDate.copy();
        this.accommodationState = other.accommodationState == null ? null : other.accommodationState.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
        this.accommodationDescriptionId = other.accommodationDescriptionId == null ? null : other.accommodationDescriptionId.copy();
        this.accommodationImageId = other.accommodationImageId == null ? null : other.accommodationImageId.copy();
        this.accommodationAmenityId = other.accommodationAmenityId == null ? null : other.accommodationAmenityId.copy();
        this.accommodationServiceInfoId = other.accommodationServiceInfoId == null ? null : other.accommodationServiceInfoId.copy();
        this.roomsId = other.roomsId == null ? null : other.roomsId.copy();
        this.accommodationSalesId = other.accommodationSalesId == null ? null : other.accommodationSalesId.copy();
        this.affiliateId = other.affiliateId == null ? null : other.affiliateId.copy();
    }

    @Override
    public AccommodationCriteria copy() {
        return new AccommodationCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(StringFilter accommodationName) {
        this.accommodationName = accommodationName;
    }

    public StringFilter getPromotionalPhrase() {
        return promotionalPhrase;
    }

    public void setPromotionalPhrase(StringFilter promotionalPhrase) {
        this.promotionalPhrase = promotionalPhrase;
    }

    public StringFilter getAccommodationIntroTitle() {
        return accommodationIntroTitle;
    }

    public void setAccommodationIntroTitle(StringFilter accommodationIntroTitle) {
        this.accommodationIntroTitle = accommodationIntroTitle;
    }

    public StringFilter getAccommodationRoadAddress() {
        return accommodationRoadAddress;
    }

    public void setAccommodationRoadAddress(StringFilter accommodationRoadAddress) {
        this.accommodationRoadAddress = accommodationRoadAddress;
    }

    public StringFilter getAccommodationZipAddress() {
        return accommodationZipAddress;
    }

    public void setAccommodationZipAddress(StringFilter accommodationZipAddress) {
        this.accommodationZipAddress = accommodationZipAddress;
    }

    public StringFilter getAccommodationLineComment() {
        return accommodationLineComment;
    }

    public void setAccommodationLineComment(StringFilter accommodationLineComment) {
        this.accommodationLineComment = accommodationLineComment;
    }

    public BooleanFilter getAccommodationFullRoom() {
        return accommodationFullRoom;
    }

    public void setAccommodationFullRoom(BooleanFilter accommodationFullRoom) {
        this.accommodationFullRoom = accommodationFullRoom;
    }

    public BooleanFilter getAccommodationFullDayuse() {
        return accommodationFullDayuse;
    }

    public void setAccommodationFullDayuse(BooleanFilter accommodationFullDayuse) {
        this.accommodationFullDayuse = accommodationFullDayuse;
    }

    public AccommodationTypeFilter getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationTypeFilter accommodationType) {
        this.accommodationType = accommodationType;
    }

    public BooleanFilter getAffiliateCheck() {
        return affiliateCheck;
    }

    public void setAffiliateCheck(BooleanFilter affiliateCheck) {
        this.affiliateCheck = affiliateCheck;
    }

    public ZonedDateTimeFilter getAccommodationCreateDt() {
        return accommodationCreateDt;
    }

    public void setAccommodationCreateDt(ZonedDateTimeFilter accommodationCreateDt) {
        this.accommodationCreateDt = accommodationCreateDt;
    }

    public ZonedDateTimeFilter getAccommodationUpdateDt() {
        return accommodationUpdateDt;
    }

    public void setAccommodationUpdateDt(ZonedDateTimeFilter accommodationUpdateDt) {
        this.accommodationUpdateDt = accommodationUpdateDt;
    }

    public IntegerFilter getAlignmentNum() {
        return alignmentNum;
    }

    public void setAlignmentNum(IntegerFilter alignmentNum) {
        this.alignmentNum = alignmentNum;
    }

    public BigDecimalFilter getAccommodationLatitude() {
        return accommodationLatitude;
    }

    public void setAccommodationLatitude(BigDecimalFilter accommodationLatitude) {
        this.accommodationLatitude = accommodationLatitude;
    }

    public BigDecimalFilter getAccommodationLongitude() {
        return accommodationLongitude;
    }

    public void setAccommodationLongitude(BigDecimalFilter accommodationLongitude) {
        this.accommodationLongitude = accommodationLongitude;
    }

    public BooleanFilter getAccommodationPreReservation() {
        return accommodationPreReservation;
    }

    public void setAccommodationPreReservation(BooleanFilter accommodationPreReservation) {
        this.accommodationPreReservation = accommodationPreReservation;
    }

    public IntegerFilter getAccommodationPreReservationDate() {
        return accommodationPreReservationDate;
    }

    public void setAccommodationPreReservationDate(IntegerFilter accommodationPreReservationDate) {
        this.accommodationPreReservationDate = accommodationPreReservationDate;
    }

    public StateAccommodationFilter getAccommodationState() {
        return accommodationState;
    }

    public void setAccommodationState(StateAccommodationFilter accommodationState) {
        this.accommodationState = accommodationState;
    }

    public LongFilter getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(LongFilter adminUserId) {
        this.adminUserId = adminUserId;
    }

    public LongFilter getAccommodationDescriptionId() {
        return accommodationDescriptionId;
    }

    public void setAccommodationDescriptionId(LongFilter accommodationDescriptionId) {
        this.accommodationDescriptionId = accommodationDescriptionId;
    }

    public LongFilter getAccommodationImageId() {
        return accommodationImageId;
    }

    public void setAccommodationImageId(LongFilter accommodationImageId) {
        this.accommodationImageId = accommodationImageId;
    }

    public LongFilter getAccommodationAmenityId() {
        return accommodationAmenityId;
    }

    public void setAccommodationAmenityId(LongFilter accommodationAmenityId) {
        this.accommodationAmenityId = accommodationAmenityId;
    }

    public LongFilter getAccommodationServiceInfoId() {
        return accommodationServiceInfoId;
    }

    public void setAccommodationServiceInfoId(LongFilter accommodationServiceInfoId) {
        this.accommodationServiceInfoId = accommodationServiceInfoId;
    }

    public LongFilter getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(LongFilter roomsId) {
        this.roomsId = roomsId;
    }

    public LongFilter getAccommodationSalesId() {
        return accommodationSalesId;
    }

    public void setAccommodationSalesId(LongFilter accommodationSalesId) {
        this.accommodationSalesId = accommodationSalesId;
    }

    public LongFilter getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(LongFilter affiliateId) {
        this.affiliateId = affiliateId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AccommodationCriteria that = (AccommodationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(accommodationName, that.accommodationName) &&
            Objects.equals(promotionalPhrase, that.promotionalPhrase) &&
            Objects.equals(accommodationIntroTitle, that.accommodationIntroTitle) &&
            Objects.equals(accommodationRoadAddress, that.accommodationRoadAddress) &&
            Objects.equals(accommodationZipAddress, that.accommodationZipAddress) &&
            Objects.equals(accommodationLineComment, that.accommodationLineComment) &&
            Objects.equals(accommodationFullRoom, that.accommodationFullRoom) &&
            Objects.equals(accommodationFullDayuse, that.accommodationFullDayuse) &&
            Objects.equals(accommodationType, that.accommodationType) &&
            Objects.equals(affiliateCheck, that.affiliateCheck) &&
            Objects.equals(accommodationCreateDt, that.accommodationCreateDt) &&
            Objects.equals(accommodationUpdateDt, that.accommodationUpdateDt) &&
            Objects.equals(alignmentNum, that.alignmentNum) &&
            Objects.equals(accommodationLatitude, that.accommodationLatitude) &&
            Objects.equals(accommodationLongitude, that.accommodationLongitude) &&
            Objects.equals(accommodationPreReservation, that.accommodationPreReservation) &&
            Objects.equals(accommodationPreReservationDate, that.accommodationPreReservationDate) &&
            Objects.equals(accommodationState, that.accommodationState) &&
            Objects.equals(adminUserId, that.adminUserId) &&
            Objects.equals(accommodationDescriptionId, that.accommodationDescriptionId) &&
            Objects.equals(accommodationImageId, that.accommodationImageId) &&
            Objects.equals(accommodationAmenityId, that.accommodationAmenityId) &&
            Objects.equals(accommodationServiceInfoId, that.accommodationServiceInfoId) &&
            Objects.equals(roomsId, that.roomsId) &&
            Objects.equals(accommodationSalesId, that.accommodationSalesId) &&
            Objects.equals(affiliateId, that.affiliateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        accommodationName,
        promotionalPhrase,
        accommodationIntroTitle,
        accommodationRoadAddress,
        accommodationZipAddress,
        accommodationLineComment,
        accommodationFullRoom,
        accommodationFullDayuse,
        accommodationType,
        affiliateCheck,
        accommodationCreateDt,
        accommodationUpdateDt,
        alignmentNum,
        accommodationLatitude,
        accommodationLongitude,
        accommodationPreReservation,
        accommodationPreReservationDate,
        accommodationState,
        adminUserId,
        accommodationDescriptionId,
        accommodationImageId,
        accommodationAmenityId,
        accommodationServiceInfoId,
        roomsId,
        accommodationSalesId,
        affiliateId
        );
    }

    @Override
    public String toString() {
        return "AccommodationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (accommodationName != null ? "accommodationName=" + accommodationName + ", " : "") +
                (promotionalPhrase != null ? "promotionalPhrase=" + promotionalPhrase + ", " : "") +
                (accommodationIntroTitle != null ? "accommodationIntroTitle=" + accommodationIntroTitle + ", " : "") +
                (accommodationRoadAddress != null ? "accommodationRoadAddress=" + accommodationRoadAddress + ", " : "") +
                (accommodationZipAddress != null ? "accommodationZipAddress=" + accommodationZipAddress + ", " : "") +
                (accommodationLineComment != null ? "accommodationLineComment=" + accommodationLineComment + ", " : "") +
                (accommodationFullRoom != null ? "accommodationFullRoom=" + accommodationFullRoom + ", " : "") +
                (accommodationFullDayuse != null ? "accommodationFullDayuse=" + accommodationFullDayuse + ", " : "") +
                (accommodationType != null ? "accommodationType=" + accommodationType + ", " : "") +
                (affiliateCheck != null ? "affiliateCheck=" + affiliateCheck + ", " : "") +
                (accommodationCreateDt != null ? "accommodationCreateDt=" + accommodationCreateDt + ", " : "") +
                (accommodationUpdateDt != null ? "accommodationUpdateDt=" + accommodationUpdateDt + ", " : "") +
                (alignmentNum != null ? "alignmentNum=" + alignmentNum + ", " : "") +
                (accommodationLatitude != null ? "accommodationLatitude=" + accommodationLatitude + ", " : "") +
                (accommodationLongitude != null ? "accommodationLongitude=" + accommodationLongitude + ", " : "") +
                (accommodationPreReservation != null ? "accommodationPreReservation=" + accommodationPreReservation + ", " : "") +
                (accommodationPreReservationDate != null ? "accommodationPreReservationDate=" + accommodationPreReservationDate + ", " : "") +
                (accommodationState != null ? "accommodationState=" + accommodationState + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
                (accommodationDescriptionId != null ? "accommodationDescriptionId=" + accommodationDescriptionId + ", " : "") +
                (accommodationImageId != null ? "accommodationImageId=" + accommodationImageId + ", " : "") +
                (accommodationAmenityId != null ? "accommodationAmenityId=" + accommodationAmenityId + ", " : "") +
                (accommodationServiceInfoId != null ? "accommodationServiceInfoId=" + accommodationServiceInfoId + ", " : "") +
                (roomsId != null ? "roomsId=" + roomsId + ", " : "") +
                (accommodationSalesId != null ? "accommodationSalesId=" + accommodationSalesId + ", " : "") +
                (affiliateId != null ? "affiliateId=" + affiliateId + ", " : "") +
            "}";
    }

}
