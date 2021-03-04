package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Comment} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.CommentResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /comments?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CommentCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter contents;

    private ZonedDateTimeFilter createDt;

    private ZonedDateTimeFilter updateDt;

    private LongFilter commentForCommentId;

    private LongFilter boardDetailsId;

    public CommentCriteria(){
    }

    public CommentCriteria(CommentCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.contents = other.contents == null ? null : other.contents.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
        this.updateDt = other.updateDt == null ? null : other.updateDt.copy();
        this.commentForCommentId = other.commentForCommentId == null ? null : other.commentForCommentId.copy();
        this.boardDetailsId = other.boardDetailsId == null ? null : other.boardDetailsId.copy();
    }

    @Override
    public CommentCriteria copy() {
        return new CommentCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getContents() {
        return contents;
    }

    public void setContents(StringFilter contents) {
        this.contents = contents;
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


    public LongFilter getBoardDetailsId() {
        return boardDetailsId;
    }

    public void setBoardDetailsId(LongFilter boardDetailsId) {
        this.boardDetailsId = boardDetailsId;
    }

    public LongFilter getCommentForCommentId() {
        return commentForCommentId;
    }

    public void setCommentForCommentId(LongFilter commentForCommentId) {
        this.commentForCommentId = commentForCommentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CommentCriteria that = (CommentCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(contents, that.contents) &&
            Objects.equals(createDt, that.createDt) &&
            Objects.equals(updateDt, that.updateDt) &&
            Objects.equals(commentForCommentId, that.commentForCommentId) &&
            Objects.equals(boardDetailsId, that.boardDetailsId) &&
            Objects.equals(commentForCommentId, that.commentForCommentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        contents,
        createDt,
        updateDt,
        commentForCommentId,
        boardDetailsId,
        commentForCommentId
        );
    }

    @Override
    public String toString() {
        return "CommentCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (contents != null ? "contents=" + contents + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
                (updateDt != null ? "updateDt=" + updateDt + ", " : "") +
                (commentForCommentId != null ? "commentForCommentId=" + commentForCommentId + ", " : "") +
                (boardDetailsId != null ? "boardDetailsId=" + boardDetailsId + ", " : "") +
                (commentForCommentId != null ? "commentForCommentId=" + commentForCommentId + ", " : "") +
            "}";
    }

}
