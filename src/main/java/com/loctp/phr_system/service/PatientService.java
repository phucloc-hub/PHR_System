package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.PatientRequest;
import com.loctp.phr_system.dto.TestRequestDTO;
import com.loctp.phr_system.model.Patient;
import com.loctp.phr_system.repository.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService  implements IPatientService{
    @Autowired
    private IPatientRepository iPatientRepository;

    @Autowired
    IAccountService iAccountService;

    @Autowired
    IDoctorService iDoctorService;

    @Autowired
    ITestRequestService iTestRequestService;

    @Autowired
    private ModelMapper mapper;


    @Override
    public PatientDTO updatePatientById(int id, PatientRequest patientRequest) {
        PatientDTO dto =  new PatientDTO();
        Patient patient = iPatientRepository.getById(id);
        if(iAccountService.checkStatus(patient.getAccountId())){
            mapper.map(patientRequest, patient);
            patient = iPatientRepository.save(patient);
            iAccountService.updatePasswordById(patient.getAccountId(), patientRequest.getPassword());
            mapper.map(patient, dto);
        }
        return dto;
    }

    @Override
    public List<PatientDTO> getPatientByClinicId(int id) {
        List<DoctorDTO> doctorDTOList = iDoctorService.getDoctorByClinicId(id);
        List<TestRequestDTO> testRequestDTOS = iTestRequestService.getByDoctorIdIn(doctorDTOList);
        List<Integer> listId = new ArrayList<>();
        testRequestDTOS.stream().forEach(testRequestDTO -> {
            listId.add(testRequestDTO.getPatientId());
        });
        List<Patient> patients = iPatientRepository.findByIdIn(listId);
        List<PatientDTO> patientDTOList = patients.stream()
                .map(patient -> mapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
        return patientDTOList;
    }


}
