package com.app.doggi.utils.exceptions;
/**
 * Class representing exception when user try to save a dog breed without weight attribute
 * @version 1.0
 *
 */
public class DogBreedWeightMandatoryException extends RuntimeException {
    public DogBreedWeightMandatoryException(String message) {
        super(message);
    }
}
