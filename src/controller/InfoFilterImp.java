package controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Ngoai_Le_exception.InvalidDateOfBirthException;
import Ngoai_Le_exception.InvalidEmailException;
import Ngoai_Le_exception.InvalidNameException;
import Ngoai_Le_exception.InvalidPersonIdException;
import Ngoai_Le_exception.InvalidPhoneNumberException;
import Ngoai_Le_exception.InvalidStudentIdException;
import Class.Registering;


public class InfoFilterImp implements InfoFilter {

    @Override
    public boolean isStudentIdValid(String studentId)
            throws InvalidStudentIdException {
        var regex = "^[a-z]\\d{2}[a-z]{4}\\d{3}$";
        Pattern idPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = idPattern.matcher(studentId);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Mã sinh viên không hợp lệ: " + studentId;
            throw new InvalidStudentIdException(studentId, msg);
        }
    }

    @Override
    public boolean isDOBValid(String dob) throws InvalidDateOfBirthException {
        var regex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern dobPattern = Pattern.compile(regex);
        Matcher matcher = dobPattern.matcher(dob);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Ngày sinh không hợp lệ: " + dob;
            throw new InvalidDateOfBirthException(dob, msg);
        }
    }

    @Override
    public boolean isEmailValid(String email) throws InvalidEmailException {
        var regex = "^[a-z]+[a-z0-9._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Email không hợp lệ: " + email;
            throw new InvalidEmailException(email, msg);
        }
    }

    @Override
    public boolean isNameValid(String name) throws InvalidNameException {
        if (name != null && name.length() > 0) {
            var regex = "^(\\w+.*[^0-9].*){2,40}$";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                return true;
            } else {
                var msg = "Họ tên không hợp lệ: " + name;
                throw new InvalidNameException(msg, name);
            }
        } else {
            var msg = "Họ tên không hợp lệ: " + name;
            throw new InvalidNameException(name, msg);
        }
    }

    @Override
    public boolean isPersonIdValid(String personId)
            throws InvalidPersonIdException {
        var regex = "^([A-Z0-9]){9,13}$";
        if (personId.matches(regex)) {
            return true;
        } else {
            var msg = "Số chứng minh/căn cước không hợp lệ: " + personId;
            throw new InvalidPersonIdException(personId, msg);
        }
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber)
            throws InvalidPhoneNumberException {
        var regex = "^(03|04|07|08|09)\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Số điện thoại không hợp lệ: " + phoneNumber;
            throw new InvalidPhoneNumberException(phoneNumber, msg);
        }
    }

    @Override
    public boolean isRecordExist(List<Registering> registerings, Registering r) {
        return registerings.contains(r);
    }

}
