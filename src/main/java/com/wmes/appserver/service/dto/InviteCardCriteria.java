package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.InviteCardState;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.InviteCard} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.InviteCardResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /invite-cards?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InviteCardCriteria implements Serializable, Criteria {
    /**
     * Class for filtering InviteCardState
     */
    public static class InviteCardStateFilter extends Filter<InviteCardState> {

        public InviteCardStateFilter() {
        }

        public InviteCardStateFilter(InviteCardStateFilter filter) {
            super(filter);
        }

        @Override
        public InviteCardStateFilter copy() {
            return new InviteCardStateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter inviteName;

    private StringFilter inviteSerial;

    private ZonedDateTimeFilter inviteCreateDt;

    private ZonedDateTimeFilter inviteExpirationDt;

    private StringFilter managerName;

    private StringFilter accommodationName;

    private IntegerFilter inflowNum;

    private IntegerFilter reservationNum;

    private LongFilter managerId;

    private LongFilter accommodationId;

    private InviteCardStateFilter inviteCardState;

    public InviteCardCriteria(){
    }

    public InviteCardCriteria(InviteCardCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.inviteName = other.inviteName == null ? null : other.inviteName.copy();
        this.inviteSerial = other.inviteSerial == null ? null : other.inviteSerial.copy();
        this.inviteCreateDt = other.inviteCreateDt == null ? null : other.inviteCreateDt.copy();
        this.inviteExpirationDt = other.inviteExpirationDt == null ? null : other.inviteExpirationDt.copy();
        this.managerName = other.managerName == null ? null : other.managerName.copy();
        this.accommodationName = other.accommodationName == null ? null : other.accommodationName.copy();
        this.inflowNum = other.inflowNum == null ? null : other.inflowNum.copy();
        this.reservationNum = other.reservationNum == null ? null : other.reservationNum.copy();
        this.managerId = other.managerId == null ? null : other.managerId.copy();
        this.accommodationId = other.accommodationId == null ? null : other.accommodationId.copy();
        this.inviteCardState = other.inviteCardState == null ? null : other.inviteCardState.copy();
    }

    @Override
    public InviteCardCriteria copy() {
        return new InviteCardCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getInviteName() {
        return inviteName;
    }

    public void setInviteName(StringFilter inviteName) {
        this.inviteName = inviteName;
    }

    public StringFilter getInviteSerial() {
        return inviteSerial;
    }

    public void setInviteSerial(StringFilter inviteSerial) {
        this.inviteSerial = inviteSerial;
    }

    public ZonedDateTimeFilter getInviteCreateDt() {
        return inviteCreateDt;
    }

    public void setInviteCreateDt(ZonedDateTimeFilter inviteCreateDt) {
        this.inviteCreateDt = inviteCreateDt;
    }

    public ZonedDateTimeFilter getInviteExpirationDt() {
        return inviteExpirationDt;
    }

    public void setInviteExpirationDt(ZonedDateTimeFilter inviteExpirationDt) {
        this.inviteExpirationDt = inviteExpirationDt;
    }

    public StringFilter getManagerName() {
        return managerName;
    }

    public void setManagerName(StringFilter managerName) {
        this.managerName = managerName;
    }

    public StringFilter getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(StringFilter accommodationName) {
        this.accommodationName = accommodationName;
    }

    public IntegerFilter getInflowNum() {
        return inflowNum;
    }

    public void setInflowNum(IntegerFilter inflowNum) {
        this.inflowNum = inflowNum;
    }

    public IntegerFilter getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(IntegerFilter reservationNum) {
        this.reservationNum = reservationNum;
    }

    public LongFilter getManagerId() {
        return managerId;
    }

    public void setManagerId(LongFilter managerId) {
        this.managerId = managerId;
    }

    public LongFilter getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(LongFilter accommodationId) {
        this.accommodationId = accommodationId;
    }

    public InviteCardStateFilter getInviteCardState() {
        return inviteCardState;
    }

    public void setInviteCardState(InviteCardStateFilter inviteCardState) {
        this.inviteCardState = inviteCardState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InviteCardCriteria that = (InviteCardCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(inviteName, that.inviteName) &&
            Objects.equals(inviteSerial, that.inviteSerial) &&
            Objects.equals(inviteCreateDt, that.inviteCreateDt) &&
            Objects.equals(inviteExpirationDt, that.inviteExpirationDt) &&
            Objects.equals(managerName, that.managerName) &&
            Objects.equals(accommodationName, that.accommodationName) &&
            Objects.equals(inflowNum, that.inflowNum) &&
            Objects.equals(reservationNum, that.reservationNum) &&
            Objects.equals(managerId, that.managerId) &&
            Objects.equals(accommodationId, that.accommodationId) &&
            Objects.equals(inviteCardState, that.inviteCardState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        inviteName,
        inviteSerial,
        inviteCreateDt,
        inviteExpirationDt,
        managerName,
        accommodationName,
        inflowNum,
        reservationNum,
        managerId,
        accommodationId,
        inviteCardState
        );
    }

    @Override
    public String toString() {
        return "InviteCardCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (inviteName != null ? "inviteName=" + inviteName + ", " : "") +
                (inviteSerial != null ? "inviteSerial=" + inviteSerial + ", " : "") +
                (inviteCreateDt != null ? "inviteCreateDt=" + inviteCreateDt + ", " : "") +
                (inviteExpirationDt != null ? "inviteExpirationDt=" + inviteExpirationDt + ", " : "") +
                (managerName != null ? "managerName=" + managerName + ", " : "") +
                (accommodationName != null ? "accommodationName=" + accommodationName + ", " : "") +
                (inflowNum != null ? "inflowNum=" + inflowNum + ", " : "") +
                (reservationNum != null ? "reservationNum=" + reservationNum + ", " : "") +
                (managerId != null ? "managerId=" + managerId + ", " : "") +
                (accommodationId != null ? "accommodationId=" + accommodationId + ", " : "") +
                (inviteCardState != null ? "inviteCardState=" + inviteCardState + ", " : "") +
            "}";
    }

}
