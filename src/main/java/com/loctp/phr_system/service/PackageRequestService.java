package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PackageRequestClient;
import com.loctp.phr_system.model.PackageRequest;
import com.loctp.phr_system.repository.IPackageRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageRequestService implements IPackageRequestService {

    @Autowired
    IPackageRequestRepository packageRequestRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Boolean creatPackageRequest(List<PackageRequestClient> packageRequestClients) {
        List<Integer> listPackageRequestId = new ArrayList<>();
        packageRequestClients.stream().forEach(packageRequestClient -> {
            PackageRequest temp = mapper.map(packageRequestClient, PackageRequest.class);
            packageRequestRepository.save(temp);
            listPackageRequestId.add(temp.getId());
        });
        if (listPackageRequestId.size() != 0) {
            return true;
        }
        return false;
    }
}
