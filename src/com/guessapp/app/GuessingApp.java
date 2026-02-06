package com.guessapp.app;

import java.util.Scanner;

import com.guessapp.exception.InvalidInputException;
import com.guessapp.model.GameConfig;
import com.guessapp.repository.StorageService;
import com.guessapp.service.GuessValidator;
import com.guessapp.service.HintService;
import com.guessapp.service.ValidationService;

/**
 * MAIN CLASS
 *
 * Use Case 5: Game Result Storage
 *
 * This class coordinates the complete game flow
 * and persists the final result after completion.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author Developer
 * @version 5.0
 */
public class GuessingApp {
    
     public static void main(String[] args) throws InvalidInputException {

        System.out.println("================================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("================================");

        Scanner scanner = new Scanner(System.in);

        /**
         * player name captured once 
         * and stored along with game result
         */

        System.out.println("Enter the Player Name : ");
        String player = scanner.nextLine();

        GameConfig gc = new GameConfig();
        gc.showRules();

        

        int attempts = 0;
        int hints = 0;

        boolean win = false;

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
               win = true;
               break;
           }
        }

        /**
         * final game result is persisted
         * after the game loop completes
         */
        StorageService.saveResult(player, attempts, win);

     }
}
