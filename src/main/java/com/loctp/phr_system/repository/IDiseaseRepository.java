package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiseaseRepository extends JpaRepository<Disease,Integer> {
}
