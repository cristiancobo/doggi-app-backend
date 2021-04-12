package com.app.doggi.utils.exceptionhandler;

import com.app.doggi.utils.exceptions.DogBreedDoesNotExistException;
import com.app.doggi.utils.exceptions.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing global exception handler
 * @version 1.0
 */
@ControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exception, List<String> erros){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("message: "+ exception.getMessage());
        errorResponse.setStatus(httpStatus.value());
        errorResponse.setTimeStamp(new Date());
        errorResponse.setErrors(erros);
        return new ResponseEntity<>(errorResponse,httpStatus);
    }

    /**
     * Method that build a response
     * @param httpStatus
     * @param exception
     * @return
     */
    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, Exception exception){
        return buildResponseEntity(httpStatus, exception, null);
    }

    /**
     * Method that build a response when the data is invalid
     * @param exception
     * @return
     */
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(InvalidDataException exception){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<String> errors = exception.getBindingResult().
                getFieldErrors().stream().
                map(FieldError::getDefaultMessage).
                collect(Collectors.toList());
        return buildResponseEntity(httpStatus, new RuntimeException("Data sent was invalid"), errors);
    }

    /**
     * Method that build a response when dog breed does not exist.
     * @param exception
     * @return
     */
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(DogBreedDoesNotExistException exception){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(httpStatus, exception);
    }
}
