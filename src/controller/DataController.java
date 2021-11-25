package controller;

import java.util.Date;
import java.util.List;
import Class.Course;
import Class.Registering;
import Class.Student;
import Class.Subject;

public interface DataController {

    int SUBJECT = 1;
    int STUDENT = 2;
    int REGISTERING = 3;
    String SUBJECT_FILE = "SUBJECT.DAT";
    String STUDENT_FILE = "STUDENT.DAT";
    String REGISTERING_FILE = "STU_REGISTER.DAT";

    <T> void writeToFile(List<T> data, String fileName);

    <T> List<T> readDataFromFile(String fileName);

    void updateSubjectId(List<Subject> subjects);

    void sortSubjectByNameASC(List<Subject> subjects);

    void sortSubjectByNameDESC(List<Subject> subjects);

    void sortSubjectByNumOfLessonASC(List<Subject> subjects);

    void sortSubjectByNumOfLessonDESC(List<Subject> subjects);

    List<Subject> searchSubjectByName(List<Subject> subjects, String key);

    List<Subject> searchSubjectByNumOfLesson(List<Subject> subjects,
            int from, int to);

    void sortStudentByIdASC(List<Student> students);
    
    void sortStudentByNameASC(List<Student> students);
    
    void sortStudentByNameDESC(List<Student> students);

    List<Student> searchStudentByName(List<Student> students, String name);

    List<Student> searchStudentById(List<Student> students, String id);

    List<Student> searchStudentByMajor(List<Student> students, String major);
    
    void sortRegisteringByStudentNameAZ(List<Registering> registerings);
    
    void sortRegisteringByStudentNameZA(List<Registering> registerings);
    // early to late
    void sortRegisteringByRegisterTimeEL(List<Registering> registerings);
    // late to early
    void sortRegisteringByRegisterTimeLE(List<Registering> registerings);
    
    List<Registering> searchRegisteringByStudentName(List<Registering> rs, 
            String key);
    
    List<Registering> searchRegisteringByRegisterTime(List<Registering> rs, 
            Date fromDate, Date toDate);
    
    List<Course> createCouse(List<Registering> rs, List<Subject> subjects);
}
