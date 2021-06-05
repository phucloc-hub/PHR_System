package com.loctp.phr_system.repository;

import com.loctp.phr_system.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRatingRepository extends JpaRepository<Rating,Integer> {
}
