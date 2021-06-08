package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.DoctorDTO;

public interface IDoctorService  {
    public DoctorDTO createDoctor(DoctorDTO dto);
    public void deleteDoctor(Integer id);
}
