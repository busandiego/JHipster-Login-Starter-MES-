package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateInflow;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.InflowPath} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.InflowPathResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /inflow-paths?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InflowPathCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateInflow
     */
    public static class StateInflowFilter extends Filter<StateInflow> {

        public StateInflowFilter() {
        }

        public StateInflowFilter(StateInflowFilter filter) {
            super(filter);
        }

        @Override
        public StateInflowFilter copy() {
            return new StateInflowFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter inflowPathName;

    private StringFilter codeName;

    private ZonedDateTimeFilter createDt;

    private ZonedDateTimeFilter updateDt;

    private StateInflowFilter inflowPathState;

    private LongFilter adminUserId;

    public InflowPathCriteria(){
    }

    public InflowPathCriteria(InflowPathCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.inflowPathName = other.inflowPathName == null ? null : other.inflowPathName.copy();
        this.codeName = other.codeName == null ? null : other.codeName.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
        this.updateDt = other.updateDt == null ? null : other.updateDt.copy();
        this.inflowPathState = other.inflowPathState == null ? null : other.inflowPathState.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public InflowPathCriteria copy() {
        return new InflowPathCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getInflowPathName() {
        return inflowPathName;
    }

    public void setInflowPathName(StringFilter inflowPathName) {
        this.inflowPathName = inflowPathName;
    }

    public StringFilter getCodeName() {
        return codeName;
    }

    public void setCodeName(StringFilter codeName) {
        this.codeName = codeName;
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

    public StateInflowFilter getInflowPathState() {
        return inflowPathState;
    }

    public void setInflowPathState(StateInflowFilter inflowPathState) {
        this.inflowPathState = inflowPathState;
    }

    public LongFilter getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(LongFilter adminUserId) {
        this.adminUserId = adminUserId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InflowPathCriteria that = (InflowPathCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(inflowPathName, that.inflowPathName) &&
            Objects.equals(codeName, that.codeName) &&
            Objects.equals(createDt, that.createDt) &&
            Objects.equals(updateDt, that.updateDt) &&
            Objects.equals(inflowPathState, that.inflowPathState) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        inflowPathName,
        codeName,
        createDt,
        updateDt,
        inflowPathState,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "InflowPathCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (inflowPathName != null ? "inflowPathName=" + inflowPathName + ", " : "") +
                (codeName != null ? "codeName=" + codeName + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
                (updateDt != null ? "updateDt=" + updateDt + ", " : "") +
                (inflowPathState != null ? "inflowPathState=" + inflowPathState + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
