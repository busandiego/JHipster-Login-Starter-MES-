package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.InquiryType;
import com.wmes.appserver.domain.enumeration.StateInquiry;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.CustomerInquiry} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.CustomerInquiryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /customer-inquiries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CustomerInquiryCriteria implements Serializable, Criteria {
    /**
     * Class for filtering InquiryType
     */
    public static class InquiryTypeFilter extends Filter<InquiryType> {

        public InquiryTypeFilter() {
        }

        public InquiryTypeFilter(InquiryTypeFilter filter) {
            super(filter);
        }

        @Override
        public InquiryTypeFilter copy() {
            return new InquiryTypeFilter(this);
        }

    }
    /**
     * Class for filtering StateInquiry
     */
    public static class StateInquiryFilter extends Filter<StateInquiry> {

        public StateInquiryFilter() {
        }

        public StateInquiryFilter(StateInquiryFilter filter) {
            super(filter);
        }

        @Override
        public StateInquiryFilter copy() {
            return new StateInquiryFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InquiryTypeFilter inquiryType;

    private StringFilter inquiryTitle;

    private StringFilter inquiryContents;

    private ZonedDateTimeFilter inquiryCreateDt;

    private StateInquiryFilter inquiryState;

    private BooleanFilter answerCheck;

    private LongFilter inquiryAnswerId;

    private LongFilter hoMemberId;

    public CustomerInquiryCriteria(){
    }

    public CustomerInquiryCriteria(CustomerInquiryCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.inquiryType = other.inquiryType == null ? null : other.inquiryType.copy();
        this.inquiryTitle = other.inquiryTitle == null ? null : other.inquiryTitle.copy();
        this.inquiryContents = other.inquiryContents == null ? null : other.inquiryContents.copy();
        this.inquiryCreateDt = other.inquiryCreateDt == null ? null : other.inquiryCreateDt.copy();
        this.inquiryState = other.inquiryState == null ? null : other.inquiryState.copy();
        this.answerCheck = other.answerCheck == null ? null : other.answerCheck.copy();
        this.inquiryAnswerId = other.inquiryAnswerId == null ? null : other.inquiryAnswerId.copy();
        this.hoMemberId = other.hoMemberId == null ? null : other.hoMemberId.copy();
    }

    @Override
    public CustomerInquiryCriteria copy() {
        return new CustomerInquiryCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public InquiryTypeFilter getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(InquiryTypeFilter inquiryType) {
        this.inquiryType = inquiryType;
    }

    public StringFilter getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(StringFilter inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public StringFilter getInquiryContents() {
        return inquiryContents;
    }

    public void setInquiryContents(StringFilter inquiryContents) {
        this.inquiryContents = inquiryContents;
    }

    public ZonedDateTimeFilter getInquiryCreateDt() {
        return inquiryCreateDt;
    }

    public void setInquiryCreateDt(ZonedDateTimeFilter inquiryCreateDt) {
        this.inquiryCreateDt = inquiryCreateDt;
    }

    public StateInquiryFilter getInquiryState() {
        return inquiryState;
    }

    public void setInquiryState(StateInquiryFilter inquiryState) {
        this.inquiryState = inquiryState;
    }

    public BooleanFilter getAnswerCheck() {
        return answerCheck;
    }

    public void setAnswerCheck(BooleanFilter answerCheck) {
        this.answerCheck = answerCheck;
    }

    public LongFilter getInquiryAnswerId() {
        return inquiryAnswerId;
    }

    public void setInquiryAnswerId(LongFilter inquiryAnswerId) {
        this.inquiryAnswerId = inquiryAnswerId;
    }

    public LongFilter getHoMemberId() {
        return hoMemberId;
    }

    public void setHoMemberId(LongFilter hoMemberId) {
        this.hoMemberId = hoMemberId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CustomerInquiryCriteria that = (CustomerInquiryCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(inquiryType, that.inquiryType) &&
            Objects.equals(inquiryTitle, that.inquiryTitle) &&
            Objects.equals(inquiryContents, that.inquiryContents) &&
            Objects.equals(inquiryCreateDt, that.inquiryCreateDt) &&
            Objects.equals(inquiryState, that.inquiryState) &&
            Objects.equals(answerCheck, that.answerCheck) &&
            Objects.equals(inquiryAnswerId, that.inquiryAnswerId) &&
            Objects.equals(hoMemberId, that.hoMemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        inquiryType,
        inquiryTitle,
        inquiryContents,
        inquiryCreateDt,
        inquiryState,
        answerCheck,
        inquiryAnswerId,
        hoMemberId
        );
    }

    @Override
    public String toString() {
        return "CustomerInquiryCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (inquiryType != null ? "inquiryType=" + inquiryType + ", " : "") +
                (inquiryTitle != null ? "inquiryTitle=" + inquiryTitle + ", " : "") +
                (inquiryContents != null ? "inquiryContents=" + inquiryContents + ", " : "") +
                (inquiryCreateDt != null ? "inquiryCreateDt=" + inquiryCreateDt + ", " : "") +
                (inquiryState != null ? "inquiryState=" + inquiryState + ", " : "") +
                (answerCheck != null ? "answerCheck=" + answerCheck + ", " : "") +
                (inquiryAnswerId != null ? "inquiryAnswerId=" + inquiryAnswerId + ", " : "") +
                (hoMemberId != null ? "hoMemberId=" + hoMemberId + ", " : "") +
            "}";
    }

}
