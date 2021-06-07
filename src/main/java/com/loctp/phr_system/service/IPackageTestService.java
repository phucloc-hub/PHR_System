package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.PackageTestDTO;

public interface IPackageTestService{
    public PackageTestDTO createPackageTest(PackageTestDTO dto);
    public void deletePackageTest(Integer id);
}

