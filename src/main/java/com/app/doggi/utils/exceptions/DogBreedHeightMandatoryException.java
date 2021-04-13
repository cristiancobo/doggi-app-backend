package com.app.doggi.utils.exceptions;

/**
 * Class representing exception when user try to save a dog breed without height attribute
 * @version 1.0
 *
 */
public class DogBreedHeightMandatoryException extends RuntimeException {

    public DogBreedHeightMandatoryException(String message) {
        super(message);
    }
}
