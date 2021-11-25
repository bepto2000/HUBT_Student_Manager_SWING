package Ngoai_Le_exception;

public class InvalidStudentIdException extends Exception {

    private String invalidId;

    public InvalidStudentIdException() {
    }

    public InvalidStudentIdException(String invalidId) {
        this.invalidId = invalidId;
    }

    public InvalidStudentIdException(String invalidId, String message) {
        super(message);
        this.invalidId = invalidId;
    }

    public String getInvalidId() {
        return invalidId;
    }

    public void setInvalidId(String invalidId) {
        this.invalidId = invalidId;
    }
}
