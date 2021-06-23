package com.loctp.phr_system.service;


import com.loctp.phr_system.dto.FamilyGroupDTO;
import com.loctp.phr_system.dto.UserFamilyGroupRequest;

import java.util.List;

public interface IUserFamilyGroupService {
    FamilyGroupDTO createUserFamilyGroup(UserFamilyGroupRequest userFamilyGroupRequest);

    Boolean addMemberIntoGroup(Integer family_groupId, Integer patientId);

    Boolean deleteMemberFromGroup(Integer family_groupId, Integer patientId);

    List<FamilyGroupDTO> getAllGroupJoined(Integer id);
}
