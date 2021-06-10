package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ClinicDTO;

public interface IClinicService  {
    Boolean checkClinicAvailable(Integer id);
    Boolean checkClinicByNameAndPhone(String name,String phone);
    ClinicDTO createClinic(ClinicDTO dto);
    Boolean updateClinic(ClinicDTO dto);
    Boolean disableClinicById(Integer id);

}
