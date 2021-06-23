package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.ClinicGroupDTO;
import com.loctp.phr_system.model.ClinicGroup;
import com.loctp.phr_system.repository.IClinicGroupRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClinicGroupService implements IClinicGroupService {


    Logger logger = LoggerFactory.getLogger(ClinicGroupService.class);

    @Autowired
    private IClinicGroupRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ClinicGroupDTO createClinicGroup(ClinicGroupDTO dto) {
        if (repository.countByNameIgnoreCase(dto.getName()) == 0) {
            ClinicGroup clinicGroup = mapper.map(dto, ClinicGroup.class);
            clinicGroup = repository.save(clinicGroup);
            return mapper.map(clinicGroup, ClinicGroupDTO.class);
        }
        return dto;

    }

}
