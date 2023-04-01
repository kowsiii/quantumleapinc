package oop.quantumleapinc.vms.payload.email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
    private String email;
    private String message;
   

    public EmailRequest(String email, String message) {
        this.email =email;
        this.message = message;
    }


    public String getUsername() {
        return null;
    }

}
