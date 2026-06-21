package org.example.oil_well_production_management;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DashboardController {
    public static ObservableList<ProductionRecord> records =
            FXCollections.observableArrayList();
    @FXML
    private TextField oilField;

    @FXML
    private TextField gasField;

    @FXML
    private TextField waterField;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleViewData() {
        try {
            javafx.fxml.FXMLLoader loader =
                    new javafx.fxml.FXMLLoader(
                            getClass().getResource("/org/example/oil_well_production_management/view-data.fxml")
                    );

            javafx.scene.Parent root = loader.load();

            javafx.stage.Stage stage =
                    (javafx.stage.Stage) oilField.getScene().getWindow();

            stage.setScene(new javafx.scene.Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSave() {
        double oil = Double.parseDouble(oilField.getText().trim().replace("%", ""));
        double gas = Double.parseDouble(gasField.getText().trim().replace("%", ""));
        double water = Double.parseDouble(waterField.getText().trim().replace("%", ""));

        records.add(new ProductionRecord(oil, gas, water));

        statusLabel.setText("Saved successfully");



    }
}