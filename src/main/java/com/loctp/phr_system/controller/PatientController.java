package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.PatientDTO;
import com.loctp.phr_system.dto.PatientRequest;
import com.loctp.phr_system.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    IPatientService iPatientService;


    @GetMapping("/patient/account/{phone}")
    public ResponseEntity<PatientDTO> getPatientByPhone(@PathVariable String phone) {
        PatientDTO patient = iPatientService.getPatientByPhone(phone);
        if (patient.getId() == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }


    @GetMapping("/patient/clinic/{id}")
    public ResponseEntity<List<PatientDTO>> getListPatientByClinicId(@PathVariable int id) {
        List<PatientDTO> patientDTOS = iPatientService.getPatientByClinicId(id);
        return new ResponseEntity<>(patientDTOS, HttpStatus.OK);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Integer> updatePatientById(@PathVariable int id, @Valid @RequestBody PatientRequest patientRequest) {
        Boolean check = iPatientService.updatePatientById(id, patientRequest);
        if (!check) {
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
