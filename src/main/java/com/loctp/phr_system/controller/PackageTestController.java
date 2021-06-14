package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.PackageTestDTO;
import com.loctp.phr_system.dto.TestIndexReq;
import com.loctp.phr_system.service.IPackageTestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/package-tests")
public class PackageTestController {

    @Autowired
    IPackageTestService packageTestService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/package-detail/{id}")
    public ResponseEntity<List<TestIndexReq>> getPackageDetails(@NotNull @PathVariable Integer id){
        List<TestIndexReq> responseList = packageTestService.getPackageDetail(id);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }


    @PostMapping("/package-test")
    public ResponseEntity<PackageTestDTO> createPackage(@Valid @RequestBody PackageTestDTO packageTestDTO){

            packageTestDTO= packageTestService.createPackageTest(packageTestDTO);
            // done with creating new record to package test table
        return new ResponseEntity<>(packageTestDTO, HttpStatus.OK);
    }

    @DeleteMapping("/package-test/{id}")
    public ResponseEntity<Integer> deletePackageTest(@NotNull @PathVariable Integer id){
        packageTestService.deletePackageTest(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
