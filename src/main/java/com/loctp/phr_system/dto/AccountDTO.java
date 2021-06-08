package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private Integer id;

    private String username;

    private String password;

    private String roleId;

    private String status;
}
