package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPackageRepository extends JpaRepository<Package, Integer> {
    Integer countByNameIgnoreCase(String name);

}
