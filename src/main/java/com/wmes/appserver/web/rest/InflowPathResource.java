package com.wmes.appserver.web.rest;

import com.wmes.appserver.domain.InflowPath;
import com.wmes.appserver.service.InflowPathService;
import com.wmes.appserver.web.rest.errors.BadRequestAlertException;
import com.wmes.appserver.service.dto.InflowPathCriteria;
import com.wmes.appserver.service.InflowPathQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.wmes.appserver.domain.InflowPath}.
 */
@RestController
@RequestMapping("/api")
public class InflowPathResource {

    private final Logger log = LoggerFactory.getLogger(InflowPathResource.class);

    private static final String ENTITY_NAME = "inflowPath";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InflowPathService inflowPathService;

    private final InflowPathQueryService inflowPathQueryService;

    public InflowPathResource(InflowPathService inflowPathService, InflowPathQueryService inflowPathQueryService) {
        this.inflowPathService = inflowPathService;
        this.inflowPathQueryService = inflowPathQueryService;
    }

    /**
     * {@code POST  /inflow-paths} : Create a new inflowPath.
     *
     * @param inflowPath the inflowPath to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new inflowPath, or with status {@code 400 (Bad Request)} if the inflowPath has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/inflow-paths")
    public ResponseEntity<InflowPath> createInflowPath(@RequestBody InflowPath inflowPath) throws URISyntaxException {
        log.debug("REST request to save InflowPath : {}", inflowPath);
        if (inflowPath.getId() != null) {
            throw new BadRequestAlertException("A new inflowPath cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InflowPath result = inflowPathService.save(inflowPath);
        return ResponseEntity.created(new URI("/api/inflow-paths/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /inflow-paths} : Updates an existing inflowPath.
     *
     * @param inflowPath the inflowPath to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated inflowPath,
     * or with status {@code 400 (Bad Request)} if the inflowPath is not valid,
     * or with status {@code 500 (Internal Server Error)} if the inflowPath couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/inflow-paths")
    public ResponseEntity<InflowPath> updateInflowPath(@RequestBody InflowPath inflowPath) throws URISyntaxException {
        log.debug("REST request to update InflowPath : {}", inflowPath);
        if (inflowPath.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InflowPath result = inflowPathService.save(inflowPath);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, inflowPath.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /inflow-paths} : get all the inflowPaths.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of inflowPaths in body.
     */
    @GetMapping("/inflow-paths")
    public ResponseEntity<List<InflowPath>> getAllInflowPaths(InflowPathCriteria criteria, Pageable pageable) {
        log.debug("REST request to get InflowPaths by criteria: {}", criteria);
        Page<InflowPath> page = inflowPathQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /inflow-paths/count} : count all the inflowPaths.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/inflow-paths/count")
    public ResponseEntity<Long> countInflowPaths(InflowPathCriteria criteria) {
        log.debug("REST request to count InflowPaths by criteria: {}", criteria);
        return ResponseEntity.ok().body(inflowPathQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /inflow-paths/:id} : get the "id" inflowPath.
     *
     * @param id the id of the inflowPath to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the inflowPath, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/inflow-paths/{id}")
    public ResponseEntity<InflowPath> getInflowPath(@PathVariable Long id) {
        log.debug("REST request to get InflowPath : {}", id);
        Optional<InflowPath> inflowPath = inflowPathService.findOne(id);
        return ResponseUtil.wrapOrNotFound(inflowPath);
    }

    /**
     * {@code DELETE  /inflow-paths/:id} : delete the "id" inflowPath.
     *
     * @param id the id of the inflowPath to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/inflow-paths/{id}")
    public ResponseEntity<Void> deleteInflowPath(@PathVariable Long id) {
        log.debug("REST request to delete InflowPath : {}", id);
        inflowPathService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
