package Ngoai_Le_exception;


public class InvalidEmailException extends Exception {

    private String invalidEmail;

    public InvalidEmailException() {
    }

    public InvalidEmailException(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    public InvalidEmailException(String invalidEmail, String message) {
        super(message);
        this.invalidEmail = invalidEmail;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }
}
