package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateBalance;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.TotalBalanceByAffiliate} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.TotalBalanceByAffiliateResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /total-balance-by-affiliates?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TotalBalanceByAffiliateCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateBalance
     */
    public static class StateBalanceFilter extends Filter<StateBalance> {

        public StateBalanceFilter() {
        }

        public StateBalanceFilter(StateBalanceFilter filter) {
            super(filter);
        }

        @Override
        public StateBalanceFilter copy() {
            return new StateBalanceFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter affiliateName;

    private StringFilter affiliateAccountHolder;

    private StringFilter affiliateBank;

    private StringFilter affiliateAccount;

    private IntegerFilter balanceNum;

    private IntegerFilter totalMoney;

    private IntegerFilter commission;

    private IntegerFilter balanceMoney;

    private ZonedDateTimeFilter balanceDt;

    private StateBalanceFilter balanceState;

    private LongFilter balanceByAffiliateDetailsId;

    public TotalBalanceByAffiliateCriteria(){
    }

    public TotalBalanceByAffiliateCriteria(TotalBalanceByAffiliateCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.affiliateName = other.affiliateName == null ? null : other.affiliateName.copy();
        this.affiliateAccountHolder = other.affiliateAccountHolder == null ? null : other.affiliateAccountHolder.copy();
        this.affiliateBank = other.affiliateBank == null ? null : other.affiliateBank.copy();
        this.affiliateAccount = other.affiliateAccount == null ? null : other.affiliateAccount.copy();
        this.balanceNum = other.balanceNum == null ? null : other.balanceNum.copy();
        this.totalMoney = other.totalMoney == null ? null : other.totalMoney.copy();
        this.commission = other.commission == null ? null : other.commission.copy();
        this.balanceMoney = other.balanceMoney == null ? null : other.balanceMoney.copy();
        this.balanceDt = other.balanceDt == null ? null : other.balanceDt.copy();
        this.balanceState = other.balanceState == null ? null : other.balanceState.copy();
        this.balanceByAffiliateDetailsId = other.balanceByAffiliateDetailsId == null ? null : other.balanceByAffiliateDetailsId.copy();
    }

    @Override
    public TotalBalanceByAffiliateCriteria copy() {
        return new TotalBalanceByAffiliateCriteria(this);
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

    public StringFilter getAffiliateAccountHolder() {
        return affiliateAccountHolder;
    }

    public void setAffiliateAccountHolder(StringFilter affiliateAccountHolder) {
        this.affiliateAccountHolder = affiliateAccountHolder;
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

    public IntegerFilter getBalanceNum() {
        return balanceNum;
    }

    public void setBalanceNum(IntegerFilter balanceNum) {
        this.balanceNum = balanceNum;
    }

    public IntegerFilter getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(IntegerFilter totalMoney) {
        this.totalMoney = totalMoney;
    }

    public IntegerFilter getCommission() {
        return commission;
    }

    public void setCommission(IntegerFilter commission) {
        this.commission = commission;
    }

    public IntegerFilter getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(IntegerFilter balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    public ZonedDateTimeFilter getBalanceDt() {
        return balanceDt;
    }

    public void setBalanceDt(ZonedDateTimeFilter balanceDt) {
        this.balanceDt = balanceDt;
    }

    public StateBalanceFilter getBalanceState() {
        return balanceState;
    }

    public void setBalanceState(StateBalanceFilter balanceState) {
        this.balanceState = balanceState;
    }

    public LongFilter getBalanceByAffiliateDetailsId() {
        return balanceByAffiliateDetailsId;
    }

    public void setBalanceByAffiliateDetailsId(LongFilter balanceByAffiliateDetailsId) {
        this.balanceByAffiliateDetailsId = balanceByAffiliateDetailsId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TotalBalanceByAffiliateCriteria that = (TotalBalanceByAffiliateCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(affiliateName, that.affiliateName) &&
            Objects.equals(affiliateAccountHolder, that.affiliateAccountHolder) &&
            Objects.equals(affiliateBank, that.affiliateBank) &&
            Objects.equals(affiliateAccount, that.affiliateAccount) &&
            Objects.equals(balanceNum, that.balanceNum) &&
            Objects.equals(totalMoney, that.totalMoney) &&
            Objects.equals(commission, that.commission) &&
            Objects.equals(balanceMoney, that.balanceMoney) &&
            Objects.equals(balanceDt, that.balanceDt) &&
            Objects.equals(balanceState, that.balanceState) &&
            Objects.equals(balanceByAffiliateDetailsId, that.balanceByAffiliateDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        affiliateName,
        affiliateAccountHolder,
        affiliateBank,
        affiliateAccount,
        balanceNum,
        totalMoney,
        commission,
        balanceMoney,
        balanceDt,
        balanceState,
        balanceByAffiliateDetailsId
        );
    }

    @Override
    public String toString() {
        return "TotalBalanceByAffiliateCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (affiliateName != null ? "affiliateName=" + affiliateName + ", " : "") +
                (affiliateAccountHolder != null ? "affiliateAccountHolder=" + affiliateAccountHolder + ", " : "") +
                (affiliateBank != null ? "affiliateBank=" + affiliateBank + ", " : "") +
                (affiliateAccount != null ? "affiliateAccount=" + affiliateAccount + ", " : "") +
                (balanceNum != null ? "balanceNum=" + balanceNum + ", " : "") +
                (totalMoney != null ? "totalMoney=" + totalMoney + ", " : "") +
                (commission != null ? "commission=" + commission + ", " : "") +
                (balanceMoney != null ? "balanceMoney=" + balanceMoney + ", " : "") +
                (balanceDt != null ? "balanceDt=" + balanceDt + ", " : "") +
                (balanceState != null ? "balanceState=" + balanceState + ", " : "") +
                (balanceByAffiliateDetailsId != null ? "balanceByAffiliateDetailsId=" + balanceByAffiliateDetailsId + ", " : "") +
            "}";
    }

}
