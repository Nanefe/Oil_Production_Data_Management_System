package org.example.oil_well_production_management;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewDataController {

    @FXML
    private TableView<ProductionRecord> tableView;

    @FXML
    private TableColumn<ProductionRecord, Double> oilColumn;

    @FXML
    private TableColumn<ProductionRecord, Double> gasColumn;

    @FXML
    private TableColumn<ProductionRecord, Double> waterColumn;


    @FXML
    public void initialize() {

        oilColumn.setCellValueFactory(
                new PropertyValueFactory<>("oilRate"));

        gasColumn.setCellValueFactory(
                new PropertyValueFactory<>("gasRate"));

        waterColumn.setCellValueFactory(
                new PropertyValueFactory<>("waterCut"));

        tableView.setItems(
                javafx.collections.FXCollections.observableArrayList(
                        Database.getAllRecords()
                )
        );
    }

    @FXML
    private void handleBack() {

        try {

            Parent root = FXMLLoader.load(
                    getClass().getResource(
                            "/org/example/oil_well_production_management/dashboard.fxml"));

            Stage stage = (Stage) tableView.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}