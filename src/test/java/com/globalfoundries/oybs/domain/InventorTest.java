package com.globalfoundries.oybs.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.globalfoundries.oybs.web.rest.TestUtil;

public class InventorTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Inventor.class);
        Inventor inventor1 = new Inventor();
        inventor1.setId(1L);
        Inventor inventor2 = new Inventor();
        inventor2.setId(inventor1.getId());
        assertThat(inventor1).isEqualTo(inventor2);
        inventor2.setId(2L);
        assertThat(inventor1).isNotEqualTo(inventor2);
        inventor1.setId(null);
        assertThat(inventor1).isNotEqualTo(inventor2);
    }
}
