package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ClinicGroupDTO;
import com.loctp.phr_system.service.IClinicGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clinic-groups")
public class ClinicGroupController {

    @Autowired
    IClinicGroupService clinicGroupService;

    @PostMapping("/clinic-group")
    public ResponseEntity<ClinicGroupDTO> createClinicGroup(@Valid @RequestBody ClinicGroupDTO clinicGroupDTO) {
        ClinicGroupDTO dto = clinicGroupService.createClinicGroup(clinicGroupDTO);
        if (dto.getId() == null) {
            return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
