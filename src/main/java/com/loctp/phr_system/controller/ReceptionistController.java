package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.model.Receptionist;
import com.loctp.phr_system.service.IReceptionistService;
import com.loctp.phr_system.service.ReceptionistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

    Logger logger = LoggerFactory.getLogger(ReceptionistController.class);

    @Autowired
    IReceptionistService iReceptionistService;

    @GetMapping("/receptionists/{id}")
    private ReceptionistDTO getReceptionistById(@PathVariable int id){
        try{
            String x = "";
            int y= Integer.parseInt(x);
        }catch (Exception e){
            logger.error("ERROR at ReceptionController: " + e.getMessage());
        }
        return null;
    }
    @PostMapping("/receptionists")
    public ReceptionistDTO createRecptionist(@RequestBody ReceptionistDTO receptionistDTO){
        return iReceptionistService.createReceptionist(receptionistDTO);
    }

    @PutMapping("/receptionists")
    public ReceptionistDTO updateByReceptionId(@RequestBody ReceptionistDTO receptionistDTO){
        return iReceptionistService.updateById(receptionistDTO);
    }
}
