package com.wmes.appserver.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.wmes.appserver.domain.AdminHistories;
import com.wmes.appserver.domain.*; // for static metamodels
import com.wmes.appserver.repository.AdminHistoriesRepository;
import com.wmes.appserver.service.dto.AdminHistoriesCriteria;

/**
 * Service for executing complex queries for {@link AdminHistories} entities in the database.
 * The main input is a {@link AdminHistoriesCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AdminHistories} or a {@link Page} of {@link AdminHistories} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AdminHistoriesQueryService extends QueryService<AdminHistories> {

    private final Logger log = LoggerFactory.getLogger(AdminHistoriesQueryService.class);

    private final AdminHistoriesRepository adminHistoriesRepository;

    public AdminHistoriesQueryService(AdminHistoriesRepository adminHistoriesRepository) {
        this.adminHistoriesRepository = adminHistoriesRepository;
    }

    /**
     * Return a {@link List} of {@link AdminHistories} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AdminHistories> findByCriteria(AdminHistoriesCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<AdminHistories> specification = createSpecification(criteria);
        return adminHistoriesRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link AdminHistories} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AdminHistories> findByCriteria(AdminHistoriesCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<AdminHistories> specification = createSpecification(criteria);
        return adminHistoriesRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AdminHistoriesCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<AdminHistories> specification = createSpecification(criteria);
        return adminHistoriesRepository.count(specification);
    }

    /**
     * Function to convert {@link AdminHistoriesCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<AdminHistories> createSpecification(AdminHistoriesCriteria criteria) {
        Specification<AdminHistories> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), AdminHistories_.id));
            }
            if (criteria.getActionType() != null) {
                specification = specification.and(buildSpecification(criteria.getActionType(), AdminHistories_.actionType));
            }
            if (criteria.getActionLoginId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getActionLoginId(), AdminHistories_.actionLoginId));
            }
            if (criteria.getActionNum() != null) {
                specification = specification.and(buildStringSpecification(criteria.getActionNum(), AdminHistories_.actionNum));
            }
            if (criteria.getContents() != null) {
                specification = specification.and(buildStringSpecification(criteria.getContents(), AdminHistories_.contents));
            }
            if (criteria.getAccessIp() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAccessIp(), AdminHistories_.accessIp));
            }
            if (criteria.getCreateDt() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreateDt(), AdminHistories_.createDt));
            }
        }
        return specification;
    }
}
