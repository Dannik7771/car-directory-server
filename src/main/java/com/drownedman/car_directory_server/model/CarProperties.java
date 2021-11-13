package com.drownedman.car_directory_server.model;

public class CarProperties {
    //Относятся к комплектации авто
    private int carId;
    private String equipment;
    private String fuelType;
    private short power;
    private short topSpeed;
    private short fuelTankVolume;
    private float engineVolume;
    private int numberOfCylinders;
    private String driveUnit;
    private boolean pressurization;

    public CarProperties(int carId, String equipment, String fuelType, short power,
                         short topSpeed, short fuelTankVolume, float engineVolume,
                         int numberOfCylinders, String driveUnit, boolean pressurization) {
        this.carId = carId;
        this.equipment = equipment;
        this.fuelType = fuelType;
        this.power = power;
        this.topSpeed = topSpeed;
        this.fuelTankVolume = fuelTankVolume;
        this.engineVolume = engineVolume;
        this.numberOfCylinders = numberOfCylinders;
        this.driveUnit = driveUnit;
        this.pressurization = pressurization;
    }

    public CarProperties() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
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