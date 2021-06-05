package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestRequestDTO {
    private Integer id;
    private java.sql.Timestamp timeStart;
    private java.sql.Timestamp timeFinish;
    private String description;
    private Integer doctorId;
    private Integer patientId;
}
