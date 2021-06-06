package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.model.Test;

public interface ITestService{
    public TestDTO createTest(TestDTO dto);
    public int getCountForName(String name);
    public Boolean updateTestById(TestDTO dto);

}
