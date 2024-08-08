package rs.ac.bg.fon.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BadRequest {
    private String message;
    public BadRequest(String message) {
        this.message = message;
    }

    public BadRequest() {
    }
}
