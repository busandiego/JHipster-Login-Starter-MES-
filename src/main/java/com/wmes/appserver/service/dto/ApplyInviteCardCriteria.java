package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.ApplyInviteCardState;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.ApplyInviteCard} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ApplyInviteCardResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /apply-invite-cards?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ApplyInviteCardCriteria implements Serializable, Criteria {
    /**
     * Class for filtering ApplyInviteCardState
     */
    public static class ApplyInviteCardStateFilter extends Filter<ApplyInviteCardState> {

        public ApplyInviteCardStateFilter() {
        }

        public ApplyInviteCardStateFilter(ApplyInviteCardStateFilter filter) {
            super(filter);
        }

        @Override
        public ApplyInviteCardStateFilter copy() {
            return new ApplyInviteCardStateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter inviteName;

    private ZonedDateTimeFilter applyCardDt;

    private StringFilter managerName;

    private StringFilter accommodationName;

    private StringFilter managerPhoneNum;

    private IntegerFilter applyAmountNum;

    private LongFilter managerId;

    private LongFilter accommodationId;

    private ApplyInviteCardStateFilter applyInviteCardState;

    public ApplyInviteCardCriteria(){
    }

    public ApplyInviteCardCriteria(ApplyInviteCardCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.inviteName = other.inviteName == null ? null : other.inviteName.copy();
        this.applyCardDt = other.applyCardDt == null ? null : other.applyCardDt.copy();
        this.managerName = other.managerName == null ? null : other.managerName.copy();
        this.accommodationName = other.accommodationName == null ? null : other.accommodationName.copy();
        this.managerPhoneNum = other.managerPhoneNum == null ? null : other.managerPhoneNum.copy();
        this.applyAmountNum = other.applyAmountNum == null ? null : other.applyAmountNum.copy();
        this.managerId = other.managerId == null ? null : other.managerId.copy();
        this.accommodationId = other.accommodationId == null ? null : other.accommodationId.copy();
        this.applyInviteCardState = other.applyInviteCardState == null ? null : other.applyInviteCardState.copy();
    }

    @Override
    public ApplyInviteCardCriteria copy() {
        return new ApplyInviteCardCriteria(this);
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

    public ZonedDateTimeFilter getApplyCardDt() {
        return applyCardDt;
    }

    public void setApplyCardDt(ZonedDateTimeFilter applyCardDt) {
        this.applyCardDt = applyCardDt;
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

    public StringFilter getManagerPhoneNum() {
        return managerPhoneNum;
    }

    public void setManagerPhoneNum(StringFilter managerPhoneNum) {
        this.managerPhoneNum = managerPhoneNum;
    }

    public IntegerFilter getApplyAmountNum() {
        return applyAmountNum;
    }

    public void setApplyAmountNum(IntegerFilter applyAmountNum) {
        this.applyAmountNum = applyAmountNum;
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

    public ApplyInviteCardStateFilter getApplyInviteCardState() {
        return applyInviteCardState;
    }

    public void setApplyInviteCardState(ApplyInviteCardStateFilter applyInviteCardState) {
        this.applyInviteCardState = applyInviteCardState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ApplyInviteCardCriteria that = (ApplyInviteCardCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(inviteName, that.inviteName) &&
            Objects.equals(applyCardDt, that.applyCardDt) &&
            Objects.equals(managerName, that.managerName) &&
            Objects.equals(accommodationName, that.accommodationName) &&
            Objects.equals(managerPhoneNum, that.managerPhoneNum) &&
            Objects.equals(applyAmountNum, that.applyAmountNum) &&
            Objects.equals(managerId, that.managerId) &&
            Objects.equals(accommodationId, that.accommodationId) &&
            Objects.equals(applyInviteCardState, that.applyInviteCardState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        inviteName,
        applyCardDt,
        managerName,
        accommodationName,
        managerPhoneNum,
        applyAmountNum,
        managerId,
        accommodationId,
        applyInviteCardState
        );
    }

    @Override
    public String toString() {
        return "ApplyInviteCardCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (inviteName != null ? "inviteName=" + inviteName + ", " : "") +
                (applyCardDt != null ? "applyCardDt=" + applyCardDt + ", " : "") +
                (managerName != null ? "managerName=" + managerName + ", " : "") +
                (accommodationName != null ? "accommodationName=" + accommodationName + ", " : "") +
                (managerPhoneNum != null ? "managerPhoneNum=" + managerPhoneNum + ", " : "") +
                (applyAmountNum != null ? "applyAmountNum=" + applyAmountNum + ", " : "") +
                (managerId != null ? "managerId=" + managerId + ", " : "") +
                (accommodationId != null ? "accommodationId=" + accommodationId + ", " : "") +
                (applyInviteCardState != null ? "applyInviteCardState=" + applyInviteCardState + ", " : "") +
            "}";
    }

}
