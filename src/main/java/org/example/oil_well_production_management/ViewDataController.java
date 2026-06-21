package org.example.oil_well_production_management;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

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

        oilColumn.setCellValueFactory(new PropertyValueFactory<>("oilRate"));
        gasColumn.setCellValueFactory(new PropertyValueFactory<>("gasRate"));
        waterColumn.setCellValueFactory(new PropertyValueFactory<>("waterCut"));

        tableView.setItems(DashboardController.records);
    }

    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("dashboard.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) tableView.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}