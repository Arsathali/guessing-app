package com.guessapp.app;

import java.util.Scanner;
import com.guessapp.model.GameConfig;
import com.guessapp.service.GuessValidator;

/**
 * MAIN CLASS
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses

 * 3. Validate guesses
 * 4. Stop when game ends

 *
 * @author Developer
 * @version 2.0
 */
public class GuessingApp {
    
     public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");
        GameConfig gc = new GameConfig();
        gc.showRules();

        Scanner scanner = new Scanner(System.in);

        int attempts = 0;

        /*
        * Game loop runs until the player
        * exhausts the maximum attempts.
        */
        while(attempts < gc.getMaxAttempts()){

           System.out.println("Enter Your Guess: ");
           int input = scanner.nextInt();

           String result = GuessValidator.validateGuess(input,gc.getTargetNumber());

           System.out.println(result);

           // Break the loop if the guess is correct
           if(result.equals("CORRECT")){
               break;
           }
        }

     }
}
