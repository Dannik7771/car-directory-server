package com.drownedman.car_directory_server.model;

import java.util.ArrayList;
import java.util.List;

public class CarTitle {
    //CarTitle, CarBodyType, CarCharacteristics
    private String brand;
    private String model;
    private int carId; //Идентификатор данной модели

    //Относятся к модели авто
    private String bodyType;
    private int minCost;
    private List<String> images;

    public CarTitle() {
        images = new ArrayList<>();
    }

    public CarTitle(String brand, String model, int carId, String bodyType, int minCost) {
        images = new ArrayList<>();
        this.brand = brand;
        this.model = model;
        this.carId = carId;
        this.bodyType = bodyType;
        this.minCost = minCost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getMinCost() {
        return minCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "CarTitle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carId=" + carId +
                ", bodyType='" + bodyType + '\'' +
                ", minCost=" + minCost +
                ", images=" + images +
                '}';
    }
}
