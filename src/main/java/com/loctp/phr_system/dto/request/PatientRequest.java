package com.loctp.phr_system.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PatientRequest {
    @NotNull(message = "AccountId can't null")
    private Integer accountId;

    @NotNull(message = "BloodType can't null")
    private String bloodType;

    @NotNull(message = "Height can't null")
    private int height;

    @NotNull(message = "Weight can't null")
    private int weight;

    @NotNull(message = "MedicalNote can't null")
    private String medicalNote;

    @NotNull(message = "Image can't null")
    private String image;

    @NotNull(message = "Name can't null")
    private String name;

    @NotNull(message = "Dob can't null")
    private String doB;

    @NotNull(message = "Email can't null")
    private String email;

    @NotNull(message = "Address can't null")
    private String address;
}
