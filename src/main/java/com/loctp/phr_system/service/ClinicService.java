package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.ClinicDTO;
import com.loctp.phr_system.model.Clinic;
import com.loctp.phr_system.repository.IClinicRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClinicService implements IClinicService{

    private final String STATUS_ENABLE = "enable";
    private final String STATUS_DISABLE = "disable";

    Logger logger = LoggerFactory.getLogger(ClinicService.class);

    @Autowired
    private IClinicRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public ClinicDTO getClinicById(Integer id) {
        Clinic clinic = repository.getById(id);
        ClinicDTO dto = mapper.map(clinic, ClinicDTO.class);
        return dto;
    }

    @Override
    public Boolean checkClinicAvailable(Integer id) {
        Clinic clinic = repository.findById(id).get();
        if(clinic.getStatus().equalsIgnoreCase(STATUS_ENABLE)){
            return true;
        }
        return false;

    }

    @Override
    public Boolean checkClinicByNameAndPhone(String name, String phone) {
        Integer count = repository.countByNameIgnoreCaseOrPhone(name,phone);
        if(repository.countByNameIgnoreCaseOrPhone(name,phone) == 0){
            return false; // NOT duplicated
        }
        return true;
    }

    @Override
    public ClinicDTO createClinic(ClinicDTO dto) {
        if(!checkClinicByNameAndPhone(dto.getName(),dto.getPhone())){
            Clinic clinic = mapper.map(dto,Clinic.class);
            clinic = repository.save(clinic);
            return mapper.map(clinic,ClinicDTO.class);
        }
        return dto;

    }

    @Override
    public Boolean updateClinic(ClinicDTO dto) {
        Boolean checkRS = false;

            Clinic clinic = repository.findById(dto.getId()).get();
            if (clinic != null){
                //nameDTO && PhoneDTO == name and phone existing of this ID object => update this current object
                String name = clinic.getName();
                String phone = clinic.getPhone();
                String nameDTO = dto.getName();
                String phoneDTO = dto.getPhone();
                if(name.equalsIgnoreCase(nameDTO) || phone.equals(phoneDTO)){
                    if (name.equalsIgnoreCase(nameDTO) && !phone.equals(phoneDTO)){
                        // check phone num co trung voi object khac khong
                        if(repository.countByPhone(phoneDTO) == 0){
                            clinic = mapper.map(dto,Clinic.class);
                            checkRS = true;
                        }

                    }else if(!name.equalsIgnoreCase(nameDTO) && phone.equals(phoneDTO)){
                        if(repository.countByNameIgnoreCase(nameDTO) == 0) {
                            clinic = mapper.map(dto,Clinic.class);
                            checkRS = true;
                        }

                    }else if (name.equalsIgnoreCase(nameDTO) && phone.equals(phoneDTO)){
                        clinic = mapper.map(dto,Clinic.class);
                        checkRS = true;

                    }

                    clinic = repository.save(clinic);

                }else{ // TH ca 2 name va phone NOT EQUAL this current object
                    if(!checkClinicByNameAndPhone(dto.getName(),dto.getPhone())){
                        clinic = mapper.map(dto,Clinic.class);
                        clinic = repository.save(clinic);
                        checkRS = true;

                    }

                }



            }

            return checkRS;
    }

    @Override
    public Boolean disableClinicById(Integer id) {
        Boolean checkRS = false;
        try{
            Clinic clinic = repository.getById(id);
            clinic.setStatus(STATUS_DISABLE);
            repository.save(clinic);
            checkRS = true;
        }catch (Exception e){
            logger.error("ERROR at ClinicService_disableClinicById: " + e.getMessage());
        }

        return checkRS;
    }
}
