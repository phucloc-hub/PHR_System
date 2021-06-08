package com.loctp.phr_system.repository;

import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {
    Patient getByPhone(String phone);
    List<Patient> findByIdIn(List<Integer> id);
}
