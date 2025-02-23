package gr.aueb.cf.inspirecraft.core;

import gr.aueb.cf.inspirecraft.core.exceptions.*;
import gr.aueb.cf.inspirecraft.dto.ResponseMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppValidationException.class)
    public ResponseEntity<Map<String , String>> handleValidationException(AppValidationException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        Map<String , String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppObjectNotFoundException.class)
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectNotFoundException ex) {

        return new ResponseEntity<>(new ResponseMessageDTO(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppObjectAlreadyExistsException.class)
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectAlreadyExistsException ex) {

        return new ResponseEntity<>(new ResponseMessageDTO(ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AppObjectInvalidArgumentException.class)
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectInvalidArgumentException ex) {

        return new ResponseEntity<>(new ResponseMessageDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppObjectNotAuthorizedException.class)
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppObjectNotAuthorizedException ex) {

        return new ResponseEntity<>(new ResponseMessageDTO(ex.getMessage()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AppServerException.class)
    public ResponseEntity<ResponseMessageDTO> handleConstraintViolationException(AppServerException ex) {

        return new ResponseEntity<>(new ResponseMessageDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

