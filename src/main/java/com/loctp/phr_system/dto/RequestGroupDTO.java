package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestGroupDTO {
    private Integer id;
    private java.sql.Date dateRequest;
    private String status;
    private Integer patientId;
    private Integer familyGroupId;
}
