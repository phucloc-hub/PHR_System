package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClinicDTO {
    private Integer id;

    @NotNull
    @NotEmpty
    private String name;

    private String address;

    @NotNull
    @NotEmpty
    private String phone;
    private String coordinate;

    @NotNull
    @NotEmpty
    private String status;
    private String image;
    private String description;
    private Integer clinicGroupId;
    @NotNull
    @NotEmpty
    private String district;

}
