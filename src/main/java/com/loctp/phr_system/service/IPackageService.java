package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.PackageDTO;

public interface IPackageService{
    public PackageDTO createPackage(PackageDTO dto);
    public int getCountForName(String name);


}
