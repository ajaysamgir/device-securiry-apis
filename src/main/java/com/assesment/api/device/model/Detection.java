package com.assesment.api.device.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "detection")
public class Detection {
    @Id
    @Column(name = "detection_id")
    private String id;

    @Column(name="time")
    private String time;

    @Column(name="app_name")
    private String model;

    @Column(name="app_type")
    private String version;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_uid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Device device;
}
