package com.company;

import java.text.DecimalFormat;

class RadioButton{
    private Frequency type;
    private double station;

    public RadioButton(){
        this.type = null;
        this.station = 0.0;
    }

    public Frequency getType() {
        return type;
    }

    public void setType(Frequency type) {
        this.type = type;
    }

    public double getStation() {
        return station;
    }

    public void setStation(double station) {
        this.station = station;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        double stationC = Double.parseDouble(df.format(this.station));
        return "Boton: " + (this.type != null ? this.type.getType() : "no seteado") + "\nEstacion: "
                + (this.station != 0.0 ? String.valueOf(stationC) : "sin estacion seteada");
    }

    public boolean isValid(){
        return  this.type != null;
    }
}