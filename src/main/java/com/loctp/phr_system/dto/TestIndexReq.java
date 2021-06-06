package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class TestIndexReq {

    @NotNull
    private String name;

    @NotNull
    private String status;

    private String description;

    @NotNull
    @NotEmpty
    @Size(min = 1)
    private List<TestResultSampleDTO> samplelst;

}
