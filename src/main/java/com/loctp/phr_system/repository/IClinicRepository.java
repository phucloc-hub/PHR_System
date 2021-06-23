package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClinicRepository extends JpaRepository<Clinic, Integer> {
    Integer countByNameIgnoreCaseOrPhone(String name, String phone);

    Integer countByNameIgnoreCase(String name);

    Integer countByPhone(String phone);
}
