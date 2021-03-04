package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.EventTarget;
import com.wmes.appserver.domain.enumeration.StateEvent;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.HoEvent} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.HoEventResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ho-events?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class HoEventCriteria implements Serializable, Criteria {
    /**
     * Class for filtering EventTarget
     */
    public static class EventTargetFilter extends Filter<EventTarget> {

        public EventTargetFilter() {
        }

        public EventTargetFilter(EventTargetFilter filter) {
            super(filter);
        }

        @Override
        public EventTargetFilter copy() {
            return new EventTargetFilter(this);
        }

    }
    /**
     * Class for filtering StateEvent
     */
    public static class StateEventFilter extends Filter<StateEvent> {

        public StateEventFilter() {
        }

        public StateEventFilter(StateEventFilter filter) {
            super(filter);
        }

        @Override
        public StateEventFilter copy() {
            return new StateEventFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter eventName;

    private StringFilter eventPageUrl;

    private EventTargetFilter eventTarget;

    private ZonedDateTimeFilter eventStartDt;

    private ZonedDateTimeFilter eventEndDt;

    private ZonedDateTimeFilter eventCreateDt;

    private ZonedDateTimeFilter eventUpdateDt;

    private StateEventFilter eventState;

    private LongFilter hoEventImagesId;

    private LongFilter adminUserId;

    public HoEventCriteria(){
    }

    public HoEventCriteria(HoEventCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.eventName = other.eventName == null ? null : other.eventName.copy();
        this.eventPageUrl = other.eventPageUrl == null ? null : other.eventPageUrl.copy();
        this.eventTarget = other.eventTarget == null ? null : other.eventTarget.copy();
        this.eventStartDt = other.eventStartDt == null ? null : other.eventStartDt.copy();
        this.eventEndDt = other.eventEndDt == null ? null : other.eventEndDt.copy();
        this.eventCreateDt = other.eventCreateDt == null ? null : other.eventCreateDt.copy();
        this.eventUpdateDt = other.eventUpdateDt == null ? null : other.eventUpdateDt.copy();
        this.eventState = other.eventState == null ? null : other.eventState.copy();
        this.hoEventImagesId = other.hoEventImagesId == null ? null : other.hoEventImagesId.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public HoEventCriteria copy() {
        return new HoEventCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getEventName() {
        return eventName;
    }

    public void setEventName(StringFilter eventName) {
        this.eventName = eventName;
    }

    public StringFilter getEventPageUrl() {
        return eventPageUrl;
    }

    public void setEventPageUrl(StringFilter eventPageUrl) {
        this.eventPageUrl = eventPageUrl;
    }

    public EventTargetFilter getEventTarget() {
        return eventTarget;
    }

    public void setEventTarget(EventTargetFilter eventTarget) {
        this.eventTarget = eventTarget;
    }

    public ZonedDateTimeFilter getEventStartDt() {
        return eventStartDt;
    }

    public void setEventStartDt(ZonedDateTimeFilter eventStartDt) {
        this.eventStartDt = eventStartDt;
    }

    public ZonedDateTimeFilter getEventEndDt() {
        return eventEndDt;
    }

    public void setEventEndDt(ZonedDateTimeFilter eventEndDt) {
        this.eventEndDt = eventEndDt;
    }

    public ZonedDateTimeFilter getEventCreateDt() {
        return eventCreateDt;
    }

    public void setEventCreateDt(ZonedDateTimeFilter eventCreateDt) {
        this.eventCreateDt = eventCreateDt;
    }

    public ZonedDateTimeFilter getEventUpdateDt() {
        return eventUpdateDt;
    }

    public void setEventUpdateDt(ZonedDateTimeFilter eventUpdateDt) {
        this.eventUpdateDt = eventUpdateDt;
    }

    public StateEventFilter getEventState() {
        return eventState;
    }

    public void setEventState(StateEventFilter eventState) {
        this.eventState = eventState;
    }

    public LongFilter getHoEventImagesId() {
        return hoEventImagesId;
    }

    public void setHoEventImagesId(LongFilter hoEventImagesId) {
        this.hoEventImagesId = hoEventImagesId;
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
        final HoEventCriteria that = (HoEventCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(eventName, that.eventName) &&
            Objects.equals(eventPageUrl, that.eventPageUrl) &&
            Objects.equals(eventTarget, that.eventTarget) &&
            Objects.equals(eventStartDt, that.eventStartDt) &&
            Objects.equals(eventEndDt, that.eventEndDt) &&
            Objects.equals(eventCreateDt, that.eventCreateDt) &&
            Objects.equals(eventUpdateDt, that.eventUpdateDt) &&
            Objects.equals(eventState, that.eventState) &&
            Objects.equals(hoEventImagesId, that.hoEventImagesId) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        eventName,
        eventPageUrl,
        eventTarget,
        eventStartDt,
        eventEndDt,
        eventCreateDt,
        eventUpdateDt,
        eventState,
        hoEventImagesId,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "HoEventCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (eventName != null ? "eventName=" + eventName + ", " : "") +
                (eventPageUrl != null ? "eventPageUrl=" + eventPageUrl + ", " : "") +
                (eventTarget != null ? "eventTarget=" + eventTarget + ", " : "") +
                (eventStartDt != null ? "eventStartDt=" + eventStartDt + ", " : "") +
                (eventEndDt != null ? "eventEndDt=" + eventEndDt + ", " : "") +
                (eventCreateDt != null ? "eventCreateDt=" + eventCreateDt + ", " : "") +
                (eventUpdateDt != null ? "eventUpdateDt=" + eventUpdateDt + ", " : "") +
                (eventState != null ? "eventState=" + eventState + ", " : "") +
                (hoEventImagesId != null ? "hoEventImagesId=" + hoEventImagesId + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
