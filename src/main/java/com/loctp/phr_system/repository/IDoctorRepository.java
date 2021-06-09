package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Doctor;
import com.loctp.phr_system.model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByClinicId(int id);
    Doctor getById(Integer id);
}
