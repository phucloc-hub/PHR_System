package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.DoctorRequest;
import com.loctp.phr_system.dto.DoctorResponseDetail;

import java.util.List;

public interface IDoctorService  {
    List<DoctorDTO> getDoctorByClinicId(Integer id);
    DoctorDTO createDoctor(DoctorRequest doctorRequest);
    Boolean deleteDoctorById(Integer id);
    List<DoctorDTO> getAll();
    DoctorResponseDetail getDoctorById(Integer id);
}
