package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.TestRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRequestRepository extends JpaRepository<TestRequest,Integer> {
}
