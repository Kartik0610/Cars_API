package com.example.carsapi_java;

// Class representing a Car
public class Car {
    // Fields representing car attributes
    private String make;
    private String model;
    private int year;
    private String carClass;
    private int cylinders;
    private double displacement;
    private String fuelType;
    private String transmission;
    private String drive;
    private int cityMpg;
    private int highwayMpg;
    private int combinationMpg;

    // Constructor with mandatory attributes
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and setters for all fields

    // Get the make of the car
    public String getMake() {
        return make;
    }

    // Set the make of the car
    public void setMake(String make) {
        this.make = make;
    }

    // Get the model of the car
    public String getModel() {
        return model;
    }

    // Get the year of the car
    public int getYear() {
        return year;
    }

    // Get the car class
    public String getCarClass() {
        return carClass;
    }

    // Set the car class
    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    // Get the number of cylinders
    public int getCylinders() {
        return cylinders;
    }

    // Set the number of cylinders
    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    // Get the engine displacement
    public double getDisplacement() {
        return displacement;
    }

    // Set the engine displacement
    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    // Get the fuel type
    public String getFuelType() {
        return fuelType;
    }

    // Set the fuel type
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Get the transmission type
    public String getTransmission() {
        return transmission;
    }

    // Set the transmission type
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    // Get the drive type
    public String getDrive() {
        return drive;
    }

    // Set the drive type
    public void setDrive(String drive) {
        this.drive = drive;
    }

    // Get the city MPG
    public int getCityMpg() {
        return cityMpg;
    }

    // Set the city MPG
    public void setCityMpg(int cityMpg) {
        this.cityMpg = cityMpg;
    }

    // Get the highway MPG
    public int getHighwayMpg() {
        return highwayMpg;
    }

    // Set the highway MPG
    public void setHighwayMpg(int highwayMpg) {
        this.highwayMpg = highwayMpg;
    }

    // Get the combination MPG
    public int getCombinationMpg() {
        return combinationMpg;
    }

    // Set the combination MPG
    public void setCombinationMpg(int combinationMpg) {
        this.combinationMpg = combinationMpg;
    }

    // Override toString method to provide a string representation of the Car object
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", carClass='" + carClass + '\'' +
                ", cylinders=" + cylinders +
                ", displacement=" + displacement +
                ", fuelType='" + fuelType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", drive='" + drive + '\'' +
                ", cityMpg=" + cityMpg +
                ", highwayMpg=" + highwayMpg +
                ", combinationMpg=" + combinationMpg +
                '}';
    }
}
