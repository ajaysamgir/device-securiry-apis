package com.assesment.api.device.repository;

import com.assesment.api.device.model.Detection;
import com.assesment.api.device.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetectionRepository extends JpaRepository<Detection, Long> {
    Optional<List<Detection>> findByDevice(Device device);
}
