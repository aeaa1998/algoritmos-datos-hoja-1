package com.company;

import java.util.ArrayList;

class Radio implements RadioInterface {
    private boolean state = false;
    private Frequency frequency;
    private final AM amStation = new AM();
    private final FM fmStation = new FM();
    private View view = new View();
    private ArrayList<RadioButton> buttons  = new ArrayList<>(){{
        for (int i = 0; i < 12; i++) {
            add(new RadioButton());
        }
    }};

    public Radio()
    {
        this.frequency = this.amStation;
    }

    public String estacionActual(){
        return "Estacion  actual " +
                this.frequency.getCurrentStation() + " radio " + this.frequency.getType();
    }

    public void onOff(){
        this.state = !this.state;
        view.print("El radio se encuentra " + ((this.state) ? "encendido" : "apagado"));
    }


    public boolean estado(){
        return this.state;
    }

    public void cambiarFrecuencia(){
        view.print("Su frecuencia actual es: " + this.frequency.getType());
        ArrayList<Frequency> frequencies = new ArrayList<>();
        frequencies.add(this.amStation);
        frequencies.add(this.fmStation);
        int index = view.selectOptions(frequencies, "Ingrese el número de opción que desea.", "Escoja una opcion valida.");
        this.frequency = frequencies.get(index);
        view.print("Su frecuencia actual es: " + this.frequency.getType());
    }

    public void cambiarFrecuencia(String type){
        view.print("Su frecuencia actual es: " + this.frequency.getType());
        this.frequency = type.equalsIgnoreCase("AM") ? this.amStation : this.fmStation;
        view.print("Su frecuencia actual es: " + this.frequency.getType());
    }

    public Frequency getFrequency(){
        return this.frequency;
    }


    public void avanzar(){
        this.frequency.forwardStation();
        view.print("Frecuencia: " + this.frequency.getType() +"\nEstacion Actual: " + this.frequency.getCurrentStation());
    }


    public void guardar(int button){
        ArrayList<Frequency> frequencies = new ArrayList<>();
        frequencies.add(this.amStation);
        frequencies.add(this.fmStation);
        int index = view.selectOptions(frequencies, "Ingrese el número de opción que desea como frecuencia para el boton."
                , "Escoja una opcion valida.");

        buttons.get(button).setType(frequencies.get(index));

        int stationIndex = view.selectOptions(frequencies.get(index).getStations(),
                "Escoja  el número de opción de estacion",
                "Escoja una opcion valida");
        buttons.get(button).setStation(frequencies.get(index).getStations().get(stationIndex));
    }

    public int selectButton(){
        return view.selectOptions(buttons, "Escoja el numero de boton.", "Escoja una opcion valida");
    }

    public void seleccionarEmisora(int button){
        if (buttons.get(button).isValid()){
            this.frequency = buttons.get(button).getType();
            this.frequency.setStation(buttons.get(button).getStation());
            view.print("Su frecuencia actual es: " + this.frequency.getType());
            view.print("Su estacion actual es: " + this.frequency.getCurrentStation());

        }else{
            view.print("El boton no se encuentra configurado por lo tanto no ha cambiado su frecuencia ni estacion.");
        }

    }
}
