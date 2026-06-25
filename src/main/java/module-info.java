module org.example.oil_well_production_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.oil_well_production_management to javafx.fxml;
    exports org.example.oil_well_production_management;
}