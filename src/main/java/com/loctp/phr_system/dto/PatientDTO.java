package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {
    private Integer id;
    private Integer accountId;
    private String bloodType;
    private Integer height;
    private Integer weight;
    private String medicalNote;
    private String image;
    private String name;
    private String doB;
    private String address;
    private String phone;
    private String gender;
}
