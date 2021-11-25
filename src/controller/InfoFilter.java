package controller;

import java.util.List;
import Ngoai_Le_exception.InvalidDateOfBirthException;
import Ngoai_Le_exception.InvalidEmailException;
import Ngoai_Le_exception.InvalidNameException;
import Ngoai_Le_exception.InvalidPersonIdException;
import Ngoai_Le_exception.InvalidPhoneNumberException;
import Ngoai_Le_exception.InvalidStudentIdException;
import Class.Registering;


public interface InfoFilter {

    boolean isStudentIdValid(String studentId) 
            throws InvalidStudentIdException;

    boolean isDOBValid(String dob) throws InvalidDateOfBirthException;

    boolean isEmailValid(String email) throws InvalidEmailException;

    boolean isNameValid(String name) throws InvalidNameException;

    boolean isPersonIdValid(String personId) throws InvalidPersonIdException;

    boolean isPhoneNumberValid(String phoneNumber) 
            throws InvalidPhoneNumberException;
    boolean isRecordExist(List<Registering> registerings, Registering r);
}
