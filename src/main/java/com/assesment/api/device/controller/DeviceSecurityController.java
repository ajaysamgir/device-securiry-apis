package com.assesment.api.device.controller;

import com.assesment.api.device.dto.DeviceDetails;
import com.assesment.api.device.service.DeviceSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
	
	@GetMapping("/")
	public String findDetection() {
		//TODO: implement flow
		return "";
	}

}