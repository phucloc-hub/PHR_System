package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.dto.TestIndexReq;
import com.loctp.phr_system.dto.TestResultSampleDTO;
import com.loctp.phr_system.service.AccountService;
import com.loctp.phr_system.service.TestResultSampleService;
import com.loctp.phr_system.service.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    TestResultSampleService testResultSampleService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/testindex")
    public ResponseEntity<TestIndexReq> createTestIndex(@Valid @RequestBody TestIndexReq testIndexReq){
        TestDTO testDTO = mapper.map(testIndexReq,TestDTO.class);
        if(testService.getCountForName(testDTO.getName()) == 0){
            testDTO = testService.createTest(testDTO);
            // done with creating new record to test table

            TestResultSampleDTO testResultSampleDTO
                    = testResultSampleService.createListTestResultSample(testIndexReq.getSamplelst(),testDTO.getId().intValue());
            // done with creating new list record to test result sample table

        }else{
            return new ResponseEntity<>(testIndexReq, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(testIndexReq, HttpStatus.OK);
    }

    @PutMapping("/testindex")
    public ResponseEntity<TestIndexReq> updateTestIndex(@Valid @RequestBody TestIndexReq testIndexReq){
        TestDTO testDTO = mapper.map(testIndexReq,TestDTO.class);


             if(testService.updateTestById(testDTO)){// if update Test successfully
                 testResultSampleService.updateListTestSampleById(testIndexReq.getSamplelst());
                 return new ResponseEntity<>(testIndexReq, HttpStatus.OK);
             }

        return new ResponseEntity<>(testIndexReq, HttpStatus.NOT_FOUND);
    }


}
