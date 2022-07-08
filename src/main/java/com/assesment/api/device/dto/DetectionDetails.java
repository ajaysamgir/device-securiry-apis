package com.assesment.api.device.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetectionDetails {
    private String detectionId;
    private LocalDate time;
    private String appName;
    private String appType;
}
