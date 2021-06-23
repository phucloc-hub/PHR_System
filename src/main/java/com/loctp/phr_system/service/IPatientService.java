package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.PatientRequest;

import java.util.List;

public interface IPatientService {
    PatientDTO getPatientByPhone(String phone);

    Boolean updatePatientById(int id, PatientRequest patientRequest);

    List<PatientDTO> getPatientByClinicId(int id);
}
