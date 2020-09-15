package com.globalfoundries.oybs.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.globalfoundries.oybs.web.rest.TestUtil;

public class InventoryAnalysisTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InventoryAnalysis.class);
        InventoryAnalysis inventoryAnalysis1 = new InventoryAnalysis();
        inventoryAnalysis1.setId(1L);
        InventoryAnalysis inventoryAnalysis2 = new InventoryAnalysis();
        inventoryAnalysis2.setId(inventoryAnalysis1.getId());
        assertThat(inventoryAnalysis1).isEqualTo(inventoryAnalysis2);
        inventoryAnalysis2.setId(2L);
        assertThat(inventoryAnalysis1).isNotEqualTo(inventoryAnalysis2);
        inventoryAnalysis1.setId(null);
        assertThat(inventoryAnalysis1).isNotEqualTo(inventoryAnalysis2);
    }
}
