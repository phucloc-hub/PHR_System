package com.loctp.phr_system.service;

import com.loctp.phr_system.controller.ReceptionistController;
import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.dto.DoctorDTO;
import com.loctp.phr_system.dto.DoctorRequest;
import com.loctp.phr_system.model.Doctor;
import com.loctp.phr_system.repository.IDoctorRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService implements IDoctorService{

    Logger logger = LoggerFactory.getLogger(ReceptionistController.class);


    private final String ROLE_DOCTOR = "doctor";
    private final String STATUS_ENABLE = "enable";

    @Autowired
    IDoctorRepository repository;

    @Autowired
    IAccountService iAccountService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DoctorDTO createDoctor(DoctorRequest doctorRequest) {
        // call Account Service to create a new account
        // => take Account Id to assign for this new Doctor
        AccountDTO accountDTO = mapper.map(doctorRequest,AccountDTO.class);
        accountDTO.setRoleId(ROLE_DOCTOR);
        accountDTO.setStatus(STATUS_ENABLE);
        accountDTO = iAccountService.createAccount(accountDTO);

        if (accountDTO.getId() != null){
            // after create an account => take the account's id from account table
            Doctor doctor = mapper.map(doctorRequest,Doctor.class);
            doctor.setAccountId(accountDTO.getId());
            doctor = repository.save(doctor);

            // done with creating new doctor
            return mapper.map(doctor, DoctorDTO.class);
        }

        return mapper.map(doctorRequest,DoctorDTO.class);
    }


    @Override
    public Boolean deleteDoctorById(Integer id) {
        try{
            Doctor doctor = repository.getById(id);

            if(iAccountService.disableAccountById(doctor.getAccountId())){
                return true;
            }
        }catch (Exception e){
            logger.error("ERROR at DoctorService_DeleteDoctorById: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<DoctorDTO> getDoctorByClinicId(int id) {
        List<Doctor> doctors = repository.findByClinicId(id);
        List<DoctorDTO> doctorDTOList = doctors.stream()
                .map(doctor -> mapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
        return doctorDTOList;
    }


}
