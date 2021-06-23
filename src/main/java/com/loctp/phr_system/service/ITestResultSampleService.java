package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.TestResultSampleDTO;

import java.util.List;

public interface ITestResultSampleService {
    public TestResultSampleDTO createTestResultSample(TestResultSampleDTO dto);

    public TestResultSampleDTO createListTestResultSample(List<TestResultSampleDTO> dtols, int testId);

    public TestResultSampleDTO updateListTestSampleById(List<TestResultSampleDTO> dtos);

    public List<TestResultSampleDTO> getListTestSampleByTestId(Integer id);
}
