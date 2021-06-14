package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TestRequestClient {

    private String description;

    @NotNull
    private Integer doctorId;

    @NotNull
    private Integer patientId;
}
