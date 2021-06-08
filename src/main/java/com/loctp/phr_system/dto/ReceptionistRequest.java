package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReceptionistRequest {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull(message = "Password can not null!")
    @NotEmpty
    private String password;

    @NotNull(message = "Image can not null!")
    private String image;

    @NotNull(message = "Name can not null!")
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private Integer clinicId;
}
