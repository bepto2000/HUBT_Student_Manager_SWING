package controller_sapXep;

import java.util.Comparator;
import Class.Registering;


public class SortRegisteringByRegisterTimeASC implements Comparator<Registering> {

    @Override
    public int compare(Registering o1, Registering o2) {
        return (int)(o1.getRegistedTime().getTime() 
                - o2.getRegistedTime().getTime());
    }
    
}