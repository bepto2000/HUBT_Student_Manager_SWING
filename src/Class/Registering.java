package Class;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Registering implements Serializable {

    private Student student;
    private Subject subject;
    private Date registedTime;

    public Registering() {
    }

    public Registering(Student student, Subject subject, Date registedTime) {
        this.student = student;
        this.subject = subject;
        this.registedTime = registedTime;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getRegistedTime() {
        return registedTime;
    }

    public void setRegistedTime(Date registedTime) {
        this.registedTime = registedTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.student);
        hash = 59 * hash + Objects.hashCode(this.subject);
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
        final Registering other = (Registering) obj;
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }
}
