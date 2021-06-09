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
@RequestMapping("/receptionists")
public class ReceptionistController {

    Logger logger = LoggerFactory.getLogger(ReceptionistController.class);

    @Autowired
    IReceptionistService iReceptionistService;


    @GetMapping("/receptionist/{id}")
    private ReceptionistDTO getReceptionistById(@PathVariable int id){
        try{
            String x = "";
            int y= Integer.parseInt(x);
        }catch (Exception e){
            logger.error("ERROR at ReceptionController: " + e.getMessage());
        }
        return null;
    }
    @PostMapping("/receptionist")
    public ResponseEntity<ReceptionistDTO> createReceptionist(@Valid @RequestBody ReceptionistRequest receptionistRequest){

        ReceptionistDTO receptionistDTO = iReceptionistService.createReceptionist(receptionistRequest);
        if(receptionistDTO.getAccountId() == null){
            return new ResponseEntity<>(receptionistDTO, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(receptionistDTO, HttpStatus.OK);
    }

    @DeleteMapping("/receptionist/{id}")
    public ResponseEntity<Integer> disableReceptionist(@PathVariable Integer id){
        if(iReceptionistService.deleteReceptionistById(id)){
            return new ResponseEntity<>(id,HttpStatus.OK);
        }
        return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/receptionist/{id}")
    public ResponseEntity<ReceptionistDTO> updateByReceptionistId(@PathVariable int id, @Valid @RequestBody ReceptionistRequest receptionistRequest){
        if(iReceptionistService.updateById(id,receptionistRequest) == null){
            new ResponseEntity<>(iReceptionistService.updateById(id,receptionistRequest), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(iReceptionistService.updateById(id,receptionistRequest), HttpStatus.OK);
    }
}
