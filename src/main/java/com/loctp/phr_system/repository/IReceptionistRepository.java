package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceptionistRepository extends JpaRepository<Receptionist,Integer> {
    Receptionist getById(Integer integer);
}
