package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.PatientRequest;
import com.loctp.phr_system.dto.TestRequestDTO;
import com.loctp.phr_system.model.Patient;
import com.loctp.phr_system.repository.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IPatientService {
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IDoctorService iDoctorService;
    @Autowired
    ITestRequestService iTestRequestService;
    @Autowired
    private IPatientRepository iPatientRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public PatientDTO getPatientByPhone(String phone) {
        PatientDTO patientDTO = new PatientDTO();
        Patient patient = iPatientRepository.getByAccount_Phone(phone);
        if (patient != null) {
            patientDTO = mapper.map(patient, PatientDTO.class);
            patientDTO.setPhone(phone);
        }
        return patientDTO;
    }

    @Override
    public Boolean updatePatientById(int id, PatientRequest patientRequest) {
        Boolean result = false;
        try {
            Patient patient = iPatientRepository.getById(id);
            mapper.map(patientRequest, patient);
            patient = iPatientRepository.save(patient);
            patient.getAccount().setPassword(patientRequest.getPassword());
            result = true;
        } catch (EntityNotFoundException e) {
        }
        return result;
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
        List<PatientDTO> patientDTOList = new ArrayList<>();
        patients.stream().forEach(patient -> {
            PatientDTO temp = mapper.map(patient, PatientDTO.class);
            temp.setPhone(patient.getAccount().getPhone());
            patientDTOList.add(temp);
        });
        return patientDTOList;
    }


}
