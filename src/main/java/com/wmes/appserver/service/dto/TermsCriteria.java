package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.TermsType;
import com.wmes.appserver.domain.enumeration.TermsTarget;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Terms} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.TermsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /terms?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TermsCriteria implements Serializable, Criteria {
    /**
     * Class for filtering TermsType
     */
    public static class TermsTypeFilter extends Filter<TermsType> {

        public TermsTypeFilter() {
        }

        public TermsTypeFilter(TermsTypeFilter filter) {
            super(filter);
        }

        @Override
        public TermsTypeFilter copy() {
            return new TermsTypeFilter(this);
        }

    }
    /**
     * Class for filtering TermsTarget
     */
    public static class TermsTargetFilter extends Filter<TermsTarget> {

        public TermsTargetFilter() {
        }

        public TermsTargetFilter(TermsTargetFilter filter) {
            super(filter);
        }

        @Override
        public TermsTargetFilter copy() {
            return new TermsTargetFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private TermsTypeFilter termsType;

    private TermsTargetFilter termsTarget;

    private StringFilter termsFileName;

    private StringFilter termsPath;

    private ZonedDateTimeFilter termsCreateDt;

    private ZonedDateTimeFilter termsUpdateDt;

    private LongFilter adminUserId;

    public TermsCriteria(){
    }

    public TermsCriteria(TermsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.termsType = other.termsType == null ? null : other.termsType.copy();
        this.termsTarget = other.termsTarget == null ? null : other.termsTarget.copy();
        this.termsFileName = other.termsFileName == null ? null : other.termsFileName.copy();
        this.termsPath = other.termsPath == null ? null : other.termsPath.copy();
        this.termsCreateDt = other.termsCreateDt == null ? null : other.termsCreateDt.copy();
        this.termsUpdateDt = other.termsUpdateDt == null ? null : other.termsUpdateDt.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public TermsCriteria copy() {
        return new TermsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public TermsTypeFilter getTermsType() {
        return termsType;
    }

    public void setTermsType(TermsTypeFilter termsType) {
        this.termsType = termsType;
    }

    public TermsTargetFilter getTermsTarget() {
        return termsTarget;
    }

    public void setTermsTarget(TermsTargetFilter termsTarget) {
        this.termsTarget = termsTarget;
    }

    public StringFilter getTermsFileName() {
        return termsFileName;
    }

    public void setTermsFileName(StringFilter termsFileName) {
        this.termsFileName = termsFileName;
    }

    public StringFilter getTermsPath() {
        return termsPath;
    }

    public void setTermsPath(StringFilter termsPath) {
        this.termsPath = termsPath;
    }

    public ZonedDateTimeFilter getTermsCreateDt() {
        return termsCreateDt;
    }

    public void setTermsCreateDt(ZonedDateTimeFilter termsCreateDt) {
        this.termsCreateDt = termsCreateDt;
    }

    public ZonedDateTimeFilter getTermsUpdateDt() {
        return termsUpdateDt;
    }

    public void setTermsUpdateDt(ZonedDateTimeFilter termsUpdateDt) {
        this.termsUpdateDt = termsUpdateDt;
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
        final TermsCriteria that = (TermsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(termsType, that.termsType) &&
            Objects.equals(termsTarget, that.termsTarget) &&
            Objects.equals(termsFileName, that.termsFileName) &&
            Objects.equals(termsPath, that.termsPath) &&
            Objects.equals(termsCreateDt, that.termsCreateDt) &&
            Objects.equals(termsUpdateDt, that.termsUpdateDt) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        termsType,
        termsTarget,
        termsFileName,
        termsPath,
        termsCreateDt,
        termsUpdateDt,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "TermsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (termsType != null ? "termsType=" + termsType + ", " : "") +
                (termsTarget != null ? "termsTarget=" + termsTarget + ", " : "") +
                (termsFileName != null ? "termsFileName=" + termsFileName + ", " : "") +
                (termsPath != null ? "termsPath=" + termsPath + ", " : "") +
                (termsCreateDt != null ? "termsCreateDt=" + termsCreateDt + ", " : "") +
                (termsUpdateDt != null ? "termsUpdateDt=" + termsUpdateDt + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
