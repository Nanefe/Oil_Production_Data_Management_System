package org.example.oil_well_production_management;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Database.initializeDatabase();

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Oil Well Production Management System");
        stage.setScene(scene);
        stage.show();



    }
}
