package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.FamilyGroupDTO;
import com.loctp.phr_system.dto.UserFamilyGroupRequest;
import com.loctp.phr_system.service.IUserFamilyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user-family-groups")
public class UserFamilyGroupController {

    @Autowired
    IUserFamilyGroupService userFamilyGroupService;


    @GetMapping("/user-family-group/family-group/{patientId}")
    public ResponseEntity<List<FamilyGroupDTO>> getAllGroupJoined(@PathVariable Integer patientId){
        return new ResponseEntity<>(userFamilyGroupService.getAllGroupJoined(patientId), HttpStatus.OK);
    }


    @PostMapping("/user-family-group")
    public ResponseEntity<FamilyGroupDTO> createUserGroupFamily(@Valid @RequestBody UserFamilyGroupRequest userFamilyGroupRequest){
        FamilyGroupDTO result = userFamilyGroupService.createUserFamilyGroup(userFamilyGroupRequest);
        if(result == null){
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/user-family-group/{family_groupId}/add/{patientId}")
    public ResponseEntity<Boolean> addMemberIntoGroup(@PathVariable Integer family_groupId,@PathVariable Integer patientId){
        Boolean result = userFamilyGroupService.addMemberIntoGroup(family_groupId,patientId);
        if(result){
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/user-family-group/{family_groupId}/delete/{patientId}")
    public ResponseEntity<Boolean> removeMemberFromGroup(@PathVariable Integer family_groupId,@PathVariable Integer patientId){
        Boolean result = userFamilyGroupService.deleteMemberFromGroup(family_groupId,patientId);
        if(!result){
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
