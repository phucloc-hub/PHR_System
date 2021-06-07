package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.model.Receptionist;

public interface IReceptionistService{
    ReceptionistDTO updateById(ReceptionistDTO receptionistDTO);

    ReceptionistDTO createReceptionist(ReceptionistDTO receptionistDTO);
}
