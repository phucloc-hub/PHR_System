package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestResultSampleDTO {
    private Integer id;
    private Double indexValueMax;
    private Double indexValueMin;
    private String type;
    private String description;
    private Integer testId;
}
