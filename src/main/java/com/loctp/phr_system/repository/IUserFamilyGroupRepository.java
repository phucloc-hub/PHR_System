package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.UserFamilyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserFamilyGroupRepository extends JpaRepository<UserFamilyGroup,Integer> {
}
