package com.example.carsapi_java;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

// Controller class for displaying car details
public class CarDetailsController {

    // Injected FXML elements
    @FXML private Label makeLabel;
    @FXML private Label modelLabel;
    @FXML private Label yearLabel;
    @FXML private Label classLabel;
    @FXML private Label cylindersLabel;
    @FXML private Label displacementLabel;
    @FXML private Label fuelTypeLabel;
    @FXML private Label transmissionLabel;
    @FXML private Label driveLabel;
    @FXML private Label cityMpgLabel;
    @FXML private Label highwayMpgLabel;
    @FXML private Label combinationMpgLabel;

    // Reference to the MainController
    @FXML private MainController mainController;

    // Method to set car details on the labels
    @FXML
    public void setCar(Car car) {
        makeLabel.setText(car.getMake());
        modelLabel.setText(car.getModel());
        yearLabel.setText(String.valueOf(car.getYear()));
        classLabel.setText(car.getCarClass());
        cylindersLabel.setText(String.valueOf(car.getCylinders()));
        displacementLabel.setText(String.valueOf(car.getDisplacement()));
        fuelTypeLabel.setText(car.getFuelType());
        transmissionLabel.setText(car.getTransmission());
        driveLabel.setText(car.getDrive());
        cityMpgLabel.setText(String.valueOf(car.getCityMpg()));
        highwayMpgLabel.setText(String.valueOf(car.getHighwayMpg()));
        combinationMpgLabel.setText(String.valueOf(car.getCombinationMpg()));
    }

    // Method to set the MainController reference
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    // Method to navigate back to the car list view
    @FXML
    private void goBack() {
        mainController.showCarList();
    }
}
