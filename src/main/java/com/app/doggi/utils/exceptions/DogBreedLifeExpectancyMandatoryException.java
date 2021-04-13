package com.app.doggi.utils.exceptions;
/**
 * Class representing exception when user try to save a dog breed without life expectancy attribute
 * @version 1.0
 *
 */
public class DogBreedLifeExpectancyMandatoryException extends RuntimeException {
    public DogBreedLifeExpectancyMandatoryException(String message) {
        super(message);
    }
}
