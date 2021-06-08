package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.ReceptionistDTO;
import com.loctp.phr_system.dto.ReceptionistRequest;
import com.loctp.phr_system.service.IReceptionistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ReceptionistDTO createRecptionist(@RequestBody ReceptionistRequest receptionistRequest){
        return iReceptionistService.createReceptionist(receptionistRequest);
    }

    @PutMapping("/receptionists/{id}")
    public ResponseEntity<ReceptionistDTO> updateByReceptionistId(@PathVariable int id, @Valid @RequestBody ReceptionistRequest receptionistRequest){
        if(iReceptionistService.updateById(id,receptionistRequest) == null){
            new ResponseEntity<>(iReceptionistService.updateById(id,receptionistRequest), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(iReceptionistService.updateById(id,receptionistRequest), HttpStatus.OK);
    }
}
