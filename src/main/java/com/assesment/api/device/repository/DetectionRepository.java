package com.assesment.api.device.repository;

import com.assesment.api.device.model.Detection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetectionRepository extends JpaRepository<Detection, Long> {
}
