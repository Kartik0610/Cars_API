package com.example.carsapi_java;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Service class for retrieving car data from an external API
public class CarService {

    // URL of the external API
    private static final String API_URL = "https://api.api-ninjas.com/v1/cars";

    // API key for accessing the external API
    private static final String API_KEY = "op0gSgz+rpltUaT0gGtBmA==Jtr4nSkWhpRC67y7";

    // Method to retrieve cars by company name from the API
    public List<Car> getCarsByCompanyName(String companyName) {
        List<Car> cars = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = API_URL + "?make=" + companyName;
            HttpGet request = new HttpGet(url);

            // Set the API key in the request header
            request.setHeader("X-Api-Key", API_KEY);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            // If response entity is not null, parse the JSON and extract car data
            if (entity != null) {
                String json = EntityUtils.toString(entity);
                Gson gson = new Gson();
                JsonArray carsArray = gson.fromJson(json, JsonArray.class);

                // Iterate through the JSON array and extract car details
                for (JsonElement carElement : carsArray) {
                    JsonObject carObject = carElement.getAsJsonObject();
                    String make = carObject.get("make").getAsString();
                    String model = carObject.get("model").getAsString();
                    int year = carObject.get("year").getAsInt();

                    // Retrieve additional car details if available
                    String carClass = carObject.has("class") ? carObject.get("class").getAsString() : "";
                    int cylinders = carObject.has("cylinders") ? carObject.get("cylinders").getAsInt() : 0;
                    double displacement = carObject.has("displacement") ? carObject.get("displacement").getAsDouble() : 0.0;
                    String fuelType = carObject.has("fuel_type") ? carObject.get("fuel_type").getAsString() : "";
                    String transmission = carObject.has("transmission") ? carObject.get("transmission").getAsString() : "";
                    String drive = carObject.has("drive") ? carObject.get("drive").getAsString() : "";
                    int cityMpg = carObject.has("city_mpg") ? carObject.get("city_mpg").getAsInt() : 0;
                    int highwayMpg = carObject.has("highway_mpg") ? carObject.get("highway_mpg").getAsInt() : 0;
                    int combinationMpg = carObject.has("combination_mpg") ? carObject.get("combination_mpg").getAsInt() : 0;

                    // Create a new Car object with retrieved data
                    Car car = new Car(make, model, year);

                    // Set additional car details
                    car.setCarClass(carClass);
                    car.setCylinders(cylinders);
                    car.setDisplacement(displacement);
                    car.setFuelType(fuelType);
                    car.setTransmission(transmission);
                    car.setDrive(drive);
                    car.setCityMpg(cityMpg);
                    car.setHighwayMpg(highwayMpg);
                    car.setCombinationMpg(combinationMpg);

                    // Add the car to the list
                    cars.add(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
