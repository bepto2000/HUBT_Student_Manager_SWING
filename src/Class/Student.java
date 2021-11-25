package Class;

import java.text.ParseException;
import java.util.Objects;
import controller.InfoFilterImp;
import Ngoai_Le_exception.InvalidDateOfBirthException;
import Ngoai_Le_exception.InvalidEmailException;
import Ngoai_Le_exception.InvalidNameException;
import Ngoai_Le_exception.InvalidPersonIdException;
import Ngoai_Le_exception.InvalidPhoneNumberException;
import Ngoai_Le_exception.InvalidStudentIdException;

public class Student extends Person {

    private String studentId;
    private String studentClass;
    private String major;
    private String academicYear;

    public Student() {
        super();
    }

    public Student(String studentId) throws InvalidStudentIdException {
        setStudentId(studentId);
    }

    public Student(String id, String studentId) throws InvalidPersonIdException,
            InvalidStudentIdException {
        super(id);
        setStudentId(studentId);
    }

    public Student(String studentId, String studentClass,
            String major, String academicYear) throws InvalidStudentIdException {
        setStudentId(studentId);
        this.studentClass = studentClass;
        this.major = major;
        this.academicYear = academicYear;
    }

    public Student(String studentId, String studentClass,
            String major, String academicYear, String id)
            throws InvalidPersonIdException, InvalidStudentIdException {
        this(id, studentId);
        this.studentClass = studentClass;
        this.major = major;
        this.academicYear = academicYear;
    }

    public Student(String studentId, String studentClass, String major,
            String academicYear, String id, String fullName, String dob,
            String address, String email, String phoneNumber)
            throws InvalidStudentIdException, InvalidPersonIdException,
            InvalidNameException, InvalidDateOfBirthException, ParseException,
            InvalidEmailException, InvalidPhoneNumberException {
        super(id, fullName, dob, address, email, phoneNumber);
        setStudentId(studentId);
        setStudentClass(studentClass);
        setMajor(major);
        setAcademicYear(academicYear);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) throws InvalidStudentIdException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isStudentIdValid(studentId)) {
                this.studentId = studentId;
            }
        } catch (InvalidStudentIdException ex) {
            throw ex;
        }
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentClass="
                + studentClass + ", major=" + major + ", academicYear="
                + academicYear + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.studentId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        return true;
    }

}
