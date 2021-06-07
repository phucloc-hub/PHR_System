package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Test,Integer> {

    Integer countByNameIgnoreCase(String name);

    Test findByNameIgnoreCase(String name);
}
