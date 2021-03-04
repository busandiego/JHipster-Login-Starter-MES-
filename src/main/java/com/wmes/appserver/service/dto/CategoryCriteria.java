package com.wmes.appserver.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.wmes.appserver.domain.enumeration.StateCategory;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.wmes.appserver.domain.Category} entity. This class is used
 * in {@link com.wmes.appserver.web.rest.CategoryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /categories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CategoryCriteria implements Serializable, Criteria {
    /**
     * Class for filtering StateCategory
     */
    public static class StateCategoryFilter extends Filter<StateCategory> {

        public StateCategoryFilter() {
        }

        public StateCategoryFilter(StateCategoryFilter filter) {
            super(filter);
        }

        @Override
        public StateCategoryFilter copy() {
            return new StateCategoryFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter categoryName;

    private StringFilter codeName;

    private ZonedDateTimeFilter createDt;

    private ZonedDateTimeFilter updateDt;

    private StateCategoryFilter categoryState;

    private LongFilter adminUserId;

    public CategoryCriteria(){
    }

    public CategoryCriteria(CategoryCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.categoryName = other.categoryName == null ? null : other.categoryName.copy();
        this.codeName = other.codeName == null ? null : other.codeName.copy();
        this.createDt = other.createDt == null ? null : other.createDt.copy();
        this.updateDt = other.updateDt == null ? null : other.updateDt.copy();
        this.categoryState = other.categoryState == null ? null : other.categoryState.copy();
        this.adminUserId = other.adminUserId == null ? null : other.adminUserId.copy();
    }

    @Override
    public CategoryCriteria copy() {
        return new CategoryCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(StringFilter categoryName) {
        this.categoryName = categoryName;
    }

    public StringFilter getCodeName() {
        return codeName;
    }

    public void setCodeName(StringFilter codeName) {
        this.codeName = codeName;
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

    public StateCategoryFilter getCategoryState() {
        return categoryState;
    }

    public void setCategoryState(StateCategoryFilter categoryState) {
        this.categoryState = categoryState;
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
        final CategoryCriteria that = (CategoryCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(categoryName, that.categoryName) &&
            Objects.equals(codeName, that.codeName) &&
            Objects.equals(createDt, that.createDt) &&
            Objects.equals(updateDt, that.updateDt) &&
            Objects.equals(categoryState, that.categoryState) &&
            Objects.equals(adminUserId, that.adminUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        categoryName,
        codeName,
        createDt,
        updateDt,
        categoryState,
        adminUserId
        );
    }

    @Override
    public String toString() {
        return "CategoryCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (categoryName != null ? "categoryName=" + categoryName + ", " : "") +
                (codeName != null ? "codeName=" + codeName + ", " : "") +
                (createDt != null ? "createDt=" + createDt + ", " : "") +
                (updateDt != null ? "updateDt=" + updateDt + ", " : "") +
                (categoryState != null ? "categoryState=" + categoryState + ", " : "") +
                (adminUserId != null ? "adminUserId=" + adminUserId + ", " : "") +
            "}";
    }

}
