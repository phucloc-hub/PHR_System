package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.TestRequestDTO;
import com.loctp.phr_system.model.Patient;
import com.loctp.phr_system.model.TestRequest;

import java.util.List;

public interface ITestRequestService {
    List<TestRequestDTO> getByDoctorIdIn(List<DoctorDTO> doctors);
}
