package com.guessapp.exception;

/**
 * custom exception used when 
 * user input fails validation
 * 
 * this allows the game to fail
 * with gracefully with a 
 * meaningfull  message
 */
public class InvalidInputException extends Exception {
    
    public InvalidInputException(String message){
        super(message);
    }
}
