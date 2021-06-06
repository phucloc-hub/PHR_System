package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PackageDTO;
import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.model.Package;
import com.loctp.phr_system.model.Test;
import com.loctp.phr_system.repository.IPackageRepository;
import com.loctp.phr_system.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService implements IPackageService{

    @Autowired
    private IPackageRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public PackageDTO createPackage(PackageDTO dto) {
        Package aPackage = mapper.map(dto,Package.class);
        aPackage = repository.save(aPackage);
        return mapper.map(aPackage,PackageDTO.class);
    }

    @Override
    public int getCountForName(String name) {
        return repository.countByNameIgnoreCase(name);
    }
}
