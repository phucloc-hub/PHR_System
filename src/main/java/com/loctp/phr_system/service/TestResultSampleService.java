package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.dto.TestResultSampleDTO;
import com.loctp.phr_system.model.Account;
import com.loctp.phr_system.model.Test;
import com.loctp.phr_system.model.TestResultSample;
import com.loctp.phr_system.repository.ITestRepository;
import com.loctp.phr_system.repository.ITestResultSampleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestResultSampleService implements ITestResultSampleService{

    @Autowired
    private ITestResultSampleRepository repository;

    @Autowired
    private ModelMapper mapper;
    
    @Override
    public TestResultSampleDTO createTestResultSample(TestResultSampleDTO dto) {
        TestResultSample testrs = mapper.map(dto, TestResultSample.class);
        testrs = repository.save(testrs);
        return dto;
    }

    @Override
    public TestResultSampleDTO createListTestResultSample(List<TestResultSampleDTO> dtols,int testId) {
        // set testID for each TestResultSample
        for (TestResultSampleDTO rs: dtols
             ) {
            rs.setTestId(testId);
        }
        // map List DTO to List Model
        List<TestResultSample> dtos = dtols
                .stream()
                .map(a -> mapper.map(a, TestResultSample.class))
                .collect(Collectors.toList());

        repository.saveAll(dtos);
        return dtols.get(0);
    }
}
