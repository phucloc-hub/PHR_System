package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {
    private Integer id;
    private Integer accountId;
    private String image;
    private String name;
    private Integer clinicId;

}
