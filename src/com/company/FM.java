/**
 * @author Augsto Alonso 181085 y Angel Cuellar 18382
 *
 */


public class FM extends Frequency{
    /**
     * se crea  un constructor donde se instancia un arrayList
     * con las estaciones del tipo FM siguiendo un patron
     */
    public FM(){
        super("FM");
        for (double i =  87.9; i <= 107.9; i += 0.2) {
            stations.add(i);
        }
        setStation(stations.get(0));
    }
}