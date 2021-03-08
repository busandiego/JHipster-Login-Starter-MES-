package com.wmes.appserver.web.rest;

import com.wmes.appserver.WmesServerApp;
import com.wmes.appserver.domain.Business;
import com.wmes.appserver.repository.BusinessRepository;
import com.wmes.appserver.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.wmes.appserver.web.rest.TestUtil.sameInstant;
import static com.wmes.appserver.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link BusinessResource} REST controller.
 */
@SpringBootTest(classes = WmesServerApp.class)
public class BusinessResourceIT {

    private static final String DEFAULT_BUSINESS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_REPRESENTATIVE = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_REPRESENTATIVE = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_REGISTRATION_NUM = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_REGISTRATION_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_CONTACT_NUM = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_CONTACT_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_BUSINESS_FAX_NUM = "AAAAAAAAAA";
    private static final String UPDATED_BUSINESS_FAX_NUM = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_HEADQUARTER = false;
    private static final Boolean UPDATED_IS_HEADQUARTER = true;

    private static final ZonedDateTime DEFAULT_CREATED_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restBusinessMockMvc;

    private Business business;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BusinessResource businessResource = new BusinessResource(businessRepository);
        this.restBusinessMockMvc = MockMvcBuilders.standaloneSetup(businessResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Business createEntity(EntityManager em) {
        Business business = new Business()
            .businessName(DEFAULT_BUSINESS_NAME)
            .businessRepresentative(DEFAULT_BUSINESS_REPRESENTATIVE)
            .businessRegistrationNum(DEFAULT_BUSINESS_REGISTRATION_NUM)
            .businessContactNum(DEFAULT_BUSINESS_CONTACT_NUM)
            .businessType(DEFAULT_BUSINESS_TYPE)
            .businessAddress(DEFAULT_BUSINESS_ADDRESS)
            .businessCategory(DEFAULT_BUSINESS_CATEGORY)
            .businessFaxNum(DEFAULT_BUSINESS_FAX_NUM)
            .isHeadquarter(DEFAULT_IS_HEADQUARTER)
            .createdDate(DEFAULT_CREATED_DATE);
        return business;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Business createUpdatedEntity(EntityManager em) {
        Business business = new Business()
            .businessName(UPDATED_BUSINESS_NAME)
            .businessRepresentative(UPDATED_BUSINESS_REPRESENTATIVE)
            .businessRegistrationNum(UPDATED_BUSINESS_REGISTRATION_NUM)
            .businessContactNum(UPDATED_BUSINESS_CONTACT_NUM)
            .businessType(UPDATED_BUSINESS_TYPE)
            .businessAddress(UPDATED_BUSINESS_ADDRESS)
            .businessCategory(UPDATED_BUSINESS_CATEGORY)
            .businessFaxNum(UPDATED_BUSINESS_FAX_NUM)
            .isHeadquarter(UPDATED_IS_HEADQUARTER)
            .createdDate(UPDATED_CREATED_DATE);
        return business;
    }

    @BeforeEach
    public void initTest() {
        business = createEntity(em);
    }

    @Test
    @Transactional
    public void createBusiness() throws Exception {
        int databaseSizeBeforeCreate = businessRepository.findAll().size();

        // Create the Business
        restBusinessMockMvc.perform(post("/api/businesses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(business)))
            .andExpect(status().isCreated());

        // Validate the Business in the database
        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeCreate + 1);
        Business testBusiness = businessList.get(businessList.size() - 1);
        assertThat(testBusiness.getBusinessName()).isEqualTo(DEFAULT_BUSINESS_NAME);
        assertThat(testBusiness.getBusinessRepresentative()).isEqualTo(DEFAULT_BUSINESS_REPRESENTATIVE);
        assertThat(testBusiness.getBusinessRegistrationNum()).isEqualTo(DEFAULT_BUSINESS_REGISTRATION_NUM);
        assertThat(testBusiness.getBusinessContactNum()).isEqualTo(DEFAULT_BUSINESS_CONTACT_NUM);
        assertThat(testBusiness.getBusinessType()).isEqualTo(DEFAULT_BUSINESS_TYPE);
        assertThat(testBusiness.getBusinessAddress()).isEqualTo(DEFAULT_BUSINESS_ADDRESS);
        assertThat(testBusiness.getBusinessCategory()).isEqualTo(DEFAULT_BUSINESS_CATEGORY);
        assertThat(testBusiness.getBusinessFaxNum()).isEqualTo(DEFAULT_BUSINESS_FAX_NUM);
        assertThat(testBusiness.isIsHeadquarter()).isEqualTo(DEFAULT_IS_HEADQUARTER);
        assertThat(testBusiness.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
    }

    @Test
    @Transactional
    public void createBusinessWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = businessRepository.findAll().size();

        // Create the Business with an existing ID
        business.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBusinessMockMvc.perform(post("/api/businesses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(business)))
            .andExpect(status().isBadRequest());

        // Validate the Business in the database
        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkBusinessNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = businessRepository.findAll().size();
        // set the field null
        business.setBusinessName(null);

        // Create the Business, which fails.

        restBusinessMockMvc.perform(post("/api/businesses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(business)))
            .andExpect(status().isBadRequest());

        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkBusinessRepresentativeIsRequired() throws Exception {
        int databaseSizeBeforeTest = businessRepository.findAll().size();
        // set the field null
        business.setBusinessRepresentative(null);

        // Create the Business, which fails.

        restBusinessMockMvc.perform(post("/api/businesses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(business)))
            .andExpect(status().isBadRequest());

        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBusinesses() throws Exception {
        // Initialize the database
        businessRepository.saveAndFlush(business);

        // Get all the businessList
        restBusinessMockMvc.perform(get("/api/businesses?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(business.getId().intValue())))
            .andExpect(jsonPath("$.[*].businessName").value(hasItem(DEFAULT_BUSINESS_NAME)))
            .andExpect(jsonPath("$.[*].businessRepresentative").value(hasItem(DEFAULT_BUSINESS_REPRESENTATIVE)))
            .andExpect(jsonPath("$.[*].businessRegistrationNum").value(hasItem(DEFAULT_BUSINESS_REGISTRATION_NUM)))
            .andExpect(jsonPath("$.[*].businessContactNum").value(hasItem(DEFAULT_BUSINESS_CONTACT_NUM)))
            .andExpect(jsonPath("$.[*].businessType").value(hasItem(DEFAULT_BUSINESS_TYPE)))
            .andExpect(jsonPath("$.[*].businessAddress").value(hasItem(DEFAULT_BUSINESS_ADDRESS)))
            .andExpect(jsonPath("$.[*].businessCategory").value(hasItem(DEFAULT_BUSINESS_CATEGORY)))
            .andExpect(jsonPath("$.[*].businessFaxNum").value(hasItem(DEFAULT_BUSINESS_FAX_NUM)))
            .andExpect(jsonPath("$.[*].isHeadquarter").value(hasItem(DEFAULT_IS_HEADQUARTER.booleanValue())))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(sameInstant(DEFAULT_CREATED_DATE))));
    }
    
    @Test
    @Transactional
    public void getBusiness() throws Exception {
        // Initialize the database
        businessRepository.saveAndFlush(business);

        // Get the business
        restBusinessMockMvc.perform(get("/api/businesses/{id}", business.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(business.getId().intValue()))
            .andExpect(jsonPath("$.businessName").value(DEFAULT_BUSINESS_NAME))
            .andExpect(jsonPath("$.businessRepresentative").value(DEFAULT_BUSINESS_REPRESENTATIVE))
            .andExpect(jsonPath("$.businessRegistrationNum").value(DEFAULT_BUSINESS_REGISTRATION_NUM))
            .andExpect(jsonPath("$.businessContactNum").value(DEFAULT_BUSINESS_CONTACT_NUM))
            .andExpect(jsonPath("$.businessType").value(DEFAULT_BUSINESS_TYPE))
            .andExpect(jsonPath("$.businessAddress").value(DEFAULT_BUSINESS_ADDRESS))
            .andExpect(jsonPath("$.businessCategory").value(DEFAULT_BUSINESS_CATEGORY))
            .andExpect(jsonPath("$.businessFaxNum").value(DEFAULT_BUSINESS_FAX_NUM))
            .andExpect(jsonPath("$.isHeadquarter").value(DEFAULT_IS_HEADQUARTER.booleanValue()))
            .andExpect(jsonPath("$.createdDate").value(sameInstant(DEFAULT_CREATED_DATE)));
    }

    @Test
    @Transactional
    public void getNonExistingBusiness() throws Exception {
        // Get the business
        restBusinessMockMvc.perform(get("/api/businesses/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBusiness() throws Exception {
        // Initialize the database
        businessRepository.saveAndFlush(business);

        int databaseSizeBeforeUpdate = businessRepository.findAll().size();

        // Update the business
        Business updatedBusiness = businessRepository.findById(business.getId()).get();
        // Disconnect from session so that the updates on updatedBusiness are not directly saved in db
        em.detach(updatedBusiness);
        updatedBusiness
            .businessName(UPDATED_BUSINESS_NAME)
            .businessRepresentative(UPDATED_BUSINESS_REPRESENTATIVE)
            .businessRegistrationNum(UPDATED_BUSINESS_REGISTRATION_NUM)
            .businessContactNum(UPDATED_BUSINESS_CONTACT_NUM)
            .businessType(UPDATED_BUSINESS_TYPE)
            .businessAddress(UPDATED_BUSINESS_ADDRESS)
            .businessCategory(UPDATED_BUSINESS_CATEGORY)
            .businessFaxNum(UPDATED_BUSINESS_FAX_NUM)
            .isHeadquarter(UPDATED_IS_HEADQUARTER)
            .createdDate(UPDATED_CREATED_DATE);

        restBusinessMockMvc.perform(put("/api/businesses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedBusiness)))
            .andExpect(status().isOk());

        // Validate the Business in the database
        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeUpdate);
        Business testBusiness = businessList.get(businessList.size() - 1);
        assertThat(testBusiness.getBusinessName()).isEqualTo(UPDATED_BUSINESS_NAME);
        assertThat(testBusiness.getBusinessRepresentative()).isEqualTo(UPDATED_BUSINESS_REPRESENTATIVE);
        assertThat(testBusiness.getBusinessRegistrationNum()).isEqualTo(UPDATED_BUSINESS_REGISTRATION_NUM);
        assertThat(testBusiness.getBusinessContactNum()).isEqualTo(UPDATED_BUSINESS_CONTACT_NUM);
        assertThat(testBusiness.getBusinessType()).isEqualTo(UPDATED_BUSINESS_TYPE);
        assertThat(testBusiness.getBusinessAddress()).isEqualTo(UPDATED_BUSINESS_ADDRESS);
        assertThat(testBusiness.getBusinessCategory()).isEqualTo(UPDATED_BUSINESS_CATEGORY);
        assertThat(testBusiness.getBusinessFaxNum()).isEqualTo(UPDATED_BUSINESS_FAX_NUM);
        assertThat(testBusiness.isIsHeadquarter()).isEqualTo(UPDATED_IS_HEADQUARTER);
        assertThat(testBusiness.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingBusiness() throws Exception {
        int databaseSizeBeforeUpdate = businessRepository.findAll().size();

        // Create the Business

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBusinessMockMvc.perform(put("/api/businesses")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(business)))
            .andExpect(status().isBadRequest());

        // Validate the Business in the database
        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBusiness() throws Exception {
        // Initialize the database
        businessRepository.saveAndFlush(business);

        int databaseSizeBeforeDelete = businessRepository.findAll().size();

        // Delete the business
        restBusinessMockMvc.perform(delete("/api/businesses/{id}", business.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Business> businessList = businessRepository.findAll();
        assertThat(businessList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Business.class);
        Business business1 = new Business();
        business1.setId(1L);
        Business business2 = new Business();
        business2.setId(business1.getId());
        assertThat(business1).isEqualTo(business2);
        business2.setId(2L);
        assertThat(business1).isNotEqualTo(business2);
        business1.setId(null);
        assertThat(business1).isNotEqualTo(business2);
    }
}
