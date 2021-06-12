package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.RatingResponse;

import java.util.List;

public interface IRatingService {
    List<RatingResponse> getRatingList();
}
