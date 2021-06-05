package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.ClinicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClinicGroupRepository extends JpaRepository<ClinicGroup,Integer> {
}
