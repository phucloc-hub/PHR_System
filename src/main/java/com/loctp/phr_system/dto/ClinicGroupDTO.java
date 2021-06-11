package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClinicGroupDTO {
    private Integer id;

    @NotNull
    @NotEmpty
    private String name;
    private String image;

}
