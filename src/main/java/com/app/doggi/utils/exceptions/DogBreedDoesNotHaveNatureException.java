package com.app.doggi.utils.exceptions;
/**
 * Class representing exception when a color does not exist
 * @version 1.0
 *
 */
public class DogBreedDoesNotHaveNatureException extends RuntimeException{

    public DogBreedDoesNotHaveNatureException(String message){
        super(message);
    }
}
