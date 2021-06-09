package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DoctorRequest {

    // field for account table
    @NotNull
    @NotEmpty
    private String username;

    // field for account table
    @NotNull(message = "Password can not null!")
    @NotEmpty
    private String password;

    // field for doctor table
    @NotNull(message = "Image can not null!")
    private String image;

    // field for doctor table
    @NotNull(message = "Name can not null!")
    @NotEmpty
    private String name;

    // field for doctor table
    @NotNull
    private Integer clinicId;
}
