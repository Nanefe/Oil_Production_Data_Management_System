package org.example.oil_well_production_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    private static final String URL =
            "jdbc:sqlite:production.db";

    public static void initializeDatabase() {

        try (
                Connection conn =
                        DriverManager.getConnection(URL);

                Statement stmt =
                        conn.createStatement()
        ) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS production_data (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    oil_rate REAL,
                    gas_rate REAL,
                    water_cut REAL
                )
            """);

            System.out.println("Database ready");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}