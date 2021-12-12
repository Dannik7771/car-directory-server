package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.CarProperties;
import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.security.JWTController;
import com.drownedman.car_directory_server.service.CarPropertiesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/carproperties")
public class CarPropertiesController {
    @Autowired
    private CarPropertiesService service;

    @Autowired
    private JWTController jwtController;

    @GetMapping("/carId/{car_id}")
    ResponseEntity<List<CarProperties>> findCarPropertiesByCarId(@PathVariable("car_id") long carId) {
        log.info("find car properties request: {}", carId);
        return ResponseEntity.ok(service.findCarPropertiesByCarId(carId));
    }

    @PostMapping()
    ResponseEntity<CarProperties> addCarProperties(@RequestBody CarProperties carProperties, @RequestHeader("Authorization") String token) throws JsonProcessingException {
        log.info("add car properties request: {}", carProperties);
        if (jwtController.extractRoles(token).contains(Client.Role.Admin) ||
                jwtController.extractRoles(token).contains(Client.Role.Moder))
            return ResponseEntity.ok(service.addCarProperties(carProperties));
        else return ResponseEntity.badRequest().build();
    }
}
