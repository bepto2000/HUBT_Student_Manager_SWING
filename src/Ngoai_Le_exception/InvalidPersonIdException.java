package Ngoai_Le_exception;


public class InvalidPersonIdException extends Exception {

    private String invalidId;

    public InvalidPersonIdException() {
    }

    public InvalidPersonIdException(String invalidId) {
        this.invalidId = invalidId;
    }

    public InvalidPersonIdException(String invalidId, String message) {
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
