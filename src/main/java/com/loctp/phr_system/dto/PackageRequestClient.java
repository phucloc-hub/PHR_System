package com.loctp.phr_system.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PackageRequestClient {
    @NotNull
    private Integer testRequestId;

    @NotNull
    private Integer packageId;

    @NotNull
    private Integer testId;
}
