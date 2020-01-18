package com.company;

import java.util.ArrayList;

public class FM extends Frequency{
    public FM(){
        super("FM");
        for (double i =  87.9; i <= 107.9; i += 0.2) {
            stations.add(i);
        }
        setStation(stations.get(0));
    }
}