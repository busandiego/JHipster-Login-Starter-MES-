package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateWork;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.ManagerWorkHistories} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.ManagerWorkHistoriesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /manager-work-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ManagerWorkHistoriesCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateWork
     */
    public static class StateWorkFilter extends Filter<StateWork> {

        public StateWorkFilter() {
        }

        public StateWorkFilter(StateWorkFilter filter) {
            super(filter);
        }

        @Override
        public StateWorkFilter copy() {
            return new StateWorkFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ZonedDateTimeFilter joinDt;

    private ZonedDateTimeFilter resignationDt;

    private StateWorkFilter workState;

    private LongFilter affiliateId;

    private LongFilter managerId;

    public ManagerWorkHistoriesCriteria(){
    }

    public ManagerWorkHistoriesCriteria(ManagerWorkHistoriesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.joinDt = other.joinDt == null ? null : other.joinDt.copy();
        this.resignationDt = other.resignationDt == null ? null : other.resignationDt.copy();
        this.workState = other.workState == null ? null : other.workState.copy();
        this.affiliateId = other.affiliateId == null ? null : other.affiliateId.copy();
        this.managerId = other.managerId == null ? null : other.managerId.copy();
    }

    @Override
    public ManagerWorkHistoriesCriteria copy() {
        return new ManagerWorkHistoriesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ZonedDateTimeFilter getJoinDt() {
        return joinDt;
    }

    public void setJoinDt(ZonedDateTimeFilter joinDt) {
        this.joinDt = joinDt;
    }

    public ZonedDateTimeFilter getResignationDt() {
        return resignationDt;
    }

    public void setResignationDt(ZonedDateTimeFilter resignationDt) {
        this.resignationDt = resignationDt;
    }

    public StateWorkFilter getWorkState() {
        return workState;
    }

    public void setWorkState(StateWorkFilter workState) {
        this.workState = workState;
    }

    public LongFilter getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(LongFilter affiliateId) {
        this.affiliateId = affiliateId;
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
        final ManagerWorkHistoriesCriteria that = (ManagerWorkHistoriesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(joinDt, that.joinDt) &&
            Objects.equals(resignationDt, that.resignationDt) &&
            Objects.equals(workState, that.workState) &&
            Objects.equals(affiliateId, that.affiliateId) &&
            Objects.equals(managerId, that.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        joinDt,
        resignationDt,
        workState,
        affiliateId,
        managerId
        );
    }

    @Override
    public String toString() {
        return "ManagerWorkHistoriesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (joinDt != null ? "joinDt=" + joinDt + ", " : "") +
                (resignationDt != null ? "resignationDt=" + resignationDt + ", " : "") +
                (workState != null ? "workState=" + workState + ", " : "") +
                (affiliateId != null ? "affiliateId=" + affiliateId + ", " : "") +
                (managerId != null ? "managerId=" + managerId + ", " : "") +
            "}";
    }

}
