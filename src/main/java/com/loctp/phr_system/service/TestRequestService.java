package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.TestRequestDTO;
import com.loctp.phr_system.model.Doctor;
import com.loctp.phr_system.model.Patient;
import com.loctp.phr_system.model.TestRequest;
import com.loctp.phr_system.repository.ITestRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestRequestService implements ITestRequestService{

    @Autowired
    ITestRequestRepository iTestRequestRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<TestRequestDTO> getByDoctorIdIn(List<DoctorDTO> doctors) {
        List<Integer> listDocId = new ArrayList<>();
        doctors.stream().forEach(doctorDTO ->
        {
            listDocId.add(doctorDTO.getId());
        });
        List<TestRequest> testRequests =iTestRequestRepository.findByDoctorIdIn(listDocId);
        List<TestRequestDTO> testRequestDTOS = testRequests.stream()
                .map(testRequest -> mapper.map(testRequest, TestRequestDTO.class))
                .collect(Collectors.toList());
        return testRequestDTOS;
    }
}
