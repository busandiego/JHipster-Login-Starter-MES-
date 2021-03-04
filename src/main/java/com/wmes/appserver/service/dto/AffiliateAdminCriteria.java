package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateAffiliateAdmin;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.AffiliateAdmin} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.AffiliateAdminResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /affiliate-admins?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AffiliateAdminCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateAffiliateAdmin
     */
    public static class StateAffiliateAdminFilter extends Filter<StateAffiliateAdmin> {

        public StateAffiliateAdminFilter() {
        }

        public StateAffiliateAdminFilter(StateAffiliateAdminFilter filter) {
            super(filter);
        }

        @Override
        public StateAffiliateAdminFilter copy() {
            return new StateAffiliateAdminFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter affiliateAdminLoginId;

    private StringFilter affiliateAdminPassowrd;

    private StringFilter affiliateAdminEmail;

    private StringFilter pushToken;

    private ZonedDateTimeFilter createDt;

    private ZonedDateTimeFilter updateDt;

    private StateAffiliateAdminFilter affiliateAdminState;

    private LongFilter affiliateId;

    public AffiliateAdminCriteria(){
    }

    public AffiliateAdminCriteria(AffiliateAdminCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.affiliateAdminLoginId = other.affiliateAdminLoginId == null ? null : other.affiliateAdminLoginId.copy();
        this.affiliateAdminPassowrd = other.affiliateAdminPassowrd == null ? null : other.affiliateAdminPassowrd.copy();
        this.affiliateAdminEmail = other.affiliateAdminEmail == null ? null : other.affiliateAdminEmail.copy();
        this.pushToken = other.pushToken == null ? null : other.pushToken.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
        this.updateDt = other.updateDt == null ? null : other.updateDt.copy();
        this.affiliateAdminState = other.affiliateAdminState == null ? null : other.affiliateAdminState.copy();
        this.affiliateId = other.affiliateId == null ? null : other.affiliateId.copy();
    }

    @Override
    public AffiliateAdminCriteria copy() {
        return new AffiliateAdminCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getAffiliateAdminLoginId() {
        return affiliateAdminLoginId;
    }

    public void setAffiliateAdminLoginId(StringFilter affiliateAdminLoginId) {
        this.affiliateAdminLoginId = affiliateAdminLoginId;
    }

    public StringFilter getAffiliateAdminPassowrd() {
        return affiliateAdminPassowrd;
    }

    public void setAffiliateAdminPassowrd(StringFilter affiliateAdminPassowrd) {
        this.affiliateAdminPassowrd = affiliateAdminPassowrd;
    }

    public StringFilter getAffiliateAdminEmail() {
        return affiliateAdminEmail;
    }

    public void setAffiliateAdminEmail(StringFilter affiliateAdminEmail) {
        this.affiliateAdminEmail = affiliateAdminEmail;
    }

    public StringFilter getPushToken() {
        return pushToken;
    }

    public void setPushToken(StringFilter pushToken) {
        this.pushToken = pushToken;
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

    public StateAffiliateAdminFilter getAffiliateAdminState() {
        return affiliateAdminState;
    }

    public void setAffiliateAdminState(StateAffiliateAdminFilter affiliateAdminState) {
        this.affiliateAdminState = affiliateAdminState;
    }

    public LongFilter getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(LongFilter affiliateId) {
        this.affiliateId = affiliateId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AffiliateAdminCriteria that = (AffiliateAdminCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(affiliateAdminLoginId, that.affiliateAdminLoginId) &&
            Objects.equals(affiliateAdminPassowrd, that.affiliateAdminPassowrd) &&
            Objects.equals(affiliateAdminEmail, that.affiliateAdminEmail) &&
            Objects.equals(pushToken, that.pushToken) &&
            Objects.equals(createDt, that.createDt) &&
            Objects.equals(updateDt, that.updateDt) &&
            Objects.equals(affiliateAdminState, that.affiliateAdminState) &&
            Objects.equals(affiliateId, that.affiliateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        affiliateAdminLoginId,
        affiliateAdminPassowrd,
        affiliateAdminEmail,
        pushToken,
        createDt,
        updateDt,
        affiliateAdminState,
        affiliateId
        );
    }

    @Override
    public String toString() {
        return "AffiliateAdminCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (affiliateAdminLoginId != null ? "affiliateAdminLoginId=" + affiliateAdminLoginId + ", " : "") +
                (affiliateAdminPassowrd != null ? "affiliateAdminPassowrd=" + affiliateAdminPassowrd + ", " : "") +
                (affiliateAdminEmail != null ? "affiliateAdminEmail=" + affiliateAdminEmail + ", " : "") +
                (pushToken != null ? "pushToken=" + pushToken + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
                (updateDt != null ? "updateDt=" + updateDt + ", " : "") +
                (affiliateAdminState != null ? "affiliateAdminState=" + affiliateAdminState + ", " : "") +
                (affiliateId != null ? "affiliateId=" + affiliateId + ", " : "") +
            "}";
    }

}
