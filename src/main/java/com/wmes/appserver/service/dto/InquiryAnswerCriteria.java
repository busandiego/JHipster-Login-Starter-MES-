package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateAnswer;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.InquiryAnswer} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.InquiryAnswerResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /inquiry-answers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InquiryAnswerCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateAnswer
     */
    public static class StateAnswerFilter extends Filter<StateAnswer> {

        public StateAnswerFilter() {
        }

        public StateAnswerFilter(StateAnswerFilter filter) {
            super(filter);
        }

        @Override
        public StateAnswerFilter copy() {
            return new StateAnswerFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter inquiryAnswerTitle;

    private StringFilter inquiryAnswerContents;

    private ZonedDateTimeFilter inquiryAnswerCreateDt;

    private StateAnswerFilter inquiryAnswerState;

    private LongFilter customerInquiryId;

    private LongFilter adminUserId;

    public InquiryAnswerCriteria(){
    }

    public InquiryAnswerCriteria(InquiryAnswerCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.inquiryAnswerTitle = other.inquiryAnswerTitle == null ? null : other.inquiryAnswerTitle.copy();
        this.inquiryAnswerContents = other.inquiryAnswerContents == null ? null : other.inquiryAnswerContents.copy();
        this.inquiryAnswerCreateDt = other.inquiryAnswerCreateDt == null ? null : other.inquiryAnswerCreateDt.copy();
        this.inquiryAnswerState = other.inquiryAnswerState == null ? null : other.inquiryAnswerState.copy();
        this.customerInquiryId = other.customerInquiryId == null ? null : other.customerInquiryId.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public InquiryAnswerCriteria copy() {
        return new InquiryAnswerCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getInquiryAnswerTitle() {
        return inquiryAnswerTitle;
    }

    public void setInquiryAnswerTitle(StringFilter inquiryAnswerTitle) {
        this.inquiryAnswerTitle = inquiryAnswerTitle;
    }

    public StringFilter getInquiryAnswerContents() {
        return inquiryAnswerContents;
    }

    public void setInquiryAnswerContents(StringFilter inquiryAnswerContents) {
        this.inquiryAnswerContents = inquiryAnswerContents;
    }

    public ZonedDateTimeFilter getInquiryAnswerCreateDt() {
        return inquiryAnswerCreateDt;
    }

    public void setInquiryAnswerCreateDt(ZonedDateTimeFilter inquiryAnswerCreateDt) {
        this.inquiryAnswerCreateDt = inquiryAnswerCreateDt;
    }

    public StateAnswerFilter getInquiryAnswerState() {
        return inquiryAnswerState;
    }

    public void setInquiryAnswerState(StateAnswerFilter inquiryAnswerState) {
        this.inquiryAnswerState = inquiryAnswerState;
    }

    public LongFilter getCustomerInquiryId() {
        return customerInquiryId;
    }

    public void setCustomerInquiryId(LongFilter customerInquiryId) {
        this.customerInquiryId = customerInquiryId;
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
        final InquiryAnswerCriteria that = (InquiryAnswerCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(inquiryAnswerTitle, that.inquiryAnswerTitle) &&
            Objects.equals(inquiryAnswerContents, that.inquiryAnswerContents) &&
            Objects.equals(inquiryAnswerCreateDt, that.inquiryAnswerCreateDt) &&
            Objects.equals(inquiryAnswerState, that.inquiryAnswerState) &&
            Objects.equals(customerInquiryId, that.customerInquiryId) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        inquiryAnswerTitle,
        inquiryAnswerContents,
        inquiryAnswerCreateDt,
        inquiryAnswerState,
        customerInquiryId,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "InquiryAnswerCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (inquiryAnswerTitle != null ? "inquiryAnswerTitle=" + inquiryAnswerTitle + ", " : "") +
                (inquiryAnswerContents != null ? "inquiryAnswerContents=" + inquiryAnswerContents + ", " : "") +
                (inquiryAnswerCreateDt != null ? "inquiryAnswerCreateDt=" + inquiryAnswerCreateDt + ", " : "") +
                (inquiryAnswerState != null ? "inquiryAnswerState=" + inquiryAnswerState + ", " : "") +
                (customerInquiryId != null ? "customerInquiryId=" + customerInquiryId + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
