package com.globalfoundries.oybs.web.rest;

import com.globalfoundries.oybs.domain.Inventor;
import com.globalfoundries.oybs.repository.InventorRepository;
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
 * REST controller for managing {@link com.globalfoundries.oybs.domain.Inventor}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class InventorResource {

    private final Logger log = LoggerFactory.getLogger(InventorResource.class);

    private static final String ENTITY_NAME = "inventor";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final InventorRepository inventorRepository;

    public InventorResource(InventorRepository inventorRepository) {
        this.inventorRepository = inventorRepository;
    }

    /**
     * {@code POST  /inventors} : Create a new inventor.
     *
     * @param inventor the inventor to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new inventor, or with status {@code 400 (Bad Request)} if the inventor has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/inventors")
    public ResponseEntity<Inventor> createInventor(@RequestBody Inventor inventor) throws URISyntaxException {
        log.debug("REST request to save Inventor : {}", inventor);
        if (inventor.getId() != null) {
            throw new BadRequestAlertException("A new inventor cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Inventor result = inventorRepository.save(inventor);
        return ResponseEntity.created(new URI("/api/inventors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /inventors} : Updates an existing inventor.
     *
     * @param inventor the inventor to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated inventor,
     * or with status {@code 400 (Bad Request)} if the inventor is not valid,
     * or with status {@code 500 (Internal Server Error)} if the inventor couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/inventors")
    public ResponseEntity<Inventor> updateInventor(@RequestBody Inventor inventor) throws URISyntaxException {
        log.debug("REST request to update Inventor : {}", inventor);
        if (inventor.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Inventor result = inventorRepository.save(inventor);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, inventor.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /inventors} : get all the inventors.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of inventors in body.
     */
    @GetMapping("/inventors")
    public List<Inventor> getAllInventors() {
        log.debug("REST request to get all Inventors");
        return inventorRepository.findAll();
    }

    /**
     * {@code GET  /inventors/:id} : get the "id" inventor.
     *
     * @param id the id of the inventor to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the inventor, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/inventors/{id}")
    public ResponseEntity<Inventor> getInventor(@PathVariable Long id) {
        log.debug("REST request to get Inventor : {}", id);
        Optional<Inventor> inventor = inventorRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(inventor);
    }

    /**
     * {@code DELETE  /inventors/:id} : delete the "id" inventor.
     *
     * @param id the id of the inventor to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/inventors/{id}")
    public ResponseEntity<Void> deleteInventor(@PathVariable Long id) {
        log.debug("REST request to delete Inventor : {}", id);
        inventorRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
