package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.PackageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageRequestRepository extends JpaRepository<PackageRequest,Integer> {
}
