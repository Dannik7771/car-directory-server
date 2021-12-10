package com.drownedman.car_directory_server.repository;

import com.drownedman.car_directory_server.model.CarProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarPropertiesRepository extends JpaRepository<CarProperties, Long> {
    List<CarProperties> findByCarId(long carId);
}
