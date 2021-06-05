package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackageRequestDTO {
    private Integer id;
    private Integer testRequestId;
    private Integer packageId;
    private Integer testId;

}
