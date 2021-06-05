package com.loctp.phr_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDTO {
    private Integer id;
    private String comment;
    private Double rate;
    private java.sql.Date time;
    private java.sql.Date timeExpire;
    private String status;
    private Integer examinationId;
}
