package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.TestDTO;

public interface ITestService{
    public TestDTO createTest(TestDTO dto);
    public int getCountForName(String name);
}
