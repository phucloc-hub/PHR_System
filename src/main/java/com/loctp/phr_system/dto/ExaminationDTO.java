package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationDTO {
    private Integer id;
    private java.sql.Timestamp timeStart;
    private java.sql.Timestamp timeFinish;
    private String type;
    private String diagnose;
    private Integer testRequestId;

}
