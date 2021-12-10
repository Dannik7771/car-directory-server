package com.drownedman.car_directory_server.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="car_title")
public class CarTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_title_id")
    private long carTitleId;

    @Column(name = "car_id")
    private long carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "body_type")
    private String bodyType;

    @Column(name = "min_cost")
    private int minCost;

    @ElementCollection
    @Column(name = "images")
    private List<String> images;

    public CarTitle() {
    }

    public long getCarTitleId() {
        return carTitleId;
    }

    public void setCarTitleId(long carTitleId) {
        this.carTitleId = carTitleId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
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
}
