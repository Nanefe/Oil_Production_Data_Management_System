package org.example.oil_well_production_management;

public class ProductionRecord {
    private double oilRate;
    private double gasRate;
    private double waterCut;

    public ProductionRecord(double oilRate, double gasRate, double waterCut) {
        this.oilRate = oilRate;
        this.gasRate = gasRate;
        this.waterCut = waterCut;
    }

    public double getOilRate() { return oilRate; }
    public double getGasRate() { return gasRate; }
    public double getWaterCut() { return waterCut; }
}