package com.app.doggi.utils.exceptions;

import org.springframework.validation.BindingResult;

/**
 * Class representing a invalid data exception.
 * @version 1.0
 */
public class InvalidDataException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final transient BindingResult bindingResult;

    public InvalidDataException(BindingResult bindingResult){
        super();
        this.bindingResult = bindingResult;
    }

    public InvalidDataException(String message, BindingResult bindingResult){
        super(message);
        this.bindingResult = bindingResult;
    }

    //Access methods
    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
