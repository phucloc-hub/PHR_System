package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.PackageDTO;

import java.util.List;

public interface IPackageService{
    public PackageDTO createPackage(PackageDTO dto);
    public Boolean updatePackage(PackageDTO dto);
    public int getCountForName(String name);
    public List<PackageDTO> getAll();
}
