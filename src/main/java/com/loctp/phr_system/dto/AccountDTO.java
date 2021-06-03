package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
@Getter
@Setter
public class AccountDTO {

    private String id;

    private String username;

    private String roleId;

}
