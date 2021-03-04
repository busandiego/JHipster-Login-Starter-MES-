package com.wmes.appserver.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.wmes.appserver.domain.enumeration.StateInflow;

/**
 * A InflowPath.
 */
@Entity
@Table(name = "inflow_path")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InflowPath implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inflow_path_name")
    private String inflowPathName;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "create_dt")
    private ZonedDateTime createDt;

    @Column(name = "update_dt")
    private ZonedDateTime updateDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "inflow_path_state")
    private StateInflow inflowPathState;

    @ManyToOne
    @JsonIgnoreProperties("inflowPaths")
    private AdminUser adminUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInflowPathName() {
        return inflowPathName;
    }

    public InflowPath inflowPathName(String inflowPathName) {
        this.inflowPathName = inflowPathName;
        return this;
    }

    public void setInflowPathName(String inflowPathName) {
        this.inflowPathName = inflowPathName;
    }

    public String getCodeName() {
        return codeName;
    }

    public InflowPath codeName(String codeName) {
        this.codeName = codeName;
        return this;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public ZonedDateTime getCreateDt() {
        return createDt;
    }

    public InflowPath createDt(ZonedDateTime createDt) {
        this.createDt = createDt;
        return this;
    }

    public void setCreateDt(ZonedDateTime createDt) {
        this.createDt = createDt;
    }

    public ZonedDateTime getUpdateDt() {
        return updateDt;
    }

    public InflowPath updateDt(ZonedDateTime updateDt) {
        this.updateDt = updateDt;
        return this;
    }

    public void setUpdateDt(ZonedDateTime updateDt) {
        this.updateDt = updateDt;
    }

    public StateInflow getInflowPathState() {
        return inflowPathState;
    }

    public InflowPath inflowPathState(StateInflow inflowPathState) {
        this.inflowPathState = inflowPathState;
        return this;
    }

    public void setInflowPathState(StateInflow inflowPathState) {
        this.inflowPathState = inflowPathState;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public InflowPath adminUser(AdminUser adminUser) {
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
        if (!(o instanceof InflowPath)) {
            return false;
        }
        return id != null && id.equals(((InflowPath) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "InflowPath{" +
            "id=" + getId() +
            ", inflowPathName='" + getInflowPathName() + "'" +
            ", codeName='" + getCodeName() + "'" +
            ", createDt='" + getCreateDt() + "'" +
            ", updateDt='" + getUpdateDt() + "'" +
            ", inflowPathState='" + getInflowPathState() + "'" +
            "}";
    }
}
