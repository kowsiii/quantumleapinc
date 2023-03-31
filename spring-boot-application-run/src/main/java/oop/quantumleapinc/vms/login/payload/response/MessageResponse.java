package oop.quantumleapinc.vms.login.payload.response;

public class MessageResponse {

    private String status;
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}