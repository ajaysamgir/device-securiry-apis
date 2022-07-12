package com.assesment.api.device.controller;

import com.assesment.api.device.dto.DetectionDetails;
import com.assesment.api.device.dto.DeviceDetails;
import com.assesment.api.device.service.DeviceSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DeviceSecurityController {
	
	@Autowired
	private DeviceSecurityService deviceSecService;
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceSecurityController.class);
	
	@PostMapping(value = "/storing")
	public DeviceDetails addDevice(@RequestBody DeviceDetails deviceDetails) {
		logger.debug("IN DeviceController::addDevice");
		DeviceDetails details = deviceSecService.addDevice(deviceDetails);
		logger.debug("OUT DeviceController::addDevice");
		return details;
	}

	@PostMapping(value = "/detection/{deviceId}")
	public DetectionDetails addDevice(@PathVariable Long deviceId, @RequestBody DetectionDetails detectionDetails) {
		logger.debug("IN DeviceController::addDevice");
		DetectionDetails details = deviceSecService.reportDetection(deviceId, detectionDetails);
		logger.debug("OUT DeviceController::addDevice");
		return details;
	}
	
	@GetMapping("/detections/{deviceId}")
	public List<DetectionDetails> findDetection(@PathVariable Long deviceId) {
		logger.debug("IN DeviceController::addDevice");
		List<DetectionDetails> details = deviceSecService.getDetections(deviceId);
		logger.debug("OUT DeviceController::addDevice");
		return details;
	}

}