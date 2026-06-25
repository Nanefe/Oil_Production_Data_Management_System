package org.example.oil_well_production_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String URL = "jdbc:sqlite:production.db";

    public static void initializeDatabase() {


        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("SQLite driver loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Connection conn = DriverManager.getConnection(URL);

            Statement stmt = conn.createStatement();

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS production_data(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    oil_rate REAL,
                    gas_rate REAL,
                    water_cut REAL
                )
            """);

            System.out.println("Database ready");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertRecord(double oil, double gas, double water) {

        String sql =
                "INSERT INTO production_data(oil_rate, gas_rate, water_cut) VALUES(?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setDouble(1, oil);
            pstmt.setDouble(2, gas);
            pstmt.setDouble(3, water);

            pstmt.executeUpdate();

            System.out.println("Record saved");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ProductionRecord> getAllRecords() {

        List<ProductionRecord> records = new ArrayList<>();

        String sql = "SELECT * FROM production_data";

        try (
                Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                records.add(
                        new ProductionRecord(
                                rs.getDouble("oil_rate"),
                                rs.getDouble("gas_rate"),
                                rs.getDouble("water_cut")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }

}