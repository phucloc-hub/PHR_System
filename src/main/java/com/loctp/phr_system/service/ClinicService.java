package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.dto.TestIndexReq;
import com.loctp.phr_system.dto.TestResultSampleDTO;
import com.loctp.phr_system.model.Clinic;
import com.loctp.phr_system.model.Test;
import com.loctp.phr_system.repository.IClinicRepository;
import com.loctp.phr_system.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
