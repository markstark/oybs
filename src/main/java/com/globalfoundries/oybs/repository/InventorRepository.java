package com.globalfoundries.oybs.repository;

import com.globalfoundries.oybs.domain.Inventor;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Inventor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InventorRepository extends JpaRepository<Inventor, Long> {
}
