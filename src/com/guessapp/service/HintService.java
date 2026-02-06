package com.guessapp.service;
/*
* Use Case 3: Hint Generation
 * This class is responsible for generating hints to assist the player
 * in guessing the correct number.
 Hints are provided after incorrect guesses
 * and are designed to progressively guide the player without revealing the exact number.
 * Demonstrates:
 * - Conditional logic
 * - Modulus and arithmetic operators
 * - Method abstraction
 * - Encapsulation of hint logic
 */
public class HintService {
    /*
     * Generates a hint based on the target number and the current hint count.
     * The hint logic is designed to provide meaningful clues without revealing
     * the exact number.
     * @param target    The target number to be guessed.
     * @param hintCount The current hint count.
     * @return A string containing the hint message.
     */
    public static String hintGenerator(int hintCount,int target){

        if(hintCount == 0){
           return (target%2==0) 
                        ? "Hint: The Target is Even Number" 
                        : "Hint: The Target Is Odd Number";
        }
        else if(hintCount==1){
            return (target < 50)
                        ? "Hint: The Target is less than 50"
                        : "Hint: The Target is Greater than 50";
        }
        else return "No More Hints Available"; 
    }
}
