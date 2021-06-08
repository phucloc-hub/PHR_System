package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;
import com.loctp.phr_system.model.Account;
import com.loctp.phr_system.model.Receptionist;
import com.loctp.phr_system.repository.IAccountRepository;
import com.loctp.phr_system.repository.IReceptionistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService implements IReceptionistService{

    @Autowired
    IReceptionistRepository receptionistRepository;

    @Autowired
    IAccountService iAccountService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ReceptionistDTO updateById(int id,ReceptionistRequest receptionistRequest) {
        ReceptionistDTO respone =  new ReceptionistDTO();
        Receptionist receptionist = receptionistRepository.getById(id);
       if(iAccountService.checkStatus(receptionist.getAccountId())){
            mapper.map(receptionistRequest, receptionist);
            receptionist = receptionistRepository.save(receptionist);
            iAccountService.updatePasswordById(receptionist.getAccountId(), receptionistRequest.getPassword());
            mapper.map(receptionist,respone);
        }
        return respone;
    }

    @Override
    public ReceptionistDTO createReceptionist(ReceptionistRequest receptionistRequest) {
        Receptionist receptionist =  new Receptionist();
        mapper.map(receptionistRequest, receptionist);
        receptionist = receptionistRepository.save(receptionist);
        mapper.map(receptionist,receptionistRequest);
        return null;
    }
}
