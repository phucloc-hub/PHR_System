package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ExaminationRequest;

public interface IExaminationService {
    Integer createExamination(ExaminationRequest examinationRequest);
}
