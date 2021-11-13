package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.CarProperties;
import com.drownedman.car_directory_server.service.CarPropertiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/carproperties")
public class CarPropertiesController {
    CarPropertiesService service = new CarPropertiesService();

    @GetMapping("/readbyname")
    ResponseEntity<CarProperties> findCarProperties(int carId) {
        log.info("find car properties request: {}", carId);
        return ResponseEntity.ok(service.findCarProperties(carId));
    }

    @PostMapping("/create")
    ResponseEntity<Void> addCarProperties(CarProperties carProperties) {
        log.info("add car properties request: {}", carProperties);
        return ResponseEntity.ok(service.addCarProperties(carProperties));
    }
}
