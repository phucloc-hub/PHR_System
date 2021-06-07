package com.loctp.phr_system.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReceptionistRequest {

    @NotNull(message = "Image can not null!")
    private String image;

    @NotNull(message = "Name can not null!")
    private String name;

    @NotNull(message = "ClinicId can not null!")
    private Integer clinicId;
}
