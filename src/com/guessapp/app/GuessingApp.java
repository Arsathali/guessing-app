package com.guessapp.app;

import java.util.Scanner;
import com.guessapp.model.GameConfig;
import com.guessapp.service.GuessValidator;
import com.guessapp.service.HintService;

/**
 * MAIN CLASS
 * Use Case 3: Hint Generation
 * This class coordinates the game flow, including the generation of hints
 * to assist the player in guessing the correct number. Hints are provided
 * after incorrect guesses, and the hint count is incremented after each hint.
 *  *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Display hint messages to the player
 *
 * @author Developer
 * @version 3.0
 */
public class GuessingApp {
    
     public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");
        GameConfig gc = new GameConfig();
        gc.showRules();

        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        int hints = 0;
        /*
        * Game loop runs until the player
        * exhausts the maximum attempts.
        */
        while(attempts < gc.getMaxAttempts()){

           System.out.println("Enter Your Guess: ");
           int input = scanner.nextInt();

           String result = GuessValidator.validateGuess(input,gc.getTargetNumber());

           if(!result.equals("CORRECT") && hints < gc.getMaxHints()){
              System.out.println(HintService.hintGenerator(hints,gc.getTargetNumber()));
              hints++;
           }

           System.out.println(result);

           // Break the loop if the guess is correct
           if(result.equals("CORRECT")){
               break;
           }
        }

     }
}
