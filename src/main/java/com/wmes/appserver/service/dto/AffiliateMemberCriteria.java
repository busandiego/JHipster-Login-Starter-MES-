package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.StateAffiliateMember;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.AffiliateMember} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.AffiliateMemberResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /affiliate-members?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AffiliateMemberCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateAffiliateMember
     */
    public static class StateAffiliateMemberFilter extends Filter<StateAffiliateMember> {

        public StateAffiliateMemberFilter() {
        }

        public StateAffiliateMemberFilter(StateAffiliateMemberFilter filter) {
            super(filter);
        }

        @Override
        public StateAffiliateMemberFilter copy() {
            return new StateAffiliateMemberFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter affiliateMemberLoginId;

    private StringFilter affiliateMemberPassword;

    private StringFilter affiliateMemberName;

    private StringFilter affiliateMemberPhoneNum;

    private StringFilter affiliateMemberMemo;

    private StringFilter pushToken;

    private ZonedDateTimeFilter createDt;

    private ZonedDateTimeFilter updateDt;

    private StateAffiliateMemberFilter affiliateMemberState;

    private LongFilter affiliateId;

    public AffiliateMemberCriteria(){
    }

    public AffiliateMemberCriteria(AffiliateMemberCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.affiliateMemberLoginId = other.affiliateMemberLoginId == null ? null : other.affiliateMemberLoginId.copy();
        this.affiliateMemberPassword = other.affiliateMemberPassword == null ? null : other.affiliateMemberPassword.copy();
        this.affiliateMemberName = other.affiliateMemberName == null ? null : other.affiliateMemberName.copy();
        this.affiliateMemberPhoneNum = other.affiliateMemberPhoneNum == null ? null : other.affiliateMemberPhoneNum.copy();
        this.affiliateMemberMemo = other.affiliateMemberMemo == null ? null : other.affiliateMemberMemo.copy();
        this.pushToken = other.pushToken == null ? null : other.pushToken.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
        this.updateDt = other.updateDt == null ? null : other.updateDt.copy();
        this.affiliateMemberState = other.affiliateMemberState == null ? null : other.affiliateMemberState.copy();
        this.affiliateId = other.affiliateId == null ? null : other.affiliateId.copy();
    }

    @Override
    public AffiliateMemberCriteria copy() {
        return new AffiliateMemberCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAffiliateMemberLoginId() {
        return affiliateMemberLoginId;
    }

    public void setAffiliateMemberLoginId(StringFilter affiliateMemberLoginId) {
        this.affiliateMemberLoginId = affiliateMemberLoginId;
    }

    public StringFilter getAffiliateMemberPassword() {
        return affiliateMemberPassword;
    }

    public void setAffiliateMemberPassword(StringFilter affiliateMemberPassword) {
        this.affiliateMemberPassword = affiliateMemberPassword;
    }

    public StringFilter getAffiliateMemberName() {
        return affiliateMemberName;
    }

    public void setAffiliateMemberName(StringFilter affiliateMemberName) {
        this.affiliateMemberName = affiliateMemberName;
    }

    public StringFilter getAffiliateMemberPhoneNum() {
        return affiliateMemberPhoneNum;
    }

    public void setAffiliateMemberPhoneNum(StringFilter affiliateMemberPhoneNum) {
        this.affiliateMemberPhoneNum = affiliateMemberPhoneNum;
    }

    public StringFilter getAffiliateMemberMemo() {
        return affiliateMemberMemo;
    }

    public void setAffiliateMemberMemo(StringFilter affiliateMemberMemo) {
        this.affiliateMemberMemo = affiliateMemberMemo;
    }

    public StringFilter getPushToken() {
        return pushToken;
    }

    public void setPushToken(StringFilter pushToken) {
        this.pushToken = pushToken;
    }

    public ZonedDateTimeFilter getCreateDt() {
        return createDt;
    }

    public void setCreateDt(ZonedDateTimeFilter createDt) {
        this.createDt = createDt;
    }

    public ZonedDateTimeFilter getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(ZonedDateTimeFilter updateDt) {
        this.updateDt = updateDt;
    }

    public StateAffiliateMemberFilter getAffiliateMemberState() {
        return affiliateMemberState;
    }

    public void setAffiliateMemberState(StateAffiliateMemberFilter affiliateMemberState) {
        this.affiliateMemberState = affiliateMemberState;
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
        final AffiliateMemberCriteria that = (AffiliateMemberCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(affiliateMemberLoginId, that.affiliateMemberLoginId) &&
            Objects.equals(affiliateMemberPassword, that.affiliateMemberPassword) &&
            Objects.equals(affiliateMemberName, that.affiliateMemberName) &&
            Objects.equals(affiliateMemberPhoneNum, that.affiliateMemberPhoneNum) &&
            Objects.equals(affiliateMemberMemo, that.affiliateMemberMemo) &&
            Objects.equals(pushToken, that.pushToken) &&
            Objects.equals(createDt, that.createDt) &&
            Objects.equals(updateDt, that.updateDt) &&
            Objects.equals(affiliateMemberState, that.affiliateMemberState) &&
            Objects.equals(affiliateId, that.affiliateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        affiliateMemberLoginId,
        affiliateMemberPassword,
        affiliateMemberName,
        affiliateMemberPhoneNum,
        affiliateMemberMemo,
        pushToken,
        createDt,
        updateDt,
        affiliateMemberState,
        affiliateId
        );
    }

    @Override
    public String toString() {
        return "AffiliateMemberCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (affiliateMemberLoginId != null ? "affiliateMemberLoginId=" + affiliateMemberLoginId + ", " : "") +
                (affiliateMemberPassword != null ? "affiliateMemberPassword=" + affiliateMemberPassword + ", " : "") +
                (affiliateMemberName != null ? "affiliateMemberName=" + affiliateMemberName + ", " : "") +
                (affiliateMemberPhoneNum != null ? "affiliateMemberPhoneNum=" + affiliateMemberPhoneNum + ", " : "") +
                (affiliateMemberMemo != null ? "affiliateMemberMemo=" + affiliateMemberMemo + ", " : "") +
                (pushToken != null ? "pushToken=" + pushToken + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
                (updateDt != null ? "updateDt=" + updateDt + ", " : "") +
                (affiliateMemberState != null ? "affiliateMemberState=" + affiliateMemberState + ", " : "") +
                (affiliateId != null ? "affiliateId=" + affiliateId + ", " : "") +
            "}";
    }

}
