package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.model.Doctor;
import com.loctp.phr_system.repository.IDoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<DoctorDTO> getDoctorByClinicId(int id) {
        List<Doctor> doctors = repository.findByClinicId(id);
        List<DoctorDTO> doctorDTOList = doctors.stream()
                .map(doctor -> mapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
        return doctorDTOList;
    }


}
