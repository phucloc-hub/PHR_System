package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ClinicDTO;
import com.loctp.phr_system.service.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    IClinicService clinicService;

    @PostMapping("/clinic")
    public ResponseEntity<ClinicDTO> createDoctor(@Valid @RequestBody ClinicDTO clinicDTO){
        ClinicDTO dto =  clinicService.createClinic(clinicDTO);
        if(dto.getId() == null){
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

//    @DeleteMapping("/clinic/{id}")
//    public ResponseEntity<Integer> disableDoctor(@PathVariable Integer id){
//        if(doctorService.deleteDoctorById(id)){
//            return new ResponseEntity<>(id,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
//    }

}
