package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PackageDTO;
import com.loctp.phr_system.dto.PackageTestDTO;
import com.loctp.phr_system.model.Package;
import com.loctp.phr_system.model.PackageTest;
import com.loctp.phr_system.repository.IPackageRepository;
import com.loctp.phr_system.repository.IPackageTestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageTestService implements IPackageTestService{

    @Autowired
    private IPackageTestRepository repository;

    @Autowired
    private ModelMapper mapper;
    
    @Override
    public PackageTestDTO createPackageTest(PackageTestDTO dto) {
        PackageTest packageTest = mapper.map(dto,PackageTest.class);
        packageTest = repository.save(packageTest);
        return mapper.map(packageTest,PackageTestDTO.class);


    }

    @Override
    public void deletePackageTest(Integer id) {
        repository.deleteById(id);
    }
}
