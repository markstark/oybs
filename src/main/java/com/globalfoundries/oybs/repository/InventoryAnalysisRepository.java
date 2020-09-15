package com.globalfoundries.oybs.repository;

import com.globalfoundries.oybs.domain.InventoryAnalysis;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the InventoryAnalysis entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InventoryAnalysisRepository extends JpaRepository<InventoryAnalysis, Long> {

    @Query("select inventoryAnalysis from InventoryAnalysis inventoryAnalysis where inventoryAnalysis.user.login = ?#{principal.username}")
    List<InventoryAnalysis> findByUserIsCurrentUser();
}
