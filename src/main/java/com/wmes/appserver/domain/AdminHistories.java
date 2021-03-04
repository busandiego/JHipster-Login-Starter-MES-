package com.wmes.appserver.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.wmes.appserver.domain.enumeration.ActionType;

/**
 * A AdminHistories.
 */
@Entity
@Table(name = "admin_histories")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AdminHistories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type")
    private ActionType actionType;

    @NotNull
    @Column(name = "action_login_id", nullable = false)
    private String actionLoginId;

    @NotNull
    @Column(name = "action_num", nullable = false)
    private String actionNum;

    @NotNull
    @Column(name = "contents", nullable = false)
    private String contents;

    @NotNull
    @Column(name = "access_ip", nullable = false)
    private String accessIp;

    @NotNull
    @Column(name = "create_dt", nullable = false)
    private ZonedDateTime createDt;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public AdminHistories actionType(ActionType actionType) {
        this.actionType = actionType;
        return this;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getActionLoginId() {
        return actionLoginId;
    }

    public AdminHistories actionLoginId(String actionLoginId) {
        this.actionLoginId = actionLoginId;
        return this;
    }

    public void setActionLoginId(String actionLoginId) {
        this.actionLoginId = actionLoginId;
    }

    public String getActionNum() {
        return actionNum;
    }

    public AdminHistories actionNum(String actionNum) {
        this.actionNum = actionNum;
        return this;
    }

    public void setActionNum(String actionNum) {
        this.actionNum = actionNum;
    }

    public String getContents() {
        return contents;
    }

    public AdminHistories contents(String contents) {
        this.contents = contents;
        return this;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public AdminHistories accessIp(String accessIp) {
        this.accessIp = accessIp;
        return this;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    public ZonedDateTime getCreateDt() {
        return createDt;
    }

    public AdminHistories createDt(ZonedDateTime createDt) {
        this.createDt = createDt;
        return this;
    }

    public void setCreateDt(ZonedDateTime createDt) {
        this.createDt = createDt;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdminHistories)) {
            return false;
        }
        return id != null && id.equals(((AdminHistories) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "AdminHistories{" +
            "id=" + getId() +
            ", actionType='" + getActionType() + "'" +
            ", actionLoginId='" + getActionLoginId() + "'" +
            ", actionNum='" + getActionNum() + "'" +
            ", contents='" + getContents() + "'" +
            ", accessIp='" + getAccessIp() + "'" +
            ", createDt='" + getCreateDt() + "'" +
            "}";
    }
}
