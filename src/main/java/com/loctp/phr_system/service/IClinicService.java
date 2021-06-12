package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ClinicDTO;

import java.util.List;

public interface IClinicService  {
    ClinicDTO getClinicById(Integer id);
    Boolean checkClinicAvailable(Integer id);
    Boolean checkClinicByNameAndPhone(String name,String phone);
    ClinicDTO createClinic(ClinicDTO dto);
    Boolean updateClinic(ClinicDTO dto);
    Boolean disableClinicById(Integer id);
    List<ClinicDTO> getAll();

}
