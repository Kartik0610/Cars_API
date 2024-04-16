package com.example.carsapi_java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

// Controller class for the main view of the application
public class MainController {
    @FXML
    private TextField companyNameTextField;

    @FXML
    private ListView<Car> carListView;

    @FXML
    private BorderPane rootPane;

    private CarService carService;

    // Initialize method called after loading the FXML file
    public void initialize() {
        carService = new CarService();

        // Set up custom cell factory for the car list view
        carListView.setCellFactory(param -> new ListCell<Car>() {
            @Override
            protected void updateItem(Car car, boolean empty) {
                super.updateItem(car, empty);
                if (empty || car == null) {
                    setText(null);
                } else {
                    setText(car.getMake() + " " + car.getModel());
                }
            }
        });

        // Set up selection listener for the car list view
        carListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showCarDetails(newValue);
            }
        });
    }

    // Method to handle search button action
    @FXML
    private void searchCars() {
        String companyName = companyNameTextField.getText();
        ObservableList<Car> cars = FXCollections.observableArrayList(carService.getCarsByCompanyName(companyName));
        carListView.setItems(cars);
    }

    // Method to display the car list view
    public void showCarList() {
        rootPane.setCenter(carListView);
    }

    // Method to display car details when a car is selected
    private void showCarDetails(Car car) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("car-details.fxml"));
            Parent detailsView = loader.load();
            CarDetailsController controller = loader.getController();
            controller.setCar(car);
            controller.setMainController(this); // Pass the MainController instance to CarDetailsController
            rootPane.setCenter(detailsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
