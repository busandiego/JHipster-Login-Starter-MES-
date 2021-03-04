package com.wmes.appserver.service;

import com.wmes.appserver.domain.AdminHistories;
import com.wmes.appserver.repository.AdminHistoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AdminHistories}.
 */
@Service
@Transactional
public class AdminHistoriesService {

    private final Logger log = LoggerFactory.getLogger(AdminHistoriesService.class);

    private final AdminHistoriesRepository adminHistoriesRepository;

    public AdminHistoriesService(AdminHistoriesRepository adminHistoriesRepository) {
        this.adminHistoriesRepository = adminHistoriesRepository;
    }

    /**
     * Save a adminHistories.
     *
     * @param adminHistories the entity to save.
     * @return the persisted entity.
     */
    public AdminHistories save(AdminHistories adminHistories) {
        log.debug("Request to save AdminHistories : {}", adminHistories);
        return adminHistoriesRepository.save(adminHistories);
    }

    /**
     * Get all the adminHistories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AdminHistories> findAll(Pageable pageable) {
        log.debug("Request to get all AdminHistories");
        return adminHistoriesRepository.findAll(pageable);
    }


    /**
     * Get one adminHistories by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AdminHistories> findOne(Long id) {
        log.debug("Request to get AdminHistories : {}", id);
        return adminHistoriesRepository.findById(id);
    }

    /**
     * Delete the adminHistories by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AdminHistories : {}", id);
        adminHistoriesRepository.deleteById(id);
    }
}
