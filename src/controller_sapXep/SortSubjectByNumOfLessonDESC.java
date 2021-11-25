package controller_sapXep;

import java.util.Comparator;
import Class.Subject;

public class SortSubjectByNumOfLessonDESC implements Comparator<Subject> {

    @Override
    public int compare(Subject o1, Subject o2) {
        return o2.getNumOfLesson() - o1.getNumOfLesson();
    }

}
