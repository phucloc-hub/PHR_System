package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Packagetest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageTestRepository extends JpaRepository<Packagetest,Integer> {
}
