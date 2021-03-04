package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.BoardType;
import com.wmes.appserver.domain.enumeration.StateBoard;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Board} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.BoardResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /boards?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BoardCriteria implements Serializable, Criteria {
    /**
     * Class for filtering BoardType
     */
    public static class BoardTypeFilter extends Filter<BoardType> {

        public BoardTypeFilter() {
        }

        public BoardTypeFilter(BoardTypeFilter filter) {
            super(filter);
        }

        @Override
        public BoardTypeFilter copy() {
            return new BoardTypeFilter(this);
        }

    }
    /**
     * Class for filtering StateBoard
     */
    public static class StateBoardFilter extends Filter<StateBoard> {

        public StateBoardFilter() {
        }

        public StateBoardFilter(StateBoardFilter filter) {
            super(filter);
        }

        @Override
        public StateBoardFilter copy() {
            return new StateBoardFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter boardName;

    private BoardTypeFilter boardType;

    private IntegerFilter readLevel;

    private IntegerFilter writeLevel;

    private ZonedDateTimeFilter boardCreateDt;

    private ZonedDateTimeFilter boardUdpateDt;

    private StateBoardFilter borardState;

    private LongFilter boardAdminUserIdId;

    public BoardCriteria(){
    }

    public BoardCriteria(BoardCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.boardName = other.boardName == null ? null : other.boardName.copy();
        this.boardType = other.boardType == null ? null : other.boardType.copy();
        this.readLevel = other.readLevel == null ? null : other.readLevel.copy();
        this.writeLevel = other.writeLevel == null ? null : other.writeLevel.copy();
        this.boardCreateDt = other.boardCreateDt == null ? null : other.boardCreateDt.copy();
        this.boardUdpateDt = other.boardUdpateDt == null ? null : other.boardUdpateDt.copy();
        this.borardState = other.borardState == null ? null : other.borardState.copy();
        this.boardAdminUserIdId = other.boardAdminUserIdId == null ? null : other.boardAdminUserIdId.copy();
    }

    @Override
    public BoardCriteria copy() {
        return new BoardCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getBoardName() {
        return boardName;
    }

    public void setBoardName(StringFilter boardName) {
        this.boardName = boardName;
    }

    public BoardTypeFilter getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardTypeFilter boardType) {
        this.boardType = boardType;
    }

    public IntegerFilter getReadLevel() {
        return readLevel;
    }

    public void setReadLevel(IntegerFilter readLevel) {
        this.readLevel = readLevel;
    }

    public IntegerFilter getWriteLevel() {
        return writeLevel;
    }

    public void setWriteLevel(IntegerFilter writeLevel) {
        this.writeLevel = writeLevel;
    }

    public ZonedDateTimeFilter getBoardCreateDt() {
        return boardCreateDt;
    }

    public void setBoardCreateDt(ZonedDateTimeFilter boardCreateDt) {
        this.boardCreateDt = boardCreateDt;
    }

    public ZonedDateTimeFilter getBoardUdpateDt() {
        return boardUdpateDt;
    }

    public void setBoardUdpateDt(ZonedDateTimeFilter boardUdpateDt) {
        this.boardUdpateDt = boardUdpateDt;
    }

    public StateBoardFilter getBorardState() {
        return borardState;
    }

    public void setBorardState(StateBoardFilter borardState) {
        this.borardState = borardState;
    }

    public LongFilter getBoardAdminUserIdId() {
        return boardAdminUserIdId;
    }

    public void setBoardAdminUserIdId(LongFilter boardAdminUserIdId) {
        this.boardAdminUserIdId = boardAdminUserIdId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BoardCriteria that = (BoardCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(boardName, that.boardName) &&
            Objects.equals(boardType, that.boardType) &&
            Objects.equals(readLevel, that.readLevel) &&
            Objects.equals(writeLevel, that.writeLevel) &&
            Objects.equals(boardCreateDt, that.boardCreateDt) &&
            Objects.equals(boardUdpateDt, that.boardUdpateDt) &&
            Objects.equals(borardState, that.borardState) &&
            Objects.equals(boardAdminUserIdId, that.boardAdminUserIdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        boardName,
        boardType,
        readLevel,
        writeLevel,
        boardCreateDt,
        boardUdpateDt,
        borardState,
        boardAdminUserIdId
        );
    }

    @Override
    public String toString() {
        return "BoardCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (boardName != null ? "boardName=" + boardName + ", " : "") +
                (boardType != null ? "boardType=" + boardType + ", " : "") +
                (readLevel != null ? "readLevel=" + readLevel + ", " : "") +
                (writeLevel != null ? "writeLevel=" + writeLevel + ", " : "") +
                (boardCreateDt != null ? "boardCreateDt=" + boardCreateDt + ", " : "") +
                (boardUdpateDt != null ? "boardUdpateDt=" + boardUdpateDt + ", " : "") +
                (borardState != null ? "borardState=" + borardState + ", " : "") +
                (boardAdminUserIdId != null ? "boardAdminUserIdId=" + boardAdminUserIdId + ", " : "") +
            "}";
    }

}
