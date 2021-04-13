package com.app.doggi.utils.exceptions;

/**
 * Class representing exception when a color does not exist
 * @version 1.0
 *
 */
public class NatureDoesNotExistException extends RuntimeException{

    public NatureDoesNotExistException(String message){
        super(message);
    }
}
