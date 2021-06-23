package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ExaminationRequest;
import com.loctp.phr_system.service.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/examinations")
public class ExaminationController {

    @Autowired
    IExaminationService examinationService;

    @PostMapping("/examination")
    public ResponseEntity<Integer> createExamination(@Valid @RequestBody ExaminationRequest request) {
        Integer result = examinationService.createExamination(request);
        if (result == -1) {
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
