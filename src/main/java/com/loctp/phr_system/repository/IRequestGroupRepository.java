package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.RequestGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequestGroupRepository extends JpaRepository<RequestGroup,Integer> {
}
