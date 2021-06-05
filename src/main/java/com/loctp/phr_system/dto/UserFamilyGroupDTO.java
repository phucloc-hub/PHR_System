package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFamilyGroupDTO {
    private Integer id;
    private String groupRole;
    private Integer patientId;
    private Integer familyGroupId;
}
