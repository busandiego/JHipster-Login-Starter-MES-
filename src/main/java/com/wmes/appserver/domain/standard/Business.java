package com.wmes.appserver.domain.standard;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A Business.
 */
@Entity
@Table(name = "business")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "business_name", nullable = false)
    private String businessName;

    @NotNull
    @Column(name = "business_representative", nullable = false)
    private String businessRepresentative;

    @Column(name = "business_registration_num")
    private String businessRegistrationNum;

    @Column(name = "business_contact_num")
    private String businessContactNum;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "business_address")
    private String businessAddress;

    @Column(name = "business_category")
    private String businessCategory;

    @Column(name = "business_fax_num")
    private String businessFaxNum;

    @Column(name = "is_headquarter")
    private Boolean isHeadquarter;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public Business businessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessRepresentative() {
        return businessRepresentative;
    }

    public Business businessRepresentative(String businessRepresentative) {
        this.businessRepresentative = businessRepresentative;
        return this;
    }

    public void setBusinessRepresentative(String businessRepresentative) {
        this.businessRepresentative = businessRepresentative;
    }

    public String getBusinessRegistrationNum() {
        return businessRegistrationNum;
    }

    public Business businessRegistrationNum(String businessRegistrationNum) {
        this.businessRegistrationNum = businessRegistrationNum;
        return this;
    }

    public void setBusinessRegistrationNum(String businessRegistrationNum) {
        this.businessRegistrationNum = businessRegistrationNum;
    }

    public String getBusinessContactNum() {
        return businessContactNum;
    }

    public Business businessContactNum(String businessContactNum) {
        this.businessContactNum = businessContactNum;
        return this;
    }

    public void setBusinessContactNum(String businessContactNum) {
        this.businessContactNum = businessContactNum;
    }

    public String getBusinessType() {
        return businessType;
    }

    public Business businessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public Business businessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
        return this;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public Business businessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
        return this;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getBusinessFaxNum() {
        return businessFaxNum;
    }

    public Business businessFaxNum(String businessFaxNum) {
        this.businessFaxNum = businessFaxNum;
        return this;
    }

    public void setBusinessFaxNum(String businessFaxNum) {
        this.businessFaxNum = businessFaxNum;
    }

    public Boolean isIsHeadquarter() {
        return isHeadquarter;
    }

    public Business isHeadquarter(Boolean isHeadquarter) {
        this.isHeadquarter = isHeadquarter;
        return this;
    }

    public void setIsHeadquarter(Boolean isHeadquarter) {
        this.isHeadquarter = isHeadquarter;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public Business createdDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Business)) {
            return false;
        }
        return id != null && id.equals(((Business) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Business{" +
            "id=" + getId() +
            ", businessName='" + getBusinessName() + "'" +
            ", businessRepresentative='" + getBusinessRepresentative() + "'" +
            ", businessRegistrationNum='" + getBusinessRegistrationNum() + "'" +
            ", businessContactNum='" + getBusinessContactNum() + "'" +
            ", businessType='" + getBusinessType() + "'" +
            ", businessAddress='" + getBusinessAddress() + "'" +
            ", businessCategory='" + getBusinessCategory() + "'" +
            ", businessFaxNum='" + getBusinessFaxNum() + "'" +
            ", isHeadquarter='" + isIsHeadquarter() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            "}";
    }
}
