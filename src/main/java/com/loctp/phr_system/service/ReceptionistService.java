package com.loctp.phr_system.service;

import com.loctp.phr_system.controller.ReceptionistController;
import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;
import com.loctp.phr_system.dto.ReceptionistRequestUpdate;
import com.loctp.phr_system.model.Receptionist;
import com.loctp.phr_system.repository.IReceptionistRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ReceptionistService implements IReceptionistService{

    private final String ROLE_RECEPTIONIST = "receptionist";
    private final String STATUS_ENABLE = "enable";

    Logger logger = LoggerFactory.getLogger(ReceptionistController.class);

    @Autowired
    IReceptionistRepository receptionistRepository;

    @Autowired
    IAccountService iAccountService;


    @Autowired
    private ModelMapper mapper;

    @Override
    public ReceptionistDTO getReceptionistById(Integer id) {
        ReceptionistDTO receptionistDTO =  new ReceptionistDTO();
        Receptionist receptionist = receptionistRepository.getById(id);
        if(iAccountService.checkStatus(receptionist.getAccountId())){
            mapper.map(receptionist, receptionistDTO);
            receptionistDTO.setClinicName(receptionist.getClinic().getName());
        }
        return receptionistDTO;
    }

    @Override
    public Boolean updateReceptionistById(ReceptionistRequestUpdate receptionistRequest) {
         boolean check = false;
        try {
            Receptionist receptionist = receptionistRepository.getById(receptionistRequest.getId());
            receptionist.setName(receptionistRequest.getName());
            receptionist.getAccount().setPassword(receptionistRequest.getPassword());
            receptionistRepository.save(receptionist);
            check = true;
        }catch (EntityNotFoundException e){
        }
        return check;
    }

    @Override
    public ReceptionistDTO createReceptionist(ReceptionistRequest receptionistRequest) {

        // call Account Service to create a new account
        // => take Account Id to assign for this new Receptionist
        AccountDTO accountDTO = mapper.map(receptionistRequest,AccountDTO.class);
        accountDTO.setRoleId(ROLE_RECEPTIONIST);
        accountDTO.setStatus(STATUS_ENABLE);
        accountDTO = iAccountService.createAccount(accountDTO);
        if (accountDTO.getId() != null) {

            // after create an account => take the account's id from account table
            Receptionist receptionist = mapper.map(receptionistRequest, Receptionist.class);
            receptionist.setAccountId(accountDTO.getId());
            receptionist = receptionistRepository.save(receptionist);
            // done with creating new receptionist
            return mapper.map(receptionist, ReceptionistDTO.class);
        }
        return mapper.map(receptionistRequest, ReceptionistDTO.class);
    }

    @Override
    public Boolean deleteReceptionistById(Integer id) { // change the status of the account of this receptionist to disable
        try{
            Receptionist receptionist = receptionistRepository.getById(id);
            if(iAccountService.disableAccountById(receptionist.getAccountId())){
                return true;
            }
        }catch (Exception e){
            logger.error("ERROR at ReceptionistService_DeleteReceptionistById: " + e.getMessage());
        }

        return false;
    }
}
