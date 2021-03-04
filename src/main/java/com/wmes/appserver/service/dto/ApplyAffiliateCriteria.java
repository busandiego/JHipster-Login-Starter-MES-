package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateApplyAffiliate;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.ApplyAffiliate} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ApplyAffiliateResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /apply-affiliates?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ApplyAffiliateCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateApplyAffiliate
     */
    public static class StateApplyAffiliateFilter extends Filter<StateApplyAffiliate> {

        public StateApplyAffiliateFilter() {
        }

        public StateApplyAffiliateFilter(StateApplyAffiliateFilter filter) {
            super(filter);
        }

        @Override
        public StateApplyAffiliateFilter copy() {
            return new StateApplyAffiliateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter affiliateName;

    private StringFilter applyName;

    private StringFilter affiliateAddress;

    private StringFilter affiliateNum;

    private ZonedDateTimeFilter applyDt;

    private StateApplyAffiliateFilter applyAffiliateState;

    public ApplyAffiliateCriteria(){
    }

    public ApplyAffiliateCriteria(ApplyAffiliateCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.affiliateName = other.affiliateName == null ? null : other.affiliateName.copy();
        this.applyName = other.applyName == null ? null : other.applyName.copy();
        this.affiliateAddress = other.affiliateAddress == null ? null : other.affiliateAddress.copy();
        this.affiliateNum = other.affiliateNum == null ? null : other.affiliateNum.copy();
        this.applyDt = other.applyDt == null ? null : other.applyDt.copy();
        this.applyAffiliateState = other.applyAffiliateState == null ? null : other.applyAffiliateState.copy();
    }

    @Override
    public ApplyAffiliateCriteria copy() {
        return new ApplyAffiliateCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(StringFilter affiliateName) {
        this.affiliateName = affiliateName;
    }

    public StringFilter getApplyName() {
        return applyName;
    }

    public void setApplyName(StringFilter applyName) {
        this.applyName = applyName;
    }

    public StringFilter getAffiliateAddress() {
        return affiliateAddress;
    }

    public void setAffiliateAddress(StringFilter affiliateAddress) {
        this.affiliateAddress = affiliateAddress;
    }

    public StringFilter getAffiliateNum() {
        return affiliateNum;
    }

    public void setAffiliateNum(StringFilter affiliateNum) {
        this.affiliateNum = affiliateNum;
    }

    public ZonedDateTimeFilter getApplyDt() {
        return applyDt;
    }

    public void setApplyDt(ZonedDateTimeFilter applyDt) {
        this.applyDt = applyDt;
    }

    public StateApplyAffiliateFilter getApplyAffiliateState() {
        return applyAffiliateState;
    }

    public void setApplyAffiliateState(StateApplyAffiliateFilter applyAffiliateState) {
        this.applyAffiliateState = applyAffiliateState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ApplyAffiliateCriteria that = (ApplyAffiliateCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(affiliateName, that.affiliateName) &&
            Objects.equals(applyName, that.applyName) &&
            Objects.equals(affiliateAddress, that.affiliateAddress) &&
            Objects.equals(affiliateNum, that.affiliateNum) &&
            Objects.equals(applyDt, that.applyDt) &&
            Objects.equals(applyAffiliateState, that.applyAffiliateState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        affiliateName,
        applyName,
        affiliateAddress,
        affiliateNum,
        applyDt,
        applyAffiliateState
        );
    }

    @Override
    public String toString() {
        return "ApplyAffiliateCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (affiliateName != null ? "affiliateName=" + affiliateName + ", " : "") +
                (applyName != null ? "applyName=" + applyName + ", " : "") +
                (affiliateAddress != null ? "affiliateAddress=" + affiliateAddress + ", " : "") +
                (affiliateNum != null ? "affiliateNum=" + affiliateNum + ", " : "") +
                (applyDt != null ? "applyDt=" + applyDt + ", " : "") +
                (applyAffiliateState != null ? "applyAffiliateState=" + applyAffiliateState + ", " : "") +
            "}";
    }

}
