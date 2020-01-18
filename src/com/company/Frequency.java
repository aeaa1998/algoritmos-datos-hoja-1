package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Frequency {
    private String type;
    protected ArrayList<Double> stations = new ArrayList<>();
    private double currentStation = 0;
    private int stationIndex = 0;
    private View view = new View();
    public Frequency(String type, ArrayList<Double> stations){
        this.type = type;
        this.stations = stations;
        this.currentStation = stations.get(this.stationIndex);
    }

    public Frequency(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Double> getStations() {
        return stations;
    }

    double getCurrentStation() {
        DecimalFormat df = new DecimalFormat("#.##");
        double station = Double.parseDouble(df.format(this.currentStation));
        return station;
    }

    void forwardStation(){
        this.stationIndex++;
        if (this.stationIndex == this.stations.size()) this.stationIndex = 0;
        this.currentStation = this.stations.get(this.stationIndex);
        DecimalFormat df = new DecimalFormat("#.##");
        double station = Double.parseDouble(df.format(this.currentStation));
        view.print("A avanzado a la estacion " + station + " " + this.type);
    }

    public String toString() {
        return "Radio: " + this.type;
    }

    public void setStation(Double station){
        this.currentStation = station;
        this.stationIndex = stations.indexOf(station);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}