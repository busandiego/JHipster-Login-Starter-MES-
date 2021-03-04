package com.wmes.appserver.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.wmes.appserver.domain.enumeration.StateCategory;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "create_dt")
    private ZonedDateTime createDt;

    @Column(name = "update_dt")
    private ZonedDateTime updateDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_state")
    private StateCategory categoryState;

    @ManyToOne
    @JsonIgnoreProperties("categories")
    private AdminUser adminUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCodeName() {
        return codeName;
    }

    public Category codeName(String codeName) {
        this.codeName = codeName;
        return this;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public ZonedDateTime getCreateDt() {
        return createDt;
    }

    public Category createDt(ZonedDateTime createDt) {
        this.createDt = createDt;
        return this;
    }

    public void setCreateDt(ZonedDateTime createDt) {
        this.createDt = createDt;
    }

    public ZonedDateTime getUpdateDt() {
        return updateDt;
    }

    public Category updateDt(ZonedDateTime updateDt) {
        this.updateDt = updateDt;
        return this;
    }

    public void setUpdateDt(ZonedDateTime updateDt) {
        this.updateDt = updateDt;
    }

    public StateCategory getCategoryState() {
        return categoryState;
    }

    public Category categoryState(StateCategory categoryState) {
        this.categoryState = categoryState;
        return this;
    }

    public void setCategoryState(StateCategory categoryState) {
        this.categoryState = categoryState;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public Category adminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
        return this;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", categoryName='" + getCategoryName() + "'" +
            ", codeName='" + getCodeName() + "'" +
            ", createDt='" + getCreateDt() + "'" +
            ", updateDt='" + getUpdateDt() + "'" +
            ", categoryState='" + getCategoryState() + "'" +
            "}";
    }
}
