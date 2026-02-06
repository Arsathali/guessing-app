package com.guessapp.app;

import java.util.Scanner;

import com.guessapp.exception.InvalidInputException;
import com.guessapp.model.GameConfig;
import com.guessapp.repository.StorageService;
import com.guessapp.service.GameController;
import com.guessapp.service.GuessValidator;
import com.guessapp.service.HintService;
import com.guessapp.service.ValidationService;

/**
 * MAIN CLASS
 *
 * Use Case 6: Game Restart & Exit
 *
 * This class coordinates the complete game lifecycle,
 * allowing the player to replay or exit gracefully.
 *
 * Responsibilities:
 * - Start a new game session
 * - Execute the guessing flow
 * - Persist game results
 * - Restart or exit based on user choice
 *
 * @author Developer
 * @version 6.0
 */
public class GuessingApp {
    
     public static void main(String[] args) throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);

        boolean restart;
        System.out.println("================================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("================================");



        /**
         * outer loop controls 
         * wheather a new game
         * should start
         */
        do{
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

            /**
             * player decides wheather to resart
             * or exit the game
             */
            restart = GameController.restartGame(scanner);

         }while(restart);
   }
}
