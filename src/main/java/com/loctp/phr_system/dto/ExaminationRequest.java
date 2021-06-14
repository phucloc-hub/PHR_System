package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ExaminationRequest {
    private Date date;

    @NotNull
    @NotEmpty
    private String type;

    @NotNull
    @NotEmpty
    private String decription;

    @NotNull
    private Integer patientId;

    @NotNull
    private Integer doctorId;

    @NotNull
    List<Integer> packageId;

    @NotNull
    List<Integer> testId;

}
