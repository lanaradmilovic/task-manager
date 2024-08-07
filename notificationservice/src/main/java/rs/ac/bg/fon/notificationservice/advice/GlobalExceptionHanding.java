package rs.ac.bg.fon.notificationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.bg.fon.notificationservice.exception.BadRequest;
import rs.ac.bg.fon.notificationservice.exception.NotificationNotFoundException;

@ControllerAdvice
public class GlobalExceptionHanding {
    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<BadRequest> handleTaskNotFoundException(NotificationNotFoundException ex){
        BadRequest badRequest = new BadRequest(ex.getMessage());
        return new ResponseEntity<>(badRequest, HttpStatus.NOT_FOUND);
    }
}
