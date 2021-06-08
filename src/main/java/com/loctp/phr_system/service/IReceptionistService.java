package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;

public interface IReceptionistService{
    ReceptionistDTO updateById(int id,ReceptionistRequest receptionistRequest);

    ReceptionistDTO createReceptionist(ReceptionistRequest receptionistRequest);
}
