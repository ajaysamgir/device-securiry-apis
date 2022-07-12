package com.assesment.api.device.service;

import com.assesment.api.device.dto.DetectionDetails;
import com.assesment.api.device.dto.DeviceDetails;
import com.assesment.api.device.model.Detection;
import com.assesment.api.device.model.Device;
import com.assesment.api.device.repository.DetectionRepository;
import com.assesment.api.device.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceSecurityServiceImpl implements DeviceSecurityService {
	
	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
	private DetectionRepository detectionRepository;

	@Override
	public DeviceDetails addDevice(DeviceDetails deviceDetails) {
		var device = deviceRepository.save(DeviceDetails.toDevice(deviceDetails));
		return DeviceDetails.from(device);
	}

	@Override
	public DetectionDetails reportDetection(Long deviceId, DetectionDetails detectionDetails) {
		Optional<Device> deviceOption = deviceRepository.findById(deviceId);
		if(deviceOption.isPresent()) {
			Detection detection = DetectionDetails.toDetection(detectionDetails);
			detection.setDevice(deviceOption.get());
			Detection result = detectionRepository.save(detection);
			return DetectionDetails.fromDetection(result);
		}
		throw new RuntimeException("Device Not Found!");
	}

	@Override
	public List<DetectionDetails> getDetections(Long deviceId) {
		Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
		if(deviceOptional.isPresent()) {
			Optional<List<Detection>> detectionList= detectionRepository.findByDevice(deviceOptional.get());
			if (detectionList.isPresent() && !detectionList.get().isEmpty()) {
				return detectionList.get().stream()
						.map(DetectionDetails::fromDetection)
						.collect(Collectors.toList());
			} else {
				throw new RuntimeException("Data Not Found");
			}
		}
		else {
			throw new RuntimeException("Device Not Found");
		}
	}
}
