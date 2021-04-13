package com.app.doggi.utils.exceptions;

/**
 * Class representing exception when user try to save a dog breed without color attribute
 * @version 1.0
 *
 */
public class DogBreedColorsMandatoryException extends  RuntimeException {

    public DogBreedColorsMandatoryException(String message){
        super(message);
    }


}
