package com.whisbi.kpi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

public interface InteractionKpiRepository extends JpaRepository<InteractionKpi, InteractionKpiKey> {
}
