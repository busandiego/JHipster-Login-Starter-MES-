package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.AuthMember;
import com.wmes.appserver.domain.enumeration.StateMember;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.HoMember} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.HoMemberResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ho-members?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class HoMemberCriteria implements Serializable, Criteria {
    /**
     * Class for filtering AuthMember
     */
    public static class AuthMemberFilter extends Filter<AuthMember> {

        public AuthMemberFilter() {
        }

        public AuthMemberFilter(AuthMemberFilter filter) {
            super(filter);
        }

        @Override
        public AuthMemberFilter copy() {
            return new AuthMemberFilter(this);
        }

    }
    /**
     * Class for filtering StateMember
     */
    public static class StateMemberFilter extends Filter<StateMember> {

        public StateMemberFilter() {
        }

        public StateMemberFilter(StateMemberFilter filter) {
            super(filter);
        }

        @Override
        public StateMemberFilter copy() {
            return new StateMemberFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter memberLoginId;

    private StringFilter memberPassword;

    private StringFilter memberName;

    private StringFilter memberNum;

    private StringFilter memberEmail;

    private StringFilter memberUUId;

    private ZonedDateTimeFilter memberCreateDt;

    private ZonedDateTimeFilter memberUpdateDt;

    private StringFilter joinInflow;

    private StringFilter pushToken;

    private AuthMemberFilter memberAuth;

    private StateMemberFilter memberState;

    private LongFilter callAffiliateId;

    private LongFilter couponUseMemberId;

    private LongFilter reviewRoomId;

    private LongFilter customerInquiryId;

    public HoMemberCriteria(){
    }

    public HoMemberCriteria(HoMemberCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.memberLoginId = other.memberLoginId == null ? null : other.memberLoginId.copy();
        this.memberPassword = other.memberPassword == null ? null : other.memberPassword.copy();
        this.memberName = other.memberName == null ? null : other.memberName.copy();
        this.memberNum = other.memberNum == null ? null : other.memberNum.copy();
        this.memberEmail = other.memberEmail == null ? null : other.memberEmail.copy();
        this.memberUUId = other.memberUUId == null ? null : other.memberUUId.copy();
        this.memberCreateDt = other.memberCreateDt == null ? null : other.memberCreateDt.copy();
        this.memberUpdateDt = other.memberUpdateDt == null ? null : other.memberUpdateDt.copy();
        this.joinInflow = other.joinInflow == null ? null : other.joinInflow.copy();
        this.pushToken = other.pushToken == null ? null : other.pushToken.copy();
        this.memberAuth = other.memberAuth == null ? null : other.memberAuth.copy();
        this.memberState = other.memberState == null ? null : other.memberState.copy();
        this.callAffiliateId = other.callAffiliateId == null ? null : other.callAffiliateId.copy();
        this.couponUseMemberId = other.couponUseMemberId == null ? null : other.couponUseMemberId.copy();
        this.reviewRoomId = other.reviewRoomId == null ? null : other.reviewRoomId.copy();
        this.customerInquiryId = other.customerInquiryId == null ? null : other.customerInquiryId.copy();
    }

    @Override
    public HoMemberCriteria copy() {
        return new HoMemberCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getMemberLoginId() {
        return memberLoginId;
    }

    public void setMemberLoginId(StringFilter memberLoginId) {
        this.memberLoginId = memberLoginId;
    }

    public StringFilter getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(StringFilter memberPassword) {
        this.memberPassword = memberPassword;
    }

    public StringFilter getMemberName() {
        return memberName;
    }

    public void setMemberName(StringFilter memberName) {
        this.memberName = memberName;
    }

    public StringFilter getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(StringFilter memberNum) {
        this.memberNum = memberNum;
    }

    public StringFilter getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(StringFilter memberEmail) {
        this.memberEmail = memberEmail;
    }

    public StringFilter getMemberUUId() {
        return memberUUId;
    }

    public void setMemberUUId(StringFilter memberUUId) {
        this.memberUUId = memberUUId;
    }

    public ZonedDateTimeFilter getMemberCreateDt() {
        return memberCreateDt;
    }

    public void setMemberCreateDt(ZonedDateTimeFilter memberCreateDt) {
        this.memberCreateDt = memberCreateDt;
    }

    public ZonedDateTimeFilter getMemberUpdateDt() {
        return memberUpdateDt;
    }

    public void setMemberUpdateDt(ZonedDateTimeFilter memberUpdateDt) {
        this.memberUpdateDt = memberUpdateDt;
    }

    public StringFilter getJoinInflow() {
        return joinInflow;
    }

    public void setJoinInflow(StringFilter joinInflow) {
        this.joinInflow = joinInflow;
    }

    public StringFilter getPushToken() {
        return pushToken;
    }

    public void setPushToken(StringFilter pushToken) {
        this.pushToken = pushToken;
    }

    public AuthMemberFilter getMemberAuth() {
        return memberAuth;
    }

    public void setMemberAuth(AuthMemberFilter memberAuth) {
        this.memberAuth = memberAuth;
    }

    public StateMemberFilter getMemberState() {
        return memberState;
    }

    public void setMemberState(StateMemberFilter memberState) {
        this.memberState = memberState;
    }

    public LongFilter getCallAffiliateId() {
        return callAffiliateId;
    }

    public void setCallAffiliateId(LongFilter callAffiliateId) {
        this.callAffiliateId = callAffiliateId;
    }

    public LongFilter getCouponUseMemberId() {
        return couponUseMemberId;
    }

    public void setCouponUseMemberId(LongFilter couponUseMemberId) {
        this.couponUseMemberId = couponUseMemberId;
    }

    public LongFilter getReviewRoomId() {
        return reviewRoomId;
    }

    public void setReviewRoomId(LongFilter reviewRoomId) {
        this.reviewRoomId = reviewRoomId;
    }

    public LongFilter getCustomerInquiryId() {
        return customerInquiryId;
    }

    public void setCustomerInquiryId(LongFilter customerInquiryId) {
        this.customerInquiryId = customerInquiryId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final HoMemberCriteria that = (HoMemberCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(memberLoginId, that.memberLoginId) &&
            Objects.equals(memberPassword, that.memberPassword) &&
            Objects.equals(memberName, that.memberName) &&
            Objects.equals(memberNum, that.memberNum) &&
            Objects.equals(memberEmail, that.memberEmail) &&
            Objects.equals(memberUUId, that.memberUUId) &&
            Objects.equals(memberCreateDt, that.memberCreateDt) &&
            Objects.equals(memberUpdateDt, that.memberUpdateDt) &&
            Objects.equals(joinInflow, that.joinInflow) &&
            Objects.equals(pushToken, that.pushToken) &&
            Objects.equals(memberAuth, that.memberAuth) &&
            Objects.equals(memberState, that.memberState) &&
            Objects.equals(callAffiliateId, that.callAffiliateId) &&
            Objects.equals(couponUseMemberId, that.couponUseMemberId) &&
            Objects.equals(reviewRoomId, that.reviewRoomId) &&
            Objects.equals(customerInquiryId, that.customerInquiryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        memberLoginId,
        memberPassword,
        memberName,
        memberNum,
        memberEmail,
        memberUUId,
        memberCreateDt,
        memberUpdateDt,
        joinInflow,
        pushToken,
        memberAuth,
        memberState,
        callAffiliateId,
        couponUseMemberId,
        reviewRoomId,
        customerInquiryId
        );
    }

    @Override
    public String toString() {
        return "HoMemberCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (memberLoginId != null ? "memberLoginId=" + memberLoginId + ", " : "") +
                (memberPassword != null ? "memberPassword=" + memberPassword + ", " : "") +
                (memberName != null ? "memberName=" + memberName + ", " : "") +
                (memberNum != null ? "memberNum=" + memberNum + ", " : "") +
                (memberEmail != null ? "memberEmail=" + memberEmail + ", " : "") +
                (memberUUId != null ? "memberUUId=" + memberUUId + ", " : "") +
                (memberCreateDt != null ? "memberCreateDt=" + memberCreateDt + ", " : "") +
                (memberUpdateDt != null ? "memberUpdateDt=" + memberUpdateDt + ", " : "") +
                (joinInflow != null ? "joinInflow=" + joinInflow + ", " : "") +
                (pushToken != null ? "pushToken=" + pushToken + ", " : "") +
                (memberAuth != null ? "memberAuth=" + memberAuth + ", " : "") +
                (memberState != null ? "memberState=" + memberState + ", " : "") +
                (callAffiliateId != null ? "callAffiliateId=" + callAffiliateId + ", " : "") +
                (couponUseMemberId != null ? "couponUseMemberId=" + couponUseMemberId + ", " : "") +
                (reviewRoomId != null ? "reviewRoomId=" + reviewRoomId + ", " : "") +
                (customerInquiryId != null ? "customerInquiryId=" + customerInquiryId + ", " : "") +
            "}";
    }

}
