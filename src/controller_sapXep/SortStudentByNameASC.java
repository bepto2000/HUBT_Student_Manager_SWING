package controller_sapXep;

import java.util.Comparator;
import Class.Student;


public class SortStudentByNameASC implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
    
}
