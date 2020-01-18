package com.company;

import java.util.ArrayList;

public class AM extends Frequency{
    public AM(){
        super("AM");

        for (double i = 530; i <= 1610; i += 10) {

            stations.add(i);
        }
    }
}