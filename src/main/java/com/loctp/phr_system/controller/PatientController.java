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
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService iPatientService;

    @GetMapping("/patients/{phone}")
    public ResponseEntity<PatientDTO> getPatientByPhone(@Valid @PathVariable String phone){
        return new ResponseEntity<>(iPatientService.getPatientByPhone(phone), HttpStatus.OK);
    }

    @GetMapping("/patients")
        public ResponseEntity<List<PatientDTO>> getAllPatient(){
        //pendding because
        return null;
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientDTO> updatePatientById(@PathVariable int id,@Valid @RequestBody PatientRequest patientRequest){
        if(iPatientService.updatePatientById(id, patientRequest) == null){
            return new ResponseEntity<>(iPatientService.updatePatientById(id, patientRequest), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(iPatientService.updatePatientById(id, patientRequest), HttpStatus.OK);
    }
}
