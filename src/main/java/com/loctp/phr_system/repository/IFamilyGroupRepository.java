package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.FamilyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamilyGroupRepository extends JpaRepository<FamilyGroup,Integer> {
}
