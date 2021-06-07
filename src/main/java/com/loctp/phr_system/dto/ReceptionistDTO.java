package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReceptionistDTO {
    @NotNull(message = "id can not null")
    private Integer id;
    private Integer accountId;
    private String image;
    private String name;
    private Integer clinicId;
}
