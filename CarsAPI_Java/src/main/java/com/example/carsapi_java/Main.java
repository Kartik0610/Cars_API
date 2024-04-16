package com.example.carsapi_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// The main entry point for the application
public class Main extends Application {

    // Start method for launching the application
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file that defines the application layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();

        // Set the scene with the loaded layout
        primaryStage.setScene(new Scene(root));

        // Set the title of the application window
        primaryStage.setTitle("Car Search");

        // Set the application icon
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/logo.png")));

        // Display the application window
        primaryStage.show();
    }

    // Main method for launching the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
