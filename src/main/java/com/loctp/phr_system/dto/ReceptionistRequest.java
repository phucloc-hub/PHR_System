package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReceptionistRequest {

    @NotNull(message = "Password can not null!")
    private String password;

    @NotNull(message = "Image can not null!")
    private String image;

    @NotNull(message = "Name can not null!")
    private String name;
}
