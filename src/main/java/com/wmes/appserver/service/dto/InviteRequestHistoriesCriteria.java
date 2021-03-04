package com.wmes.appserver.service.dto;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.InvitePublishHistories} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.InvitePublishHistoriesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /invite-publish-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InviteRequestHistoriesCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter responseAddress;

    private BooleanFilter publishedCheck;

    private ZonedDateTimeFilter publishedDt;

    private LongFilter adminUserId;

    public InviteRequestHistoriesCriteria(){
    }

    public InviteRequestHistoriesCriteria(InviteRequestHistoriesCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.responseAddress = other.responseAddress == null ? null : other.responseAddress.copy();
        this.publishedCheck = other.publishedCheck == null ? null : other.publishedCheck.copy();
        this.publishedDt = other.publishedDt == null ? null : other.publishedDt.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public InviteRequestHistoriesCriteria copy() {
        return new InviteRequestHistoriesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getResponseAddress() {
        return responseAddress;
    }

    public void setResponseAddress(StringFilter responseAddress) {
        this.responseAddress = responseAddress;
    }

    public BooleanFilter getPublishedCheck() {
        return publishedCheck;
    }

    public void setPublishedCheck(BooleanFilter publishedCheck) {
        this.publishedCheck = publishedCheck;
    }

    public ZonedDateTimeFilter getPublishedDt() {
        return publishedDt;
    }

    public void setPublishedDt(ZonedDateTimeFilter publishedDt) {
        this.publishedDt = publishedDt;
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
        final InviteRequestHistoriesCriteria that = (InviteRequestHistoriesCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(responseAddress, that.responseAddress) &&
            Objects.equals(publishedCheck, that.publishedCheck) &&
            Objects.equals(publishedDt, that.publishedDt) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        responseAddress,
        publishedCheck,
        publishedDt,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "InvitePublishHistoriesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (responseAddress != null ? "responseAddress=" + responseAddress + ", " : "") +
                (publishedCheck != null ? "publishedCheck=" + publishedCheck + ", " : "") +
                (publishedDt != null ? "publishedDt=" + publishedDt + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
