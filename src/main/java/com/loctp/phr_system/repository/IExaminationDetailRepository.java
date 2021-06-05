package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.ExaminationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExaminationDetailRepository extends JpaRepository<ExaminationDetail,Integer> {
}
