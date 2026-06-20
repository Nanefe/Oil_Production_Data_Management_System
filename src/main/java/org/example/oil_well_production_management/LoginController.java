
package org.example.oil_well_production_management;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin123")) {
            try {
                javafx.fxml.FXMLLoader loader =
                        new javafx.fxml.FXMLLoader(
                                getClass().getResource("dashboard.fxml")
                        );

                javafx.scene.Parent root = loader.load();

                javafx.stage.Stage stage = (javafx.stage.Stage)
                        usernameField.getScene().getWindow();

                stage.setScene(new javafx.scene.Scene(root));

            } catch (Exception e) {
                e.printStackTrace();
                messageLabel.setText("Failed to load dashboard");
            }
        } else {
            messageLabel.setText("Invalid credentials");
        }


    }
}