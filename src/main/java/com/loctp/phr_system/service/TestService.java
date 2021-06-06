package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.model.Account;
import com.loctp.phr_system.model.Test;
import com.loctp.phr_system.repository.IAccountRepository;
import com.loctp.phr_system.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService implements ITestService{

    @Autowired
    private ITestRepository testRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TestDTO createTest(TestDTO dto) {
        Test testModel = new Test();
        testModel = mapper.map(dto, Test.class);
        testModel = testRepository.save(testModel);
        return mapper.map(testModel,TestDTO.class);
    }

    @Override
    public int getCountForName(String name) {
       return testRepository.countByNameIgnoreCase(name).intValue();
    }
}
