package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequestDTO;
import com.loctp.phr_system.model.Receptionist;
import com.loctp.phr_system.service.IReceptionistService;
import com.loctp.phr_system.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/receptionists")
public class ReceptionistController {

    @Autowired
    IReceptionistService iReceptionistService;

    @GetMapping("/receptionist/{id}")
    public ReceptionistDTO getReceptionistById(@Valid @RequestBody ReceptionistRequestDTO receptionistRequestDTO){
        return null;
    }

    @PostMapping("/receptionist")
    public ReceptionistDTO createRecptionist(@Valid @RequestBody ReceptionistDTO receptionistDTO){
        return iReceptionistService.createReceptionist(receptionistDTO);
    }

    @PutMapping("/receptionist")
    public ReceptionistDTO updateByReceptionId(@Valid @RequestBody ReceptionistDTO receptionistDTO){
        return iReceptionistService.updateById(receptionistDTO);
    }
}
