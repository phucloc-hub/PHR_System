package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;
import com.loctp.phr_system.dto.ReceptionistRequestUpdate;

public interface IReceptionistService {
    ReceptionistDTO getReceptionistById(Integer id);

    Boolean updateReceptionistById(ReceptionistRequestUpdate receptionistRequest);

    ReceptionistDTO createReceptionist(ReceptionistRequest receptionistRequest);

    Boolean deleteReceptionistById(Integer id);
}
