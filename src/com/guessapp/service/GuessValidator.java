package com.guessapp.service;

/**
 * Use Case 2: User Guess Submission

 *
 * This class is responsible for comparing

 * the user's guess with the target number.

 *
 * It does NOT handle input or output.
 */
public class GuessValidator {
    
    /**
     * Compares the user's guess with the target number.

    * Returns the comparison result as a string.
    *
    * @param guess  The number guessed by the user
    * @param target The target number to be guessed

    * @return "CORRECT" if the guess matches the target,

    *         "LOW" if the guess is less than the target,

    *         "HIGH" if the guess is greater than the target

    */
    public static String validateGuess(int guess,int targetNumber){

        if(guess==targetNumber){
            return "CORRECT";
        }else if(guess < targetNumber){
            return "LOW";
        }
        return "HIGH";
    }
}
