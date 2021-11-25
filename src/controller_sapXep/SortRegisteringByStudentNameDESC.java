package controller_sapXep;

import java.util.Comparator;
import Class.Registering;


public class SortRegisteringByStudentNameDESC implements Comparator<Registering> {

    @Override
    public int compare(Registering o1, Registering o2) {
        return o2.getStudent().getFirstName()
                .compareTo(o1.getStudent().getFirstName());
    }
    
}
