package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AccountDTO {

    private Integer id;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String phone;

    private String roleId;

    private String status;
}
