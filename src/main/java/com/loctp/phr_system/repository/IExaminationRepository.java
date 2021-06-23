package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExaminationRepository extends JpaRepository<Examination, Integer> {
}
