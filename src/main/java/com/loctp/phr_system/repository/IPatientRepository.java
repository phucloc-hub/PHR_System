package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByIdIn(List<Integer> id);

    Patient getByAccount_Phone(String phone);
}
