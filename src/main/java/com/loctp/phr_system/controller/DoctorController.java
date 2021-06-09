package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.DoctorRequest;
import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;
import com.loctp.phr_system.service.IDoctorService;
import com.loctp.phr_system.service.IReceptionistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    IDoctorService doctorService;

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDTO> createDoctor(@Valid @RequestBody DoctorRequest doctorRequest){
        DoctorDTO dto = doctorService.createDoctor(doctorRequest);
        if(dto.getAccountId() == null){
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Integer> disableDoctor(@PathVariable Integer id){
        if(doctorService.deleteDoctorById(id)){
            return new ResponseEntity<>(id,HttpStatus.OK);
        }
        return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
    }

}
