package controller_sapXep;

import java.util.Comparator;
import Class.Subject;


public class SortSubjectByNameASC implements Comparator<Subject> {
    
    @Override
    public int compare(Subject o1, Subject o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
