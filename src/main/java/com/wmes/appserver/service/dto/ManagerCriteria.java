package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateManager;
import com.wmes.appserver.domain.enumeration.ManagerRating;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Manager} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ManagerResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /managers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ManagerCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateManager
     */
    public static class StateManagerFilter extends Filter<StateManager> {

        public StateManagerFilter() {
        }

        public StateManagerFilter(StateManagerFilter filter) {
            super(filter);
        }

        @Override
        public StateManagerFilter copy() {
            return new StateManagerFilter(this);
        }

    }
    /**
     * Class for filtering ManagerRating
     */
    public static class ManagerRatingFilter extends Filter<ManagerRating> {

        public ManagerRatingFilter() {
        }

        public ManagerRatingFilter(ManagerRatingFilter filter) {
            super(filter);
        }

        @Override
        public ManagerRatingFilter copy() {
            return new ManagerRatingFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter managerLoginId;

    private StringFilter managerPassword;

    private StringFilter managerName;

    private StringFilter managerNum;

    private StringFilter managerEmail;

    private StringFilter managerNickName;

    private ZonedDateTimeFilter managerCreateDt;

    private ZonedDateTimeFilter managerUpdateDt;

    private StateManagerFilter managerState;

    private StringFilter pushToken;

    private ManagerRatingFilter managerRating;

    private LongFilter managerAccountId;

    private LongFilter managerWorkHistoriesId;

    private LongFilter managerCommissionApplyUserId;

    public ManagerCriteria(){
    }

    public ManagerCriteria(ManagerCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.managerLoginId = other.managerLoginId == null ? null : other.managerLoginId.copy();
        this.managerPassword = other.managerPassword == null ? null : other.managerPassword.copy();
        this.managerName = other.managerName == null ? null : other.managerName.copy();
        this.managerNum = other.managerNum == null ? null : other.managerNum.copy();
        this.managerEmail = other.managerEmail == null ? null : other.managerEmail.copy();
        this.managerNickName = other.managerNickName == null ? null : other.managerNickName.copy();
        this.managerCreateDt = other.managerCreateDt == null ? null : other.managerCreateDt.copy();
        this.managerUpdateDt = other.managerUpdateDt == null ? null : other.managerUpdateDt.copy();
        this.managerState = other.managerState == null ? null : other.managerState.copy();
        this.pushToken = other.pushToken == null ? null : other.pushToken.copy();
        this.managerRating = other.managerRating == null ? null : other.managerRating.copy();
        this.managerAccountId = other.managerAccountId == null ? null : other.managerAccountId.copy();
        this.managerWorkHistoriesId = other.managerWorkHistoriesId == null ? null : other.managerWorkHistoriesId.copy();
        this.managerCommissionApplyUserId = other.managerCommissionApplyUserId == null ? null : other.managerCommissionApplyUserId.copy();
    }

    @Override
    public ManagerCriteria copy() {
        return new ManagerCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getManagerLoginId() {
        return managerLoginId;
    }

    public void setManagerLoginId(StringFilter managerLoginId) {
        this.managerLoginId = managerLoginId;
    }

    public StringFilter getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(StringFilter managerPassword) {
        this.managerPassword = managerPassword;
    }

    public StringFilter getManagerName() {
        return managerName;
    }

    public void setManagerName(StringFilter managerName) {
        this.managerName = managerName;
    }

    public StringFilter getManagerNum() {
        return managerNum;
    }

    public void setManagerNum(StringFilter managerNum) {
        this.managerNum = managerNum;
    }

    public StringFilter getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(StringFilter managerEmail) {
        this.managerEmail = managerEmail;
    }

    public StringFilter getManagerNickName() {
        return managerNickName;
    }

    public void setManagerNickName(StringFilter managerNickName) {
        this.managerNickName = managerNickName;
    }

    public ZonedDateTimeFilter getManagerCreateDt() {
        return managerCreateDt;
    }

    public void setManagerCreateDt(ZonedDateTimeFilter managerCreateDt) {
        this.managerCreateDt = managerCreateDt;
    }

    public ZonedDateTimeFilter getManagerUpdateDt() {
        return managerUpdateDt;
    }

    public void setManagerUpdateDt(ZonedDateTimeFilter managerUpdateDt) {
        this.managerUpdateDt = managerUpdateDt;
    }

    public StateManagerFilter getManagerState() {
        return managerState;
    }

    public void setManagerState(StateManagerFilter managerState) {
        this.managerState = managerState;
    }

    public StringFilter getPushToken() {
        return pushToken;
    }

    public void setPushToken(StringFilter pushToken) {
        this.pushToken = pushToken;
    }

    public ManagerRatingFilter getManagerRating() {
        return managerRating;
    }

    public void setManagerRating(ManagerRatingFilter managerRating) {
        this.managerRating = managerRating;
    }

    public LongFilter getManagerAccountId() {
        return managerAccountId;
    }

    public void setManagerAccountId(LongFilter managerAccountId) {
        this.managerAccountId = managerAccountId;
    }

    public LongFilter getManagerWorkHistoriesId() {
        return managerWorkHistoriesId;
    }

    public void setManagerWorkHistoriesId(LongFilter managerWorkHistoriesId) {
        this.managerWorkHistoriesId = managerWorkHistoriesId;
    }

    public LongFilter getManagerCommissionApplyUserId() {
        return managerCommissionApplyUserId;
    }

    public void setManagerCommissionApplyUserId(LongFilter managerCommissionApplyUserId) {
        this.managerCommissionApplyUserId = managerCommissionApplyUserId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ManagerCriteria that = (ManagerCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(managerLoginId, that.managerLoginId) &&
            Objects.equals(managerPassword, that.managerPassword) &&
            Objects.equals(managerName, that.managerName) &&
            Objects.equals(managerNum, that.managerNum) &&
            Objects.equals(managerEmail, that.managerEmail) &&
            Objects.equals(managerNickName, that.managerNickName) &&
            Objects.equals(managerCreateDt, that.managerCreateDt) &&
            Objects.equals(managerUpdateDt, that.managerUpdateDt) &&
            Objects.equals(managerState, that.managerState) &&
            Objects.equals(pushToken, that.pushToken) &&
            Objects.equals(managerRating, that.managerRating) &&
            Objects.equals(managerAccountId, that.managerAccountId) &&
            Objects.equals(managerWorkHistoriesId, that.managerWorkHistoriesId) &&
            Objects.equals(managerCommissionApplyUserId, that.managerCommissionApplyUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        managerLoginId,
        managerPassword,
        managerName,
        managerNum,
        managerEmail,
        managerNickName,
        managerCreateDt,
        managerUpdateDt,
        managerState,
        pushToken,
        managerRating,
        managerAccountId,
        managerWorkHistoriesId,
        managerCommissionApplyUserId
        );
    }

    @Override
    public String toString() {
        return "ManagerCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (managerLoginId != null ? "managerLoginId=" + managerLoginId + ", " : "") +
                (managerPassword != null ? "managerPassword=" + managerPassword + ", " : "") +
                (managerName != null ? "managerName=" + managerName + ", " : "") +
                (managerNum != null ? "managerNum=" + managerNum + ", " : "") +
                (managerEmail != null ? "managerEmail=" + managerEmail + ", " : "") +
                (managerNickName != null ? "managerNickName=" + managerNickName + ", " : "") +
                (managerCreateDt != null ? "managerCreateDt=" + managerCreateDt + ", " : "") +
                (managerUpdateDt != null ? "managerUpdateDt=" + managerUpdateDt + ", " : "") +
                (managerState != null ? "managerState=" + managerState + ", " : "") +
                (pushToken != null ? "pushToken=" + pushToken + ", " : "") +
                (managerRating != null ? "managerRating=" + managerRating + ", " : "") +
                (managerAccountId != null ? "managerAccountId=" + managerAccountId + ", " : "") +
                (managerWorkHistoriesId != null ? "managerWorkHistoriesId=" + managerWorkHistoriesId + ", " : "") +
                (managerCommissionApplyUserId != null ? "managerCommissionApplyUserId=" + managerCommissionApplyUserId + ", " : "") +
            "}";
    }

}
