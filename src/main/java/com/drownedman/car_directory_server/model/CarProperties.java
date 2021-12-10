package com.drownedman.car_directory_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="car_properties")
public class CarProperties {
    //Относятся к комплектации авто
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "properties_id")
    private long propertiesId;

    @Column(name = "car_id")
    private long carId;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "power")
    private short power;

    @Column(name = "top_speed")
    private short topSpeed;

    @Column(name = "fuel_tank_volume")
    private short fuelTankVolume;

    @Column(name = "engine_volume")
    private float engineVolume;

    @Column(name = "number_of_cylinders")
    private int numberOfCylinders;

    @Column(name = "drive_unit")
    private String driveUnit;

    @Column(name = "pressurization")
    private boolean pressurization;

    public CarProperties() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public short getPower() {
        return power;
    }

    public void setPower(short power) {
        this.power = power;
    }

    public short getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(short topSpeed) {
        this.topSpeed = topSpeed;
    }

    public short getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(short fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(String driveUnit) {
        this.driveUnit = driveUnit;
    }

    public boolean isPressurization() {
        return pressurization;
    }

    public void setPressurization(boolean pressurization) {
        this.pressurization = pressurization;
    }

    @Override
    public String toString() {
        return "CarProperties{" +
                "carId=" + carId +
                ", equipment='" + equipment + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", power=" + power +
                ", topSpeed=" + topSpeed +
                ", fuelTankVolume=" + fuelTankVolume +
                ", engineVolume=" + engineVolume +
                ", numberOfCylinders=" + numberOfCylinders +
                ", driveUnit='" + driveUnit + '\'' +
                ", pressurization=" + pressurization +
                '}';
    }
}