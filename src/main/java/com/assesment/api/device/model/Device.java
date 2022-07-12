package com.assesment.api.device.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "device")
public class Device {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="device_type")
    private String type;

    @Column(name="device_model")
    private String model;

    @Column(name="device_version")
    private String version;
}
