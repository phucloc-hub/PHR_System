package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReceptionistDTO {
    private Integer id;
    private Integer accountId;
    private String image;
    private String name;
    private Integer clinicId;
    private ClinicDTO clinicDTO;
}
