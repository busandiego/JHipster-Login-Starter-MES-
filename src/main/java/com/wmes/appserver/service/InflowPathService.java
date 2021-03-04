package com.wmes.appserver.service;

import com.wmes.appserver.domain.InflowPath;
import com.wmes.appserver.repository.InflowPathRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link InflowPath}.
 */
@Service
@Transactional
public class InflowPathService {

    private final Logger log = LoggerFactory.getLogger(InflowPathService.class);

    private final InflowPathRepository inflowPathRepository;

    public InflowPathService(InflowPathRepository inflowPathRepository) {
        this.inflowPathRepository = inflowPathRepository;
    }

    /**
     * Save a inflowPath.
     *
     * @param inflowPath the entity to save.
     * @return the persisted entity.
     */
    public InflowPath save(InflowPath inflowPath) {
        log.debug("Request to save InflowPath : {}", inflowPath);
        return inflowPathRepository.save(inflowPath);
    }

    /**
     * Get all the inflowPaths.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<InflowPath> findAll(Pageable pageable) {
        log.debug("Request to get all InflowPaths");
        return inflowPathRepository.findAll(pageable);
    }


    /**
     * Get one inflowPath by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<InflowPath> findOne(Long id) {
        log.debug("Request to get InflowPath : {}", id);
        return inflowPathRepository.findById(id);
    }

    /**
     * Delete the inflowPath by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete InflowPath : {}", id);
        inflowPathRepository.deleteById(id);
    }
}
