package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.ManagerAccountState;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.ManagerAccount} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ManagerAccountResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /manager-accounts?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ManagerAccountCriteria implements Serializable, Criteria {
    /**
     * Class for filtering ManagerAccountState
     */
    public static class ManagerAccountStateFilter extends Filter<ManagerAccountState> {

        public ManagerAccountStateFilter() {
        }

        public ManagerAccountStateFilter(ManagerAccountStateFilter filter) {
            super(filter);
        }

        @Override
        public ManagerAccountStateFilter copy() {
            return new ManagerAccountStateFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter managerAccountNum;

    private StringFilter managerAccountBank;

    private StringFilter managerAccountOnwer;

    private ZonedDateTimeFilter managerAccountApplyDt;

    private ZonedDateTimeFilter managerAccountDecideDt;

    private ManagerAccountStateFilter managerAccountState;

    private LongFilter managerId;

    public ManagerAccountCriteria(){
    }

    public ManagerAccountCriteria(ManagerAccountCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.managerAccountNum = other.managerAccountNum == null ? null : other.managerAccountNum.copy();
        this.managerAccountBank = other.managerAccountBank == null ? null : other.managerAccountBank.copy();
        this.managerAccountOnwer = other.managerAccountOnwer == null ? null : other.managerAccountOnwer.copy();
        this.managerAccountApplyDt = other.managerAccountApplyDt == null ? null : other.managerAccountApplyDt.copy();
        this.managerAccountDecideDt = other.managerAccountDecideDt == null ? null : other.managerAccountDecideDt.copy();
        this.managerAccountState = other.managerAccountState == null ? null : other.managerAccountState.copy();
        this.managerId = other.managerId == null ? null : other.managerId.copy();
    }

    @Override
    public ManagerAccountCriteria copy() {
        return new ManagerAccountCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getManagerAccountNum() {
        return managerAccountNum;
    }

    public void setManagerAccountNum(StringFilter managerAccountNum) {
        this.managerAccountNum = managerAccountNum;
    }

    public StringFilter getManagerAccountBank() {
        return managerAccountBank;
    }

    public void setManagerAccountBank(StringFilter managerAccountBank) {
        this.managerAccountBank = managerAccountBank;
    }

    public StringFilter getManagerAccountOnwer() {
        return managerAccountOnwer;
    }

    public void setManagerAccountOnwer(StringFilter managerAccountOnwer) {
        this.managerAccountOnwer = managerAccountOnwer;
    }

    public ZonedDateTimeFilter getManagerAccountApplyDt() {
        return managerAccountApplyDt;
    }

    public void setManagerAccountApplyDt(ZonedDateTimeFilter managerAccountApplyDt) {
        this.managerAccountApplyDt = managerAccountApplyDt;
    }

    public ZonedDateTimeFilter getManagerAccountDecideDt() {
        return managerAccountDecideDt;
    }

    public void setManagerAccountDecideDt(ZonedDateTimeFilter managerAccountDecideDt) {
        this.managerAccountDecideDt = managerAccountDecideDt;
    }

    public ManagerAccountStateFilter getManagerAccountState() {
        return managerAccountState;
    }

    public void setManagerAccountState(ManagerAccountStateFilter managerAccountState) {
        this.managerAccountState = managerAccountState;
    }

    public LongFilter getManagerId() {
        return managerId;
    }

    public void setManagerId(LongFilter managerId) {
        this.managerId = managerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ManagerAccountCriteria that = (ManagerAccountCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(managerAccountNum, that.managerAccountNum) &&
            Objects.equals(managerAccountBank, that.managerAccountBank) &&
            Objects.equals(managerAccountOnwer, that.managerAccountOnwer) &&
            Objects.equals(managerAccountApplyDt, that.managerAccountApplyDt) &&
            Objects.equals(managerAccountDecideDt, that.managerAccountDecideDt) &&
            Objects.equals(managerAccountState, that.managerAccountState) &&
            Objects.equals(managerId, that.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        managerAccountNum,
        managerAccountBank,
        managerAccountOnwer,
        managerAccountApplyDt,
        managerAccountDecideDt,
        managerAccountState,
        managerId
        );
    }

    @Override
    public String toString() {
        return "ManagerAccountCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (managerAccountNum != null ? "managerAccountNum=" + managerAccountNum + ", " : "") +
                (managerAccountBank != null ? "managerAccountBank=" + managerAccountBank + ", " : "") +
                (managerAccountOnwer != null ? "managerAccountOnwer=" + managerAccountOnwer + ", " : "") +
                (managerAccountApplyDt != null ? "managerAccountApplyDt=" + managerAccountApplyDt + ", " : "") +
                (managerAccountDecideDt != null ? "managerAccountDecideDt=" + managerAccountDecideDt + ", " : "") +
                (managerAccountState != null ? "managerAccountState=" + managerAccountState + ", " : "") +
                (managerId != null ? "managerId=" + managerId + ", " : "") +
            "}";
    }

}
