package com.andrew.sobersoldier.Repositories;

import com.andrew.sobersoldier.Entities.LocationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRequestRepository extends JpaRepository<LocationRequestEntity, Long> {
    List<LocationRequestEntity> findByStatus(String status);
}
