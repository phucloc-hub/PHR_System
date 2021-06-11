package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private Integer id;

    private String password;

    private String phone;

    private String roleId;

    private String status;
}
