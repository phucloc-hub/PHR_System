package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;

public interface IReceptionistService{
    ReceptionistDTO getReceptionistById(Integer id);

    ReceptionistDTO updateById(Integer id,ReceptionistRequest receptionistRequest);

    ReceptionistDTO createReceptionist(ReceptionistRequest receptionistRequest);

    Boolean deleteReceptionistById(Integer id);
}
