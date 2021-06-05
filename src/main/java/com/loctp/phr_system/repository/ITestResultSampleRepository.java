package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.TestResultSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestResultSampleRepository extends JpaRepository<TestResultSample,Integer> {
}
