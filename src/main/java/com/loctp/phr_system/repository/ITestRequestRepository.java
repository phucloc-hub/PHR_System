package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.TestRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestRequestRepository extends JpaRepository<TestRequest,Integer> {
    List<TestRequest> findByDoctorIdIn(List<Integer> id);
}
