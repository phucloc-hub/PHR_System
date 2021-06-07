package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.PackageDTO;
import com.loctp.phr_system.service.IPackageService;
import com.loctp.phr_system.service.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    IPackageService packageService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/package")
    public ResponseEntity<PackageDTO> createPackage(@Valid @RequestBody PackageDTO packageDTO){
        if(packageService.getCountForName(packageDTO.getName()) == 0){
            packageDTO= packageService.createPackage(packageDTO);
            // done with creating new record to package table

        }else{
            return new ResponseEntity<>(packageDTO, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(packageDTO, HttpStatus.OK);
    }

    @PutMapping("/package")
    public ResponseEntity<PackageDTO> updatePackage(@Valid @RequestBody PackageDTO packageDTO){
        Boolean check = packageService.updatePackage(packageDTO);
        if(check){
            return new ResponseEntity<>(packageDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(packageDTO, HttpStatus.CONFLICT);
    }

}
