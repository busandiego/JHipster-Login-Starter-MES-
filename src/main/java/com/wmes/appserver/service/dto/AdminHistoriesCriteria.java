package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.ActionType;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.AdminHistories} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.AdminHistoriesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /admin-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AdminHistoriesCriteria implements Serializable, Criteria {
    /**
     * Class for filtering ActionType
     */
    public static class ActionTypeFilter extends Filter<ActionType> {

        public ActionTypeFilter() {
        }

        public ActionTypeFilter(ActionTypeFilter filter) {
            super(filter);
        }

        @Override
        public ActionTypeFilter copy() {
            return new ActionTypeFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ActionTypeFilter actionType;

    private StringFilter actionLoginId;

    private StringFilter actionNum;

    private StringFilter contents;

    private StringFilter accessIp;

    private ZonedDateTimeFilter createDt;

    public AdminHistoriesCriteria(){
    }

    public AdminHistoriesCriteria(AdminHistoriesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.actionType = other.actionType == null ? null : other.actionType.copy();
        this.actionLoginId = other.actionLoginId == null ? null : other.actionLoginId.copy();
        this.actionNum = other.actionNum == null ? null : other.actionNum.copy();
        this.contents = other.contents == null ? null : other.contents.copy();
        this.accessIp = other.accessIp == null ? null : other.accessIp.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
    }

    @Override
    public AdminHistoriesCriteria copy() {
        return new AdminHistoriesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ActionTypeFilter getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeFilter actionType) {
        this.actionType = actionType;
    }

    public StringFilter getActionLoginId() {
        return actionLoginId;
    }

    public void setActionLoginId(StringFilter actionLoginId) {
        this.actionLoginId = actionLoginId;
    }

    public StringFilter getActionNum() {
        return actionNum;
    }

    public void setActionNum(StringFilter actionNum) {
        this.actionNum = actionNum;
    }

    public StringFilter getContents() {
        return contents;
    }

    public void setContents(StringFilter contents) {
        this.contents = contents;
    }

    public StringFilter getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(StringFilter accessIp) {
        this.accessIp = accessIp;
    }

    public ZonedDateTimeFilter getCreateDt() {
        return createDt;
    }

    public void setCreateDt(ZonedDateTimeFilter createDt) {
        this.createDt = createDt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AdminHistoriesCriteria that = (AdminHistoriesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(actionType, that.actionType) &&
            Objects.equals(actionLoginId, that.actionLoginId) &&
            Objects.equals(actionNum, that.actionNum) &&
            Objects.equals(contents, that.contents) &&
            Objects.equals(accessIp, that.accessIp) &&
            Objects.equals(createDt, that.createDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        actionType,
        actionLoginId,
        actionNum,
        contents,
        accessIp,
        createDt
        );
    }

    @Override
    public String toString() {
        return "AdminHistoriesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (actionType != null ? "actionType=" + actionType + ", " : "") +
                (actionLoginId != null ? "actionLoginId=" + actionLoginId + ", " : "") +
                (actionNum != null ? "actionNum=" + actionNum + ", " : "") +
                (contents != null ? "contents=" + contents + ", " : "") +
                (accessIp != null ? "accessIp=" + accessIp + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
            "}";
    }

}
