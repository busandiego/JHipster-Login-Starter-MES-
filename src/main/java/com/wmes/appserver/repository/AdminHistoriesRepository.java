package com.wmes.appserver.repository;

import com.wmes.appserver.domain.AdminHistories;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AdminHistories entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdminHistoriesRepository extends JpaRepository<AdminHistories, Long>, JpaSpecificationExecutor<AdminHistories> {

}
