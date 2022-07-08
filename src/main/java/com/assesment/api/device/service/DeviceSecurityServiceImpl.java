package com.assesment.api.device.service;

import com.assesment.api.device.dto.DeviceDetails;
import com.assesment.api.device.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceSecurityServiceImpl implements DeviceSecurityService {
	
	@Autowired
	private DeviceRepository deviceRepository; 

	@Override
	public DeviceDetails addDevice(DeviceDetails deviceDetails) {
		var device = deviceRepository.save(DeviceDetails.toDevice(deviceDetails));
		return DeviceDetails.from(device);
	}

}
