package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.model.Receptionist;
import com.loctp.phr_system.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;

    @PostMapping("/create")
    public ReceptionistDTO createRecptionist(@RequestBody ReceptionistDTO receptionistDTO){
        return receptionistService.createReceptionist(receptionistDTO);
    }

    @PutMapping("/update")
    public ReceptionistDTO updateByReceptionId(@RequestBody ReceptionistDTO receptionistDTO){
        return receptionistService.updateById(receptionistDTO);
    }
}
