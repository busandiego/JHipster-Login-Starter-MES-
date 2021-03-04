package com.wmes.appserver.repository;

import com.wmes.appserver.domain.InflowPath;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the InflowPath entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InflowPathRepository extends JpaRepository<InflowPath, Long>, JpaSpecificationExecutor<InflowPath> {

}
