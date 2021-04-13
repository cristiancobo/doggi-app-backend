package com.app.doggi.utils.exceptions;
/**
 * Class representing exception when user try to save a dog breed without nature attribute
 * @version 1.0
 *
 */
public class DogBreedNaturesMandatoryException extends  RuntimeException{
    public DogBreedNaturesMandatoryException(String message) {
        super(message);
    }
}
