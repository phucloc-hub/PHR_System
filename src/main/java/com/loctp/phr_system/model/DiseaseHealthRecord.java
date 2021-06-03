package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "disease_health_record")
public class DiseaseHealthRecord {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Patient_Id")
    private Integer patientId;

    @Column(name = "Disease_Id")
    private Integer diseaseId;

}
