package com.drownedman.car_directory_server.repository;

import com.drownedman.car_directory_server.model.CarTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTitleRepository extends JpaRepository<CarTitle, Long> {
    CarTitle findByCarId(long carId);
    CarTitle findByBrandAndModel(String brand, String model);
}
