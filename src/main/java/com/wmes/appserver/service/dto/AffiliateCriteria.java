package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateAffiliate;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Affiliate} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.AffiliateResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /affiliates?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AffiliateCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateAffiliate
     */
    public static class StateAffiliateFilter extends Filter<StateAffiliate> {

        public StateAffiliateFilter() {
        }

        public StateAffiliateFilter(StateAffiliateFilter filter) {
            super(filter);
        }

        @Override
        public StateAffiliateFilter copy() {
            return new StateAffiliateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter affiliateName;

    private IntegerFilter affiliateRegNum;

    private StringFilter affiliateOwner;

    private StringFilter affiliateBank;

    private StringFilter affiliateAccount;

    private StringFilter affiliateAccountHolder;

    private StringFilter affiliateMemo;

    private StringFilter affiliateAddress;

    private ZonedDateTimeFilter affiliateRegDt;

    private ZonedDateTimeFilter affiliateUpdateDt;

    private IntegerFilter affiliateCommissionPer;

    private StateAffiliateFilter affiliateState;

    private LongFilter adminUserId;

    private LongFilter managerWorkHistoriesId;

    private LongFilter callAffiliateId;

    private LongFilter accommodationId;

    private LongFilter couponId;

    private LongFilter affiliateCommissionSettingId;

    private LongFilter mileageSettingId;

    private LongFilter totalBalanceTimeId;

    private LongFilter affiliateAdminId;

    public AffiliateCriteria(){
    }

    public AffiliateCriteria(AffiliateCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.affiliateName = other.affiliateName == null ? null : other.affiliateName.copy();
        this.affiliateRegNum = other.affiliateRegNum == null ? null : other.affiliateRegNum.copy();
        this.affiliateOwner = other.affiliateOwner == null ? null : other.affiliateOwner.copy();
        this.affiliateBank = other.affiliateBank == null ? null : other.affiliateBank.copy();
        this.affiliateAccount = other.affiliateAccount == null ? null : other.affiliateAccount.copy();
        this.affiliateAccountHolder = other.affiliateAccountHolder == null ? null : other.affiliateAccountHolder.copy();
        this.affiliateMemo = other.affiliateMemo == null ? null : other.affiliateMemo.copy();
        this.affiliateAddress = other.affiliateAddress == null ? null : other.affiliateAddress.copy();
        this.affiliateRegDt = other.affiliateRegDt == null ? null : other.affiliateRegDt.copy();
        this.affiliateUpdateDt = other.affiliateUpdateDt == null ? null : other.affiliateUpdateDt.copy();
        this.affiliateCommissionPer = other.affiliateCommissionPer == null ? null : other.affiliateCommissionPer.copy();
        this.affiliateState = other.affiliateState == null ? null : other.affiliateState.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
        this.managerWorkHistoriesId = other.managerWorkHistoriesId == null ? null : other.managerWorkHistoriesId.copy();
        this.callAffiliateId = other.callAffiliateId == null ? null : other.callAffiliateId.copy();
        this.accommodationId = other.accommodationId == null ? null : other.accommodationId.copy();
        this.couponId = other.couponId == null ? null : other.couponId.copy();
        this.affiliateCommissionSettingId = other.affiliateCommissionSettingId == null ? null : other.affiliateCommissionSettingId.copy();
        this.mileageSettingId = other.mileageSettingId == null ? null : other.mileageSettingId.copy();
        this.totalBalanceTimeId = other.totalBalanceTimeId == null ? null : other.totalBalanceTimeId.copy();
        this.affiliateAdminId = other.affiliateAdminId == null ? null : other.affiliateAdminId.copy();
    }

    @Override
    public AffiliateCriteria copy() {
        return new AffiliateCriteria(this);
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

    public IntegerFilter getAffiliateRegNum() {
        return affiliateRegNum;
    }

    public void setAffiliateRegNum(IntegerFilter affiliateRegNum) {
        this.affiliateRegNum = affiliateRegNum;
    }

    public StringFilter getAffiliateOwner() {
        return affiliateOwner;
    }

    public void setAffiliateOwner(StringFilter affiliateOwner) {
        this.affiliateOwner = affiliateOwner;
    }

    public StringFilter getAffiliateBank() {
        return affiliateBank;
    }

    public void setAffiliateBank(StringFilter affiliateBank) {
        this.affiliateBank = affiliateBank;
    }

    public StringFilter getAffiliateAccount() {
        return affiliateAccount;
    }

    public void setAffiliateAccount(StringFilter affiliateAccount) {
        this.affiliateAccount = affiliateAccount;
    }

    public StringFilter getAffiliateAccountHolder() {
        return affiliateAccountHolder;
    }

    public void setAffiliateAccountHolder(StringFilter affiliateAccountHolder) {
        this.affiliateAccountHolder = affiliateAccountHolder;
    }

    public StringFilter getAffiliateMemo() {
        return affiliateMemo;
    }

    public void setAffiliateMemo(StringFilter affiliateMemo) {
        this.affiliateMemo = affiliateMemo;
    }

    public StringFilter getAffiliateAddress() {
        return affiliateAddress;
    }

    public void setAffiliateAddress(StringFilter affiliateAddress) {
        this.affiliateAddress = affiliateAddress;
    }

    public ZonedDateTimeFilter getAffiliateRegDt() {
        return affiliateRegDt;
    }

    public void setAffiliateRegDt(ZonedDateTimeFilter affiliateRegDt) {
        this.affiliateRegDt = affiliateRegDt;
    }

    public ZonedDateTimeFilter getAffiliateUpdateDt() {
        return affiliateUpdateDt;
    }

    public void setAffiliateUpdateDt(ZonedDateTimeFilter affiliateUpdateDt) {
        this.affiliateUpdateDt = affiliateUpdateDt;
    }

    public IntegerFilter getAffiliateCommissionPer() {
        return affiliateCommissionPer;
    }

    public void setAffiliateCommissionPer(IntegerFilter affiliateCommissionPer) {
        this.affiliateCommissionPer = affiliateCommissionPer;
    }

    public StateAffiliateFilter getAffiliateState() {
        return affiliateState;
    }

    public void setAffiliateState(StateAffiliateFilter affiliateState) {
        this.affiliateState = affiliateState;
    }

    public LongFilter getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(LongFilter adminUserId) {
        this.adminUserId = adminUserId;
    }

    public LongFilter getManagerWorkHistoriesId() {
        return managerWorkHistoriesId;
    }

    public void setManagerWorkHistoriesId(LongFilter managerWorkHistoriesId) {
        this.managerWorkHistoriesId = managerWorkHistoriesId;
    }

    public LongFilter getCallAffiliateId() {
        return callAffiliateId;
    }

    public void setCallAffiliateId(LongFilter callAffiliateId) {
        this.callAffiliateId = callAffiliateId;
    }

    public LongFilter getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(LongFilter accommodationId) {
        this.accommodationId = accommodationId;
    }

    public LongFilter getCouponId() {
        return couponId;
    }

    public void setCouponId(LongFilter couponId) {
        this.couponId = couponId;
    }

    public LongFilter getAffiliateCommissionSettingId() {
        return affiliateCommissionSettingId;
    }

    public void setAffiliateCommissionSettingId(LongFilter affiliateCommissionSettingId) {
        this.affiliateCommissionSettingId = affiliateCommissionSettingId;
    }

    public LongFilter getMileageSettingId() {
        return mileageSettingId;
    }

    public void setMileageSettingId(LongFilter mileageSettingId) {
        this.mileageSettingId = mileageSettingId;
    }

    public LongFilter getTotalBalanceTimeId() {
        return totalBalanceTimeId;
    }

    public void setTotalBalanceTimeId(LongFilter totalBalanceTimeId) {
        this.totalBalanceTimeId = totalBalanceTimeId;
    }

    public LongFilter getAffiliateAdminId() {
        return affiliateAdminId;
    }

    public void setAffiliateAdminId(LongFilter affiliateAdminId) {
        this.affiliateAdminId = affiliateAdminId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AffiliateCriteria that = (AffiliateCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(affiliateName, that.affiliateName) &&
            Objects.equals(affiliateRegNum, that.affiliateRegNum) &&
            Objects.equals(affiliateOwner, that.affiliateOwner) &&
            Objects.equals(affiliateBank, that.affiliateBank) &&
            Objects.equals(affiliateAccount, that.affiliateAccount) &&
            Objects.equals(affiliateAccountHolder, that.affiliateAccountHolder) &&
            Objects.equals(affiliateMemo, that.affiliateMemo) &&
            Objects.equals(affiliateAddress, that.affiliateAddress) &&
            Objects.equals(affiliateRegDt, that.affiliateRegDt) &&
            Objects.equals(affiliateUpdateDt, that.affiliateUpdateDt) &&
            Objects.equals(affiliateCommissionPer, that.affiliateCommissionPer) &&
            Objects.equals(affiliateState, that.affiliateState) &&
            Objects.equals(adminUserId, that.adminUserId) &&
            Objects.equals(managerWorkHistoriesId, that.managerWorkHistoriesId) &&
            Objects.equals(callAffiliateId, that.callAffiliateId) &&
            Objects.equals(accommodationId, that.accommodationId) &&
            Objects.equals(couponId, that.couponId) &&
            Objects.equals(affiliateCommissionSettingId, that.affiliateCommissionSettingId) &&
            Objects.equals(mileageSettingId, that.mileageSettingId) &&
            Objects.equals(totalBalanceTimeId, that.totalBalanceTimeId) &&
            Objects.equals(affiliateAdminId, that.affiliateAdminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        affiliateName,
        affiliateRegNum,
        affiliateOwner,
        affiliateBank,
        affiliateAccount,
        affiliateAccountHolder,
        affiliateMemo,
        affiliateAddress,
        affiliateRegDt,
        affiliateUpdateDt,
        affiliateCommissionPer,
        affiliateState,
        adminUserId,
        managerWorkHistoriesId,
        callAffiliateId,
        accommodationId,
        couponId,
        affiliateCommissionSettingId,
        mileageSettingId,
        totalBalanceTimeId,
        affiliateAdminId
        );
    }

    @Override
    public String toString() {
        return "AffiliateCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (affiliateName != null ? "affiliateName=" + affiliateName + ", " : "") +
                (affiliateRegNum != null ? "affiliateRegNum=" + affiliateRegNum + ", " : "") +
                (affiliateOwner != null ? "affiliateOwner=" + affiliateOwner + ", " : "") +
                (affiliateBank != null ? "affiliateBank=" + affiliateBank + ", " : "") +
                (affiliateAccount != null ? "affiliateAccount=" + affiliateAccount + ", " : "") +
                (affiliateAccountHolder != null ? "affiliateAccountHolder=" + affiliateAccountHolder + ", " : "") +
                (affiliateMemo != null ? "affiliateMemo=" + affiliateMemo + ", " : "") +
                (affiliateAddress != null ? "affiliateAddress=" + affiliateAddress + ", " : "") +
                (affiliateRegDt != null ? "affiliateRegDt=" + affiliateRegDt + ", " : "") +
                (affiliateUpdateDt != null ? "affiliateUpdateDt=" + affiliateUpdateDt + ", " : "") +
                (affiliateCommissionPer != null ? "affiliateCommissionPer=" + affiliateCommissionPer + ", " : "") +
                (affiliateState != null ? "affiliateState=" + affiliateState + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
                (managerWorkHistoriesId != null ? "managerWorkHistoriesId=" + managerWorkHistoriesId + ", " : "") +
                (callAffiliateId != null ? "callAffiliateId=" + callAffiliateId + ", " : "") +
                (accommodationId != null ? "accommodationId=" + accommodationId + ", " : "") +
                (couponId != null ? "couponId=" + couponId + ", " : "") +
                (affiliateCommissionSettingId != null ? "affiliateCommissionSettingId=" + affiliateCommissionSettingId + ", " : "") +
                (mileageSettingId != null ? "mileageSettingId=" + mileageSettingId + ", " : "") +
                (totalBalanceTimeId != null ? "totalBalanceTimeId=" + totalBalanceTimeId + ", " : "") +
                (affiliateAdminId != null ? "affiliateAdminId=" + affiliateAdminId + ", " : "") +
            "}";
    }

}
