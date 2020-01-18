package com.company;

interface RadioInterface {
    public String estacionActual();
    public boolean estado();
    public void onOff();
    public void cambiarFrecuencia();
    public void avanzar();
    public void guardar(int button);
    public void seleccionarEmisora(int button);
}