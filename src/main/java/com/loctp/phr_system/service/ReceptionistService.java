package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.model.Receptionist;
import com.loctp.phr_system.repository.IReceptionistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService implements IReceptionistService{

    @Autowired
    IReceptionistRepository receptionistRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ReceptionistDTO updateById(ReceptionistDTO receptionistDTO) {
        Receptionist receptionist = receptionistRepository.getById(receptionistDTO.getId());
        receptionist.setName(receptionistDTO.getName());
        receptionist.setImage(receptionistDTO.getImage());
        receptionist.setAccountId(receptionistDTO.getAccountId());
        receptionist.setClinicId(receptionistDTO.getClinicId());
        receptionist = receptionistRepository.save(receptionist);
        ReceptionistDTO respone =  new ReceptionistDTO();
        mapper.map(receptionist,respone);
        return respone;
    }

    @Override
    public ReceptionistDTO createReceptionist(ReceptionistDTO receptionistDTO) {
        Receptionist receptionist =  new Receptionist();
        receptionist.setId(receptionistDTO.getId());
        receptionist.setName(receptionistDTO.getName());
        receptionist.setImage(receptionistDTO.getImage());
        receptionist.setClinicId(receptionistDTO.getClinicId());
        receptionist.setAccountId(receptionistDTO.getAccountId());
        receptionist = receptionistRepository.save(receptionist);
        ReceptionistDTO respone =  new ReceptionistDTO();
        mapper.map(receptionist,respone);
        return respone;
    }
}
