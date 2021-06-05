package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository  extends JpaRepository<Admin, Integer> {

}
