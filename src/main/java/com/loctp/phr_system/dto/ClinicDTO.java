package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClinicDTO {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String coordinate;
    private String status;
    private String image;
    private String description;
    private Integer clinicGroupId;
    private String district;

}
