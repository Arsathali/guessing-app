package com.guessapp.app;

import java.util.Scanner;

import com.guessapp.exception.InvalidInputException;
import com.guessapp.model.GameConfig;
import com.guessapp.service.GuessValidator;
import com.guessapp.service.HintService;
import com.guessapp.service.ValidationService;

/**
 * MAIN CLASS
 *
 * Use Case 4: Error Handling & Validation
 *
 * This class coordinates the game execution while ensuring
 * all user inputs are safely validated before processing.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept user input
 * - Validate input using ValidationService
 * - Handle game flow without crashing on invalid input
 *
 * @author Developer
 * @version 4.0
 */
public class GuessingApp {
    
     public static void main(String[] args) throws InvalidInputException {

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
           
           /*
           * user input is validated before
           * being used in the game logic 
            */
           int input = ValidationService.validateInput(scanner.nextLine());
           attempts++;

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
