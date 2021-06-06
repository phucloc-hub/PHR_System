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
    public Boolean updatePackage(PackageDTO dto) {
        Boolean check = false;
        // take the package in db source
        Package aPackage = repository.findById(dto.getId()).get();
        if(aPackage != null){
            if(aPackage.getName().equalsIgnoreCase(dto.getName())){
                aPackage.setDescription(dto.getDescription());
                check = true;
            }else{
                int count = repository.countByNameIgnoreCase(dto.getName());
                if(count == 0){// NOT duplicated name
                    aPackage.setName(dto.getName());
                    aPackage.setDescription(dto.getDescription());
                    check = true;
                }

            }
            aPackage = repository.save(aPackage);
            //nameDTO == name existing of this ID object => update Description
            //nameDTO == one of names in orther object => check trung => if has duplicated => cannot update

        }
        return check;


    }

    @Override
    public int getCountForName(String name) {
        return repository.countByNameIgnoreCase(name);
    }
}
