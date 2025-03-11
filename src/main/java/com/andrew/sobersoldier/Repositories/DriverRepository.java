package com.andrew.sobersoldier.Repositories;


import com.andrew.sobersoldier.Entities.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
}
