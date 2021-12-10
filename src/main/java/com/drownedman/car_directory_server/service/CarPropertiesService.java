package com.drownedman.car_directory_server.service;

import com.drownedman.car_directory_server.model.CarProperties;
import com.drownedman.car_directory_server.repository.CarPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPropertiesService {
    @Autowired
    private CarPropertiesRepository repository;

    public List<CarProperties> findCarPropertiesByCarId(long carId) {
        return repository.findByCarId(carId);
    }

    public CarProperties addCarProperties(CarProperties carProperties) {
        return repository.save(carProperties);
    }
}
