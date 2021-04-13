package com.app.doggi.utils.exceptions;
/**
 * Class representing exception when user try to save a dog breed without name attribute
 * @version 1.0
 *
 */
public class DogBreedNameMandatoryException extends RuntimeException{
    public DogBreedNameMandatoryException(String message) {
        super(message);
    }
}
