package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.CarProperties;
import com.drownedman.car_directory_server.model.CarTitle;
import com.drownedman.car_directory_server.service.CarTitleService;
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
        log.info("find car title request: {}, {}", modelName, brandName);
        return ResponseEntity.ok(service.findCarTitle(modelName, brandName));
    }

    @PostMapping()
    ResponseEntity<CarTitle> addCarTitle(@RequestBody CarTitle carTitle) {
        log.info("add car title request: {}", carTitle);
        return ResponseEntity.ok(service.addCarTitle(carTitle));
    }
}
