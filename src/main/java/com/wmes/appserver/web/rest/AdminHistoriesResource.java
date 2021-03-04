package com.wmes.appserver.web.rest;

import com.wmes.appserver.domain.AdminHistories;
import com.wmes.appserver.service.AdminHistoriesService;
import com.wmes.appserver.web.rest.errors.BadRequestAlertException;
import com.wmes.appserver.service.dto.AdminHistoriesCriteria;
import com.wmes.appserver.service.AdminHistoriesQueryService;

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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.wmes.appserver.domain.AdminHistories}.
 */
@RestController
@RequestMapping("/api")
public class AdminHistoriesResource {

    private final Logger log = LoggerFactory.getLogger(AdminHistoriesResource.class);

    private static final String ENTITY_NAME = "adminHistories";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AdminHistoriesService adminHistoriesService;

    private final AdminHistoriesQueryService adminHistoriesQueryService;

    public AdminHistoriesResource(AdminHistoriesService adminHistoriesService, AdminHistoriesQueryService adminHistoriesQueryService) {
        this.adminHistoriesService = adminHistoriesService;
        this.adminHistoriesQueryService = adminHistoriesQueryService;
    }

    /**
     * {@code POST  /admin-histories} : Create a new adminHistories.
     *
     * @param adminHistories the adminHistories to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new adminHistories, or with status {@code 400 (Bad Request)} if the adminHistories has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/admin-histories")
    public ResponseEntity<AdminHistories> createAdminHistories(@Valid @RequestBody AdminHistories adminHistories) throws URISyntaxException {
        log.debug("REST request to save AdminHistories : {}", adminHistories);
        if (adminHistories.getId() != null) {
            throw new BadRequestAlertException("A new adminHistories cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AdminHistories result = adminHistoriesService.save(adminHistories);
        return ResponseEntity.created(new URI("/api/admin-histories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /admin-histories} : Updates an existing adminHistories.
     *
     * @param adminHistories the adminHistories to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated adminHistories,
     * or with status {@code 400 (Bad Request)} if the adminHistories is not valid,
     * or with status {@code 500 (Internal Server Error)} if the adminHistories couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/admin-histories")
    public ResponseEntity<AdminHistories> updateAdminHistories(@Valid @RequestBody AdminHistories adminHistories) throws URISyntaxException {
        log.debug("REST request to update AdminHistories : {}", adminHistories);
        if (adminHistories.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AdminHistories result = adminHistoriesService.save(adminHistories);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, adminHistories.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /admin-histories} : get all the adminHistories.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of adminHistories in body.
     */
    @GetMapping("/admin-histories")
    public ResponseEntity<List<AdminHistories>> getAllAdminHistories(AdminHistoriesCriteria criteria, Pageable pageable) {
        log.debug("REST request to get AdminHistories by criteria: {}", criteria);
        Page<AdminHistories> page = adminHistoriesQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /admin-histories/count} : count all the adminHistories.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/admin-histories/count")
    public ResponseEntity<Long> countAdminHistories(AdminHistoriesCriteria criteria) {
        log.debug("REST request to count AdminHistories by criteria: {}", criteria);
        return ResponseEntity.ok().body(adminHistoriesQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /admin-histories/:id} : get the "id" adminHistories.
     *
     * @param id the id of the adminHistories to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the adminHistories, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/admin-histories/{id}")
    public ResponseEntity<AdminHistories> getAdminHistories(@PathVariable Long id) {
        log.debug("REST request to get AdminHistories : {}", id);
        Optional<AdminHistories> adminHistories = adminHistoriesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(adminHistories);
    }

    /**
     * {@code DELETE  /admin-histories/:id} : delete the "id" adminHistories.
     *
     * @param id the id of the adminHistories to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/admin-histories/{id}")
    public ResponseEntity<Void> deleteAdminHistories(@PathVariable Long id) {
        log.debug("REST request to delete AdminHistories : {}", id);
        adminHistoriesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
