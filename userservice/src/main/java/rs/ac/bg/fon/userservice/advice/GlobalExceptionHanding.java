package rs.ac.bg.fon.userservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.bg.fon.userservice.exception.BadRequest;
import rs.ac.bg.fon.userservice.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHanding {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BadRequest> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        BadRequest badRequest = new BadRequest(userNotFoundException.getMessage());
        return new ResponseEntity<>(badRequest, HttpStatus.NOT_FOUND);
    }
}
