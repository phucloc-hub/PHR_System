package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.PatientRequest;
import com.loctp.phr_system.dto.TestRequestDTO;
import com.loctp.phr_system.model.TestRequest;

import java.util.List;

public interface IPatientService{
    PatientDTO getPatientByPhone(String phone);
    PatientDTO updatePatientById(int id, PatientRequest patientRequest);
    List<PatientDTO> getPatientByClinicId(int id);
}
