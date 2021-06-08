package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.model.Doctor;
import com.loctp.phr_system.repository.IDoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService implements IDoctorService{

    @Autowired
    IDoctorRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DoctorDTO createDoctor(DoctorDTO dto) {
        Doctor doctor = mapper.map(dto,Doctor.class);
        doctor = repository.save(doctor);

        return mapper.map(doctor,DoctorDTO.class);

    }

    @Override
    public void deleteDoctor(Integer id) {
        Doctor doctor = repository.findById(id).get();
        //
    }
}
