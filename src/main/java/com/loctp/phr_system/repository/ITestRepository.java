package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Test;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestRepository extends JpaRepository<Test,Integer> {

    Integer countByNameIgnoreCase(String name);

    Test findByNameIgnoreCase(String name);

    List<Test> findByIdIn(List<Integer> ids);

}
