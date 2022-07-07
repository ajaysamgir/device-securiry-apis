package com.assesment.api.device.dto;

import java.util.Arrays;
import java.util.UUID;

import com.assesment.api.device.model.Device;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDetails {
	private String id;
	private String model;
	private String osVersion;
	private DeviceType type;

	private enum DeviceType {
		WEB("Web"), ANDROID("Android"), IOS("Ios");

		private final String type;

		DeviceType(String type) {
			this.type = type;
		}

		@JsonCreator
		public static DeviceType decode(final String type) {
			return Arrays.stream(DeviceType.values()).filter(targetType -> targetType.type.equals(type)).findFirst()
					.orElse(null);
		}

		@JsonValue
		public String getType() {
			return type;
		}
	}

	public static DeviceDetails from(Device device) {
		DeviceDetails details = new DeviceDetails();
		details.setId(device.getId());
		details.setModel(device.getModel());
		details.setOsVersion(device.getVersion());
		details.setType(DeviceType.valueOf(device.getType()));
		return details;
	}


	public static Device toDevice(DeviceDetails deviceDetails) {
		Device device = new Device();
		device.setId(UUID.randomUUID().toString());
		device.setModel(deviceDetails.getModel());
		device.setVersion(deviceDetails.getOsVersion());
		device.setType(deviceDetails.getType().name());
		return device;
	}

}
