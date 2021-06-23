package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.ExaminationRequest;
import com.loctp.phr_system.dto.PackageRequestClient;
import com.loctp.phr_system.dto.TestRequestClient;
import com.loctp.phr_system.model.Examination;
import com.loctp.phr_system.repository.IExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationService implements IExaminationService {

    @Autowired
    IExaminationRepository examinationRepository;

    @Autowired
    ITestRequestService testRequestService;

    @Autowired
    IPackageRequestService packageRequestService;

    @Override
    public Integer createExamination(ExaminationRequest examinationRequest) {
        Integer result = -1;
        TestRequestClient testRequestClient = new TestRequestClient();
        testRequestClient.setDescription(examinationRequest.getDecription());
        testRequestClient.setDoctorId(examinationRequest.getDoctorId());
        testRequestClient.setPatientId(examinationRequest.getPatientId());


        Integer testRequestId = testRequestService.createTestRequest(testRequestClient);
        if (testRequestId != null) {
            List<Integer> listPackageId = examinationRequest.getPackageId();
            List<Integer> listTestId = examinationRequest.getTestId();

            List<PackageRequestClient> packageRequestClient = new ArrayList<>();
            if (listPackageId.size() != 0 || listTestId.size() != 0) {
                if (listPackageId.size() > listTestId.size()) {
                    for (int i = 0; i < listPackageId.size(); i++) {
                        PackageRequestClient temp = new PackageRequestClient();
                        temp.setPackageId(listPackageId.get(i));
                        temp.setTestRequestId(testRequestId);
                        if (i < listTestId.size()) {
                            temp.setTestId(listTestId.get(i));
                        }
                        packageRequestClient.add(temp);
                    }
                } else {
                    for (int i = 0; i < listTestId.size(); i++) {
                        PackageRequestClient temp = new PackageRequestClient();
                        temp.setTestId(listTestId.get(i));
                        temp.setTestRequestId(testRequestId);
                        if (i < listPackageId.size()) {
                            temp.setPackageId(listPackageId.get(i));
                        }
                        packageRequestClient.add(temp);
                    }
                }
                if (packageRequestService.creatPackageRequest(packageRequestClient)) {
                    Examination examination = new Examination();
                    examination.setTestRequestId(testRequestId);
                    examination.setType(examinationRequest.getType());
                    examinationRepository.save(examination);
                    result = examination.getId();
                }
            }
        }
        return result;
    }
}
