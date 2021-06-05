package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationDetailDTO {
    private Integer id;
    private Integer examinationId;
    private Integer testId;
    private String advise;
    private String diagnose;
    private String note;

}
