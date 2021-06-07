package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.request.PatientRequest;
import com.loctp.phr_system.model.Patient;
import com.loctp.phr_system.repository.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService  implements IPatientService{
    @Autowired
    private IPatientRepository iPatientRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PatientDTO getPatientByPhone(String phone) {
        PatientDTO patientDTO = new PatientDTO();
        Patient patient = iPatientRepository.getByPhone(phone);
        mapper.map(patient, patientDTO);
        return patientDTO;
    }

    @Override
    public List<PatientDTO> getAllPatient(int pageNo, int pageSize ) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Patient> patients = iPatientRepository.findAll(pageable).getContent();
        List<PatientDTO> patientDTOS =patients
                .stream()
                .map(patient -> mapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
        return patientDTOS;
    }

    @Override
    public PatientDTO updatePatientById(int id, PatientRequest patientRequest) {
        Patient patient = iPatientRepository.getById(id);
        String phone  = patient.getPhone();
        mapper.map(patientRequest, patient);
        patient.setPhone(phone);
        patient = iPatientRepository.save(patient);
        PatientDTO dto =  new PatientDTO();
        mapper.map(patient, dto);
        return dto;
    }


}
