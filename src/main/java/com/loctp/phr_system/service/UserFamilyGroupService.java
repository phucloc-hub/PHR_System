package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.FamilyGroupDTO;
import com.loctp.phr_system.dto.UserFamilyGroupRequest;
import com.loctp.phr_system.model.FamilyGroup;
import com.loctp.phr_system.model.UserFamilyGroup;
import com.loctp.phr_system.repository.IFamilyGroupRepository;
import com.loctp.phr_system.repository.IPatientRepository;
import com.loctp.phr_system.repository.IUserFamilyGroupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserFamilyGroupService implements IUserFamilyGroupService {

    private static final String STATUS = "enable";
    private static final String ROLE_LEADER = "leader";
    private static final String ROLE_MEMBER = "member";

    @Autowired
    IUserFamilyGroupRepository userFamilyGroupRepository;

    @Autowired
    IFamilyGroupRepository familyGroupRepository;

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ModelMapper mapper;


    @Override
    public FamilyGroupDTO createUserFamilyGroup(UserFamilyGroupRequest userFamilyGroupRequest) {
        FamilyGroupDTO result = null;
        if (patientRepository.existsById(userFamilyGroupRequest.getPatientId())) {

            FamilyGroup familyGroup = new FamilyGroup();
            familyGroup.setStatus(STATUS);
            familyGroup.setAvatar(userFamilyGroupRequest.getAvatar());
            familyGroup.setName(userFamilyGroupRequest.getName());
            familyGroupRepository.save(familyGroup);

            result = mapper.map(familyGroup, FamilyGroupDTO.class);

            UserFamilyGroup userFamilyGroup = new UserFamilyGroup();
            userFamilyGroup.setFamilyGroupId(familyGroup.getId());
            userFamilyGroup.setPatientId(userFamilyGroupRequest.getPatientId());
            userFamilyGroup.setGroupRole(ROLE_LEADER);

            userFamilyGroupRepository.save(userFamilyGroup);
        }
        return result;
    }


    @Override
    public Boolean addMemberIntoGroup(Integer family_groupId, Integer patientId) {
        if (userFamilyGroupRepository.getByPatientIdAndFamilyGroupId(patientId, family_groupId) == null) {
            UserFamilyGroup userFamilyGroup = new UserFamilyGroup();
            userFamilyGroup.setGroupRole(ROLE_MEMBER);
            userFamilyGroup.setPatientId(patientId);
            userFamilyGroup.setFamilyGroupId(family_groupId);
            userFamilyGroupRepository.save(userFamilyGroup);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteMemberFromGroup(Integer family_groupId, Integer patientId) {
        UserFamilyGroup userFamilyGroup = userFamilyGroupRepository.getByPatientIdAndFamilyGroupId(patientId, family_groupId);
        if (userFamilyGroup != null) {
            userFamilyGroupRepository.delete(userFamilyGroup);
            return true;
        }
        return false;
    }

    @Override
    public List<FamilyGroupDTO> getAllGroupJoined(Integer id) {
        List<FamilyGroupDTO> familyGroupDTOList = new ArrayList<>();
        try {
            List<UserFamilyGroup> userFamilyGroups = userFamilyGroupRepository.findByPatientId(id);
            userFamilyGroups.forEach(userFamilyGroup -> {
                familyGroupDTOList.add(mapper.map(userFamilyGroup.getFamilyGroup(), FamilyGroupDTO.class));
            });
        } catch (EntityNotFoundException e) {
        }
        return familyGroupDTOList;
    }


}
