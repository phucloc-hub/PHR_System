package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ClinicDTO;
import com.loctp.phr_system.service.IClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    IClinicService clinicService;

    @GetMapping("/clinics")
    public ResponseEntity<List<ClinicDTO>> getAll() {
        List<ClinicDTO> clinicDTOS = clinicService.getAll();

        return new ResponseEntity<>(clinicDTOS, HttpStatus.OK);

    }

    @GetMapping("/clinic/{id}")
    public ResponseEntity<ClinicDTO> getClinicById(@PathVariable Integer id) {
        ClinicDTO responseDetail = clinicService.getClinicById(id);
        if (responseDetail.getId() == null) {
            return new ResponseEntity<>(responseDetail, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseDetail, HttpStatus.OK);

    }

    @PostMapping("/clinic")
    public ResponseEntity<ClinicDTO> createClinic(@Valid @RequestBody ClinicDTO clinicDTO) {
        ClinicDTO dto = clinicService.createClinic(clinicDTO);
        if (dto.getId() == null) {
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/clinic")
    public ResponseEntity<ClinicDTO> updateClinic(@Valid @RequestBody ClinicDTO clinicDTO) {
        Boolean rs = clinicService.updateClinic(clinicDTO);
        if (rs) {
            return new ResponseEntity<>(clinicDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(clinicDTO, HttpStatus.CONFLICT);
    }


    @DeleteMapping("/clinic/{id}")
    public ResponseEntity<Integer> disableClinic(@PathVariable Integer id) {
        if (clinicService.disableClinicById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
    }

}
