/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */

package com.company;

import java.util.ArrayList;

public class AM extends Frequency{
    /**
     * se crea  un constructor donde se instancia un arrayList
     * con las estaciones del tipo FM siguiendo un patron
     */
    public AM(){
        super("AM");

        for (double i = 530; i <= 1610; i += 10) {
            stations.add(i);
        }
        setStation(stations.get(0));
    }
}