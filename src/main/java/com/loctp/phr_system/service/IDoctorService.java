package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.DoctorRequest;

import java.util.List;

public interface IDoctorService  {
    List<DoctorDTO> getDoctorByClinicId(int id);
    DoctorDTO createDoctor(DoctorRequest doctorRequest);
    Boolean deleteDoctorById(Integer id);
}
