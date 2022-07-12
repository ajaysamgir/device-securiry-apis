package com.assesment.api.device.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "detection")
public class Detection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="time")
    private LocalDate time;

    @Column(name="app_name")
    private String appName;

    @Column(name="app_type")
    private String appType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_uid", referencedColumnName = "id")
    private Device device;
}
