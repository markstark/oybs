package com.globalfoundries.oybs.web.rest;

import com.globalfoundries.oybs.OybsApp;
import com.globalfoundries.oybs.domain.Inventor;
import com.globalfoundries.oybs.repository.InventorRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link InventorResource} REST controller.
 */
@SpringBootTest(classes = OybsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class InventorResourceIT {

    private static final String DEFAULT_VENDOR_NAME = "AAAAAAAAAA";
    private static final String UPDATED_VENDOR_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_DAY = "AAAAAAAAAA";
    private static final String UPDATED_TRX_DAY = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_MONTH = "AAAAAAAAAA";
    private static final String UPDATED_TRX_MONTH = "BBBBBBBBBB";

    private static final String DEFAULT_TRX_WEEK = "AAAAAAAAAA";
    private static final String UPDATED_TRX_WEEK = "BBBBBBBBBB";

    private static final String DEFAULT_TOOL_ID = "AAAAAAAAAA";
    private static final String UPDATED_TOOL_ID = "BBBBBBBBBB";

    @Autowired
    private InventorRepository inventorRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restInventorMockMvc;

    private Inventor inventor;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Inventor createEntity(EntityManager em) {
        Inventor inventor = new Inventor()
            .vendorName(DEFAULT_VENDOR_NAME)
            .trxDay(DEFAULT_TRX_DAY)
            .trxMonth(DEFAULT_TRX_MONTH)
            .trxWeek(DEFAULT_TRX_WEEK)
            .toolId(DEFAULT_TOOL_ID);
        return inventor;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Inventor createUpdatedEntity(EntityManager em) {
        Inventor inventor = new Inventor()
            .vendorName(UPDATED_VENDOR_NAME)
            .trxDay(UPDATED_TRX_DAY)
            .trxMonth(UPDATED_TRX_MONTH)
            .trxWeek(UPDATED_TRX_WEEK)
            .toolId(UPDATED_TOOL_ID);
        return inventor;
    }

    @BeforeEach
    public void initTest() {
        inventor = createEntity(em);
    }

    @Test
    @Transactional
    public void createInventor() throws Exception {
        int databaseSizeBeforeCreate = inventorRepository.findAll().size();
        // Create the Inventor
        restInventorMockMvc.perform(post("/api/inventors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(inventor)))
            .andExpect(status().isCreated());

        // Validate the Inventor in the database
        List<Inventor> inventorList = inventorRepository.findAll();
        assertThat(inventorList).hasSize(databaseSizeBeforeCreate + 1);
        Inventor testInventor = inventorList.get(inventorList.size() - 1);
        assertThat(testInventor.getVendorName()).isEqualTo(DEFAULT_VENDOR_NAME);
        assertThat(testInventor.getTrxDay()).isEqualTo(DEFAULT_TRX_DAY);
        assertThat(testInventor.getTrxMonth()).isEqualTo(DEFAULT_TRX_MONTH);
        assertThat(testInventor.getTrxWeek()).isEqualTo(DEFAULT_TRX_WEEK);
        assertThat(testInventor.getToolId()).isEqualTo(DEFAULT_TOOL_ID);
    }

    @Test
    @Transactional
    public void createInventorWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = inventorRepository.findAll().size();

        // Create the Inventor with an existing ID
        inventor.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restInventorMockMvc.perform(post("/api/inventors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(inventor)))
            .andExpect(status().isBadRequest());

        // Validate the Inventor in the database
        List<Inventor> inventorList = inventorRepository.findAll();
        assertThat(inventorList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllInventors() throws Exception {
        // Initialize the database
        inventorRepository.saveAndFlush(inventor);

        // Get all the inventorList
        restInventorMockMvc.perform(get("/api/inventors?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(inventor.getId().intValue())))
            .andExpect(jsonPath("$.[*].vendorName").value(hasItem(DEFAULT_VENDOR_NAME)))
            .andExpect(jsonPath("$.[*].trxDay").value(hasItem(DEFAULT_TRX_DAY)))
            .andExpect(jsonPath("$.[*].trxMonth").value(hasItem(DEFAULT_TRX_MONTH)))
            .andExpect(jsonPath("$.[*].trxWeek").value(hasItem(DEFAULT_TRX_WEEK)))
            .andExpect(jsonPath("$.[*].toolId").value(hasItem(DEFAULT_TOOL_ID)));
    }
    
    @Test
    @Transactional
    public void getInventor() throws Exception {
        // Initialize the database
        inventorRepository.saveAndFlush(inventor);

        // Get the inventor
        restInventorMockMvc.perform(get("/api/inventors/{id}", inventor.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(inventor.getId().intValue()))
            .andExpect(jsonPath("$.vendorName").value(DEFAULT_VENDOR_NAME))
            .andExpect(jsonPath("$.trxDay").value(DEFAULT_TRX_DAY))
            .andExpect(jsonPath("$.trxMonth").value(DEFAULT_TRX_MONTH))
            .andExpect(jsonPath("$.trxWeek").value(DEFAULT_TRX_WEEK))
            .andExpect(jsonPath("$.toolId").value(DEFAULT_TOOL_ID));
    }
    @Test
    @Transactional
    public void getNonExistingInventor() throws Exception {
        // Get the inventor
        restInventorMockMvc.perform(get("/api/inventors/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateInventor() throws Exception {
        // Initialize the database
        inventorRepository.saveAndFlush(inventor);

        int databaseSizeBeforeUpdate = inventorRepository.findAll().size();

        // Update the inventor
        Inventor updatedInventor = inventorRepository.findById(inventor.getId()).get();
        // Disconnect from session so that the updates on updatedInventor are not directly saved in db
        em.detach(updatedInventor);
        updatedInventor
            .vendorName(UPDATED_VENDOR_NAME)
            .trxDay(UPDATED_TRX_DAY)
            .trxMonth(UPDATED_TRX_MONTH)
            .trxWeek(UPDATED_TRX_WEEK)
            .toolId(UPDATED_TOOL_ID);

        restInventorMockMvc.perform(put("/api/inventors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedInventor)))
            .andExpect(status().isOk());

        // Validate the Inventor in the database
        List<Inventor> inventorList = inventorRepository.findAll();
        assertThat(inventorList).hasSize(databaseSizeBeforeUpdate);
        Inventor testInventor = inventorList.get(inventorList.size() - 1);
        assertThat(testInventor.getVendorName()).isEqualTo(UPDATED_VENDOR_NAME);
        assertThat(testInventor.getTrxDay()).isEqualTo(UPDATED_TRX_DAY);
        assertThat(testInventor.getTrxMonth()).isEqualTo(UPDATED_TRX_MONTH);
        assertThat(testInventor.getTrxWeek()).isEqualTo(UPDATED_TRX_WEEK);
        assertThat(testInventor.getToolId()).isEqualTo(UPDATED_TOOL_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingInventor() throws Exception {
        int databaseSizeBeforeUpdate = inventorRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restInventorMockMvc.perform(put("/api/inventors").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(inventor)))
            .andExpect(status().isBadRequest());

        // Validate the Inventor in the database
        List<Inventor> inventorList = inventorRepository.findAll();
        assertThat(inventorList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteInventor() throws Exception {
        // Initialize the database
        inventorRepository.saveAndFlush(inventor);

        int databaseSizeBeforeDelete = inventorRepository.findAll().size();

        // Delete the inventor
        restInventorMockMvc.perform(delete("/api/inventors/{id}", inventor.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Inventor> inventorList = inventorRepository.findAll();
        assertThat(inventorList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
