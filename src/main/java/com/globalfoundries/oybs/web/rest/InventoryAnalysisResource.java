package com.globalfoundries.oybs.web.rest;

import com.globalfoundries.oybs.domain.InventoryAnalysis;
import com.globalfoundries.oybs.repository.InventoryAnalysisRepository;
import com.globalfoundries.oybs.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.globalfoundries.oybs.domain.InventoryAnalysis}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class InventoryAnalysisResource {

    private final Logger log = LoggerFactory.getLogger(InventoryAnalysisResource.class);

    private static final String ENTITY_NAME = "inventoryAnalysis";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InventoryAnalysisRepository inventoryAnalysisRepository;

    public InventoryAnalysisResource(InventoryAnalysisRepository inventoryAnalysisRepository) {
        this.inventoryAnalysisRepository = inventoryAnalysisRepository;
    }

    /**
     * {@code POST  /inventory-analyses} : Create a new inventoryAnalysis.
     *
     * @param inventoryAnalysis the inventoryAnalysis to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new inventoryAnalysis, or with status {@code 400 (Bad Request)} if the inventoryAnalysis has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/inventory-analyses")
    public ResponseEntity<InventoryAnalysis> createInventoryAnalysis(@RequestBody InventoryAnalysis inventoryAnalysis) throws URISyntaxException {
        log.debug("REST request to save InventoryAnalysis : {}", inventoryAnalysis);
        if (inventoryAnalysis.getId() != null) {
            throw new BadRequestAlertException("A new inventoryAnalysis cannot already have an ID", ENTITY_NAME, "idexists");
        }
        InventoryAnalysis result = inventoryAnalysisRepository.save(inventoryAnalysis);
        return ResponseEntity.created(new URI("/api/inventory-analyses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /inventory-analyses} : Updates an existing inventoryAnalysis.
     *
     * @param inventoryAnalysis the inventoryAnalysis to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated inventoryAnalysis,
     * or with status {@code 400 (Bad Request)} if the inventoryAnalysis is not valid,
     * or with status {@code 500 (Internal Server Error)} if the inventoryAnalysis couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/inventory-analyses")
    public ResponseEntity<InventoryAnalysis> updateInventoryAnalysis(@RequestBody InventoryAnalysis inventoryAnalysis) throws URISyntaxException {
        log.debug("REST request to update InventoryAnalysis : {}", inventoryAnalysis);
        if (inventoryAnalysis.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        InventoryAnalysis result = inventoryAnalysisRepository.save(inventoryAnalysis);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, inventoryAnalysis.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /inventory-analyses} : get all the inventoryAnalyses.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of inventoryAnalyses in body.
     */
    @GetMapping("/inventory-analyses")
    public List<InventoryAnalysis> getAllInventoryAnalyses() {
        log.debug("REST request to get all InventoryAnalyses");
        return inventoryAnalysisRepository.findAll();
    }

    /**
     * {@code GET  /inventory-analyses/:id} : get the "id" inventoryAnalysis.
     *
     * @param id the id of the inventoryAnalysis to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the inventoryAnalysis, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/inventory-analyses/{id}")
    public ResponseEntity<InventoryAnalysis> getInventoryAnalysis(@PathVariable Long id) {
        log.debug("REST request to get InventoryAnalysis : {}", id);
        Optional<InventoryAnalysis> inventoryAnalysis = inventoryAnalysisRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(inventoryAnalysis);
    }

    /**
     * {@code DELETE  /inventory-analyses/:id} : delete the "id" inventoryAnalysis.
     *
     * @param id the id of the inventoryAnalysis to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/inventory-analyses/{id}")
    public ResponseEntity<Void> deleteInventoryAnalysis(@PathVariable Long id) {
        log.debug("REST request to delete InventoryAnalysis : {}", id);
        inventoryAnalysisRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
