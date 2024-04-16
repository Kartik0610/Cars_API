module com.example.carsapi_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;


    opens com.example.carsapi_java to javafx.fxml;
    exports com.example.carsapi_java;
}