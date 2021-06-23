package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.PackageTestDTO;
import com.loctp.phr_system.dto.TestIndexReq;

import java.util.List;

public interface IPackageTestService {
    public PackageTestDTO createPackageTest(PackageTestDTO dto);

    public void deletePackageTest(Integer id);

    public List<TestIndexReq> getPackageDetail(Integer id);
}

