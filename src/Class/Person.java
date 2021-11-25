package Class;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import controller.InfoFilterImp;
import Ngoai_Le_exception.InvalidDateOfBirthException;
import Ngoai_Le_exception.InvalidEmailException;
import Ngoai_Le_exception.InvalidNameException;
import Ngoai_Le_exception.InvalidPersonIdException;
import Ngoai_Le_exception.InvalidPhoneNumberException;


public class Person implements Serializable {

    private String id;
    private FullName fullName;
    private Date dob;
    private String address;
    private String email;
    private String phoneNumber;

    public Person() {
        fullName = new FullName();
    }

    public Person(String id) throws InvalidPersonIdException {
        setId(id);
    }

    public Person(String id, String fullName, String dob,
            String address, String email, String phoneNumber) 
            throws InvalidPersonIdException, InvalidNameException, 
            InvalidDateOfBirthException, ParseException, InvalidEmailException, 
            InvalidPhoneNumberException {
        this(id);
        setFullName(fullName);
        setDob(dob);
        setAddress(address);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidPersonIdException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isPersonIdValid(id)) {
                this.id = id;
            }
        } catch (InvalidPersonIdException ex) {
            throw ex;
        }
    }

    public String getFullName() {
        return fullName.getLast()
                + fullName.getMid() + " " + fullName.getFirst();
    }

    public void setFullName(String fullName) throws InvalidNameException {
        this.fullName = new FullName();
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isNameValid(fullName)) {
                var words = fullName.split("\\s+");
                if (words.length > 0) {
                    this.fullName.setLast(words[0]);
                    this.fullName.setFirst(words[words.length - 1]);
                    var mName = " ";
                    for (int i = 1; i < words.length - 1; i++) {
                        mName += words[i];
                    }
                    this.fullName.setMid(mName);
                }
            }
        } catch (InvalidNameException ex) {
            throw ex;
        }
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob)
            throws InvalidDateOfBirthException, ParseException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isDOBValid(dob)) {
                this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            }
        } catch (InvalidDateOfBirthException | ParseException ex) {
            throw ex;
        }
    }
    
    public String getFirstName() {
        return fullName.first;
    }
    
    public String getLastName() {
        return fullName.last;
    }
    
    public String getMidName() {
        return fullName.mid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isEmailValid(email)) {
                this.email = email;
            }
        } catch (InvalidEmailException ex) {
            throw ex;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
            throws InvalidPhoneNumberException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isPhoneNumberValid(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            }
        } catch (InvalidPhoneNumberException ex) {
            throw ex;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    class FullName implements Serializable {

        private String first;
        private String last;
        private String mid;

        public FullName() {
            first = "";
            last = "";
            mid = "";
        }

        public FullName(String first) {
            this.first = first;
        }

        public FullName(String first, String last, String mid) {
            this.first = first;
            this.last = last;
            this.mid = mid;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }
    }
}
