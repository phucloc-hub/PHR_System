package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.DoctorRequest;
import com.loctp.phr_system.dto.DoctorRequestUpdate;
import com.loctp.phr_system.dto.DoctorResponseDetail;
import com.loctp.phr_system.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    IDoctorService doctorService;

    @PutMapping("/doctor")
    public ResponseEntity<Integer> updateDoctorById(@Valid @RequestBody DoctorRequestUpdate doctorRequest) {
        if (doctorService.updateDoctorById(doctorRequest)) {
            return new ResponseEntity<>(doctorRequest.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(doctorRequest.getId(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/doctor")
    public ResponseEntity<DoctorDTO> createDoctor(@Valid @RequestBody DoctorRequest doctorRequest) {
        DoctorDTO dto = doctorService.createDoctor(doctorRequest);
        if (dto.getAccountId() == null) {
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDTO>> getAll() {
        List<DoctorDTO> doctorDTOS = doctorService.getAll();

        return new ResponseEntity<>(doctorDTOS, HttpStatus.OK);

    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Integer> disableDoctor(@PathVariable Integer id) {
        if (doctorService.deleteDoctorById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<DoctorResponseDetail> getDoctorById(@PathVariable Integer id) {
        DoctorResponseDetail responseDetail = doctorService.getDoctorById(id);
        if (responseDetail.getId() == null) {
            return new ResponseEntity<>(responseDetail, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseDetail, HttpStatus.OK);

    }

}
