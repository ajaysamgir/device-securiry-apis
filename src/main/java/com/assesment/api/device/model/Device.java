package com.assesment.api.device.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@ToString
@Entity
@Table(name = "device")
public class Device {
	@Id
    @Column(name = "device_uid")
    private String id;

    @Column(name="device_type")
    private String type;

    @Column(name="device_model")
    private String model;

    @Column(name="device_version")
    private String version;

}
