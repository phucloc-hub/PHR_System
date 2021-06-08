package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.PatientRequest;

import java.util.List;

public interface IPatientService{
    PatientDTO getPatientByPhone(String phone);
    List<PatientDTO> getAllPatient(int pageNo, int pageSize);
    PatientDTO updatePatientById(int id, PatientRequest patientRequest);
}
