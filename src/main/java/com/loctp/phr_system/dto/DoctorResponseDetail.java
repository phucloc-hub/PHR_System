package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponseDetail {
    private Integer id;
    private Integer accountId;
    private String image;
    private String name;
    private Integer clinicId;
    private String clinicName;
    private String phone;

}
