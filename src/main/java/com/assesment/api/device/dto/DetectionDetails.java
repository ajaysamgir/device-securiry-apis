package com.assesment.api.device.dto;

import com.assesment.api.device.model.Detection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetectionDetails {
    private Long id;
    private LocalDate time;
    private String appName;
    private String appType;

    public static Detection toDetection(DetectionDetails detectionDetails) {
        var detection =  new Detection();
        detection.setId(detectionDetails.getId());
        detection.setTime(detectionDetails.getTime());
        detection.setAppName(detectionDetails.getAppName());
        detection.setAppType(detectionDetails.getAppType());
        return detection;
    }

    public static DetectionDetails fromDetection(Detection detection) {
        return new DetectionDetails(detection.getId(), detection.getTime(), detection.getAppName(), detection.getAppType());
    }
}
