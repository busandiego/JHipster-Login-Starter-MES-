package com.wmes.appserver.service.dto;

import com.wmes.appserver.domain.enumeration.RoomSalesType;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.RoomSellInfo} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.RoomSellInfoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /room-sell-infos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RoomSellInfoCriteria implements Serializable, Criteria {
    /**
     * Class for filtering RoomSalesType
     */
    public static class RoomSalesTypeFilter extends Filter<RoomSalesType> {

        public RoomSalesTypeFilter() {
        }

        public RoomSalesTypeFilter(RoomSalesTypeFilter filter) {
            super(filter);
        }

        @Override
        public RoomSalesTypeFilter copy() {
            return new RoomSalesTypeFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private RoomSalesTypeFilter roomSalesType;

    private LongFilter roomId;

    public RoomSellInfoCriteria(){
    }

    public RoomSellInfoCriteria(RoomSellInfoCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.roomSalesType = other.roomSalesType == null ? null : other.roomSalesType.copy();
        this.roomId = other.roomId == null ? null : other.roomId.copy();
    }

    @Override
    public RoomSellInfoCriteria copy() {
        return new RoomSellInfoCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public RoomSalesTypeFilter getRoomSalesType() {
        return roomSalesType;
    }

    public void setRoomSalesType(RoomSalesTypeFilter roomSalesType) {
        this.roomSalesType = roomSalesType;
    }

    public LongFilter getRoomId() {
        return roomId;
    }

    public void setRoomId(LongFilter roomId) {
        this.roomId = roomId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RoomSellInfoCriteria that = (RoomSellInfoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(roomSalesType, that.roomSalesType) &&
            Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        roomSalesType,
        roomId
        );
    }

    @Override
    public String toString() {
        return "RoomSellInfoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (roomSalesType != null ? "roomSalesType=" + roomSalesType + ", " : "") +
                (roomId != null ? "roomId=" + roomId + ", " : "") +
            "}";
    }

}
