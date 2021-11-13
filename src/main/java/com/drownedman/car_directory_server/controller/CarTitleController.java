package com.drownedman.car_directory_server.controller;

import com.drownedman.car_directory_server.model.CarTitle;
import com.drownedman.car_directory_server.service.CarTitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/cartitles")
public class CarTitleController {
    CarTitleService service = new CarTitleService();

    @GetMapping("/readall")
    public ResponseEntity<List<CarTitle>> getAllCarTitles() {
        log.info("get all carTitles request");
        return ResponseEntity.ok(service.getAllCarTitles());
    }

    @GetMapping("/readbyid")
    ResponseEntity<CarTitle> findCarTitle(int carId) {
        log.info("find car title request: {}", carId);
        return ResponseEntity.ok(service.findCarTitle(carId));
    }

    @GetMapping("/readbyname")
    ResponseEntity<CarTitle> findCarTitle(String modelName, String brandName) {
        log.info("find car title request: {}, {}", modelName, brandName);
        return ResponseEntity.ok(service.findCarTitle(modelName, brandName));
    }

    @PostMapping("/create")
    ResponseEntity<Void> addCarTitle(CarTitle carTitle) {
        log.info("add car title request: {}", carTitle);
        return ResponseEntity.ok(service.addCarTitle(carTitle));
    }
}
