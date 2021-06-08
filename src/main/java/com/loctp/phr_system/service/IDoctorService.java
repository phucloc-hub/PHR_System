package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService  {
    public DoctorDTO createDoctor(DoctorDTO dto);
    public void deleteDoctor(Integer id);
    List<DoctorDTO> getDoctorByClinicId(int id);
}
