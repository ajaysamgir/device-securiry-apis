package com.assesment.api.device.service;

import com.assesment.api.device.dto.DetectionDetails;
import com.assesment.api.device.dto.DeviceDetails;

import java.util.List;

public interface DeviceSecurityService {

	DeviceDetails addDevice(DeviceDetails deviceDetails);

	DetectionDetails reportDetection(Long deviceId, DetectionDetails detectionDetails);

	List<DetectionDetails> getDetections(Long deviceId);
}
