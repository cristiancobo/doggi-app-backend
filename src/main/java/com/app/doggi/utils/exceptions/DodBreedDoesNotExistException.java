package com.app.doggi.utils.exceptions;

/**
 * Class representing exception when a dog breed does not exist
 * @version 1.0
 *
 */
public class DodBreedDoesNotExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DodBreedDoesNotExistException(String message){
        super(message);
    }
}
