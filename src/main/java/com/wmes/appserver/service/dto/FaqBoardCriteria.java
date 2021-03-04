package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.FaqType;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.FaqBoard} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.FaqBoardResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /faq-boards?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class FaqBoardCriteria implements Serializable, Criteria {
    /**
     * Class for filtering FaqType
     */
    public static class FaqTypeFilter extends Filter<FaqType> {

        public FaqTypeFilter() {
        }

        public FaqTypeFilter(FaqTypeFilter filter) {
            super(filter);
        }

        @Override
        public FaqTypeFilter copy() {
            return new FaqTypeFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ZonedDateTimeFilter faqCreateDt;

    private ZonedDateTimeFilter faqUpdateDt;

    private FaqTypeFilter faqType;

    private LongFilter adminUserId;

    public FaqBoardCriteria(){
    }

    public FaqBoardCriteria(FaqBoardCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.faqCreateDt = other.faqCreateDt == null ? null : other.faqCreateDt.copy();
        this.faqUpdateDt = other.faqUpdateDt == null ? null : other.faqUpdateDt.copy();
        this.faqType = other.faqType == null ? null : other.faqType.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public FaqBoardCriteria copy() {
        return new FaqBoardCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ZonedDateTimeFilter getFaqCreateDt() {
        return faqCreateDt;
    }

    public void setFaqCreateDt(ZonedDateTimeFilter faqCreateDt) {
        this.faqCreateDt = faqCreateDt;
    }

    public ZonedDateTimeFilter getFaqUpdateDt() {
        return faqUpdateDt;
    }

    public void setFaqUpdateDt(ZonedDateTimeFilter faqUpdateDt) {
        this.faqUpdateDt = faqUpdateDt;
    }

    public FaqTypeFilter getFaqType() {
        return faqType;
    }

    public void setFaqType(FaqTypeFilter faqType) {
        this.faqType = faqType;
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
        final FaqBoardCriteria that = (FaqBoardCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(faqCreateDt, that.faqCreateDt) &&
            Objects.equals(faqUpdateDt, that.faqUpdateDt) &&
            Objects.equals(faqType, that.faqType) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        faqCreateDt,
        faqUpdateDt,
        faqType,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "FaqBoardCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (faqCreateDt != null ? "faqCreateDt=" + faqCreateDt + ", " : "") +
                (faqUpdateDt != null ? "faqUpdateDt=" + faqUpdateDt + ", " : "") +
                (faqType != null ? "faqType=" + faqType + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
