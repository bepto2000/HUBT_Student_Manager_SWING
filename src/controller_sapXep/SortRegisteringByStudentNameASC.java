package controller_sapXep;

import java.util.Comparator;
import Class.Registering;


public class SortRegisteringByStudentNameASC implements Comparator<Registering> {

    @Override
    public int compare(Registering o1, Registering o2) {
        return o1.getStudent().getFirstName()
                .compareTo(o2.getStudent().getFirstName());
    }
    
}
