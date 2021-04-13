package com.app.doggi.utils.exceptions;

/**
 * Class representing exception when a dog brees does not have a color nested
 * @version 1.0
 *
 */
public class DogBreedDoesNotHaveColorException extends  RuntimeException {

    public DogBreedDoesNotHaveColorException(String message){
        super(message);
    }
}
