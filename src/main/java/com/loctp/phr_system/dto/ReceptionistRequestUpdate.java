package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ReceptionistRequestUpdate {
    @NotNull
    private Integer id;

    @NotNull
    @NotEmpty
    private String image;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private String password;
}
