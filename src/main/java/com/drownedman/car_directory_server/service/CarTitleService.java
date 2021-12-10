package com.drownedman.car_directory_server.service;

import com.drownedman.car_directory_server.model.CarProperties;
import com.drownedman.car_directory_server.model.CarTitle;
import com.drownedman.car_directory_server.repository.CarPropertiesRepository;
import com.drownedman.car_directory_server.repository.CarTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTitleService {
    @Autowired
    private CarTitleRepository carTitleRepository;

    public List<CarTitle> getAllCarTitles() {
        return carTitleRepository.findAll();
    }

    public CarTitle findCarTitle(long carId) {
        return carTitleRepository.findByCarId(carId);
    }

    public CarTitle findCarTitle(String modelName, String brandName) {
        return carTitleRepository.findByBrandAndModel(modelName, brandName);
    }

    public CarTitle addCarTitle(CarTitle carTitle) {
        return carTitleRepository.save(carTitle);
    }
}
