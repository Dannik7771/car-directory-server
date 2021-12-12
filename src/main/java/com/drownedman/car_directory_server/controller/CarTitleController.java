package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.CarProperties;
import com.drownedman.car_directory_server.model.CarTitle;
import com.drownedman.car_directory_server.model.Client;
import com.drownedman.car_directory_server.security.JWTController;
import com.drownedman.car_directory_server.service.CarTitleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/car")
public class CarTitleController {
    @Autowired
    private CarTitleService service;

    @Autowired
    private JWTController jwtController;

    @GetMapping()
    public ResponseEntity<List<CarTitle>> getAllCarTitles() {
        log.info("get all carTitles request");
        return ResponseEntity.ok(service.getAllCarTitles());
    }

    @GetMapping("/id/{car_id}")
    ResponseEntity<CarTitle> findCarTitleByCarId(@PathVariable("car_id") long carId) {
        log.info("find car title request: {}", carId);
        return ResponseEntity.ok(service.findCarTitle(carId));
    }

    @GetMapping("/name/{brand_name}/{model_name}")
    ResponseEntity<CarTitle> findCarTitle(@PathVariable("model_name") String modelName,
                                          @PathVariable("brand_name") String brandName) {
        log.info("find car title request: {}, {}", brandName, modelName);
        return ResponseEntity.ok(service.findCarTitle(brandName, modelName));
    }

    @PostMapping()
    ResponseEntity<CarTitle> addCarTitle(@RequestBody CarTitle carTitle, @RequestHeader("Authorization") String token)
            throws JsonProcessingException {
        log.info("add car title request: {}", carTitle);
        if (jwtController.extractRoles(token).contains(Client.Role.Admin) ||
                jwtController.extractRoles(token).contains(Client.Role.Moder))
            return ResponseEntity.ok(service.addCarTitle(carTitle));
        else return ResponseEntity.badRequest().build();
    }
}
