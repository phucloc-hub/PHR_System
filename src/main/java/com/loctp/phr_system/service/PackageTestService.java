package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.PackageTestDTO;
import com.loctp.phr_system.dto.TestIndexReq;
import com.loctp.phr_system.model.PackageTest;
import com.loctp.phr_system.repository.IPackageTestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageTestService implements IPackageTestService{

    @Autowired
    private IPackageTestRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ITestService testService;
    
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

    @Override
    public List<TestIndexReq> getPackageDetail(Integer id) {
        List<PackageTest> packageTests = repository.findByPackageId(id);

        List<Integer> listTestId = packageTests
                .stream()
                .map(a -> {
                    return a.getTestId();
                }).collect(Collectors.toList());

        List<TestIndexReq> rs = testService.getListTestIndex(listTestId);
        return rs;

    }
}
