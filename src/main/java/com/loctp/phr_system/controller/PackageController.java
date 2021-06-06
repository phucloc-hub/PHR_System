package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.PackageDTO;
import com.loctp.phr_system.dto.TestIndexReq;
import com.loctp.phr_system.dto.TestResultSampleDTO;
import com.loctp.phr_system.service.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    PackageService packageService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/newpackage")
    public ResponseEntity<PackageDTO> createPackage(@Valid @RequestBody PackageDTO packageDTO){
        if(packageService.getCountForName(packageDTO.getName()) == 0){
            packageDTO= packageService.createPackage(packageDTO);
            // done with creating new record to package table

        }else{
            return new ResponseEntity<>(packageDTO, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(packageDTO, HttpStatus.OK);
    }

}
