package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.ClinicDTO;
import com.loctp.phr_system.model.Clinic;
import com.loctp.phr_system.repository.IClinicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClinicService implements IClinicService{

    private final String STATUS_ENABLE = "enable";

    @Autowired
    private IClinicRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public Boolean checkClinicAvailable(Integer id) {
        Clinic clinic = repository.findById(id).get();
        if(clinic.getStatus().equalsIgnoreCase(STATUS_ENABLE)){
            return true;
        }
        return false;

    }

    @Override
    public Boolean checkClinicByNameAndPhone(String name, String phone) {
        Integer count = repository.countByNameIgnoreCaseOrPhone(name,phone);
        if(repository.countByNameIgnoreCaseOrPhone(name,phone) == 0){
            return false; // NOT duplicated
        }
        return true;
    }

    @Override
    public ClinicDTO createClinic(ClinicDTO dto) {
        if(!checkClinicByNameAndPhone(dto.getName(),dto.getPhone())){
            Clinic clinic = mapper.map(dto,Clinic.class);
            clinic = repository.save(clinic);
            return mapper.map(clinic,ClinicDTO.class);
        }
        return dto;

    }
}
