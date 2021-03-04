package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.BoardDetails} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.BoardDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /board-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BoardDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter headCategory;

    private StringFilter title;

    private ZonedDateTimeFilter createDt;

    private ZonedDateTimeFilter updateDt;

    private IntegerFilter likeNum;

    private IntegerFilter dislikeNum;

    private LongFilter boardFileId;

    private LongFilter commentId;

    private LongFilter writeUserIdId;

    public BoardDetailsCriteria(){
    }

    public BoardDetailsCriteria(BoardDetailsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.headCategory = other.headCategory == null ? null : other.headCategory.copy();
        this.title = other.title == null ? null : other.title.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
        this.updateDt = other.updateDt == null ? null : other.updateDt.copy();
        this.likeNum = other.likeNum == null ? null : other.likeNum.copy();
        this.dislikeNum = other.dislikeNum == null ? null : other.dislikeNum.copy();
        this.boardFileId = other.boardFileId == null ? null : other.boardFileId.copy();
        this.commentId = other.commentId == null ? null : other.commentId.copy();
        this.writeUserIdId = other.writeUserIdId == null ? null : other.writeUserIdId.copy();
    }

    @Override
    public BoardDetailsCriteria copy() {
        return new BoardDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getHeadCategory() {
        return headCategory;
    }

    public void setHeadCategory(StringFilter headCategory) {
        this.headCategory = headCategory;
    }

    public StringFilter getTitle() {
        return title;
    }

    public void setTitle(StringFilter title) {
        this.title = title;
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

    public IntegerFilter getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(IntegerFilter likeNum) {
        this.likeNum = likeNum;
    }

    public IntegerFilter getDislikeNum() {
        return dislikeNum;
    }

    public void setDislikeNum(IntegerFilter dislikeNum) {
        this.dislikeNum = dislikeNum;
    }

    public LongFilter getBoardFileId() {
        return boardFileId;
    }

    public void setBoardFileId(LongFilter boardFileId) {
        this.boardFileId = boardFileId;
    }

    public LongFilter getCommentId() {
        return commentId;
    }

    public void setCommentId(LongFilter commentId) {
        this.commentId = commentId;
    }

    public LongFilter getWriteUserIdId() {
        return writeUserIdId;
    }

    public void setWriteUserIdId(LongFilter writeUserIdId) {
        this.writeUserIdId = writeUserIdId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BoardDetailsCriteria that = (BoardDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(headCategory, that.headCategory) &&
            Objects.equals(title, that.title) &&
            Objects.equals(createDt, that.createDt) &&
            Objects.equals(updateDt, that.updateDt) &&
            Objects.equals(likeNum, that.likeNum) &&
            Objects.equals(dislikeNum, that.dislikeNum) &&
            Objects.equals(boardFileId, that.boardFileId) &&
            Objects.equals(commentId, that.commentId) &&
            Objects.equals(writeUserIdId, that.writeUserIdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        headCategory,
        title,
        createDt,
        updateDt,
        likeNum,
        dislikeNum,
        boardFileId,
        commentId,
        writeUserIdId
        );
    }

    @Override
    public String toString() {
        return "BoardDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (headCategory != null ? "headCategory=" + headCategory + ", " : "") +
                (title != null ? "title=" + title + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
                (updateDt != null ? "updateDt=" + updateDt + ", " : "") +
                (likeNum != null ? "likeNum=" + likeNum + ", " : "") +
                (dislikeNum != null ? "dislikeNum=" + dislikeNum + ", " : "") +
                (boardFileId != null ? "boardFileId=" + boardFileId + ", " : "") +
                (commentId != null ? "commentId=" + commentId + ", " : "") +
                (writeUserIdId != null ? "writeUserIdId=" + writeUserIdId + ", " : "") +
            "}";
    }

}
