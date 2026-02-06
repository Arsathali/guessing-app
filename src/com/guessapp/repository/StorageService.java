package com.guessapp.repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Use Case 5: Game Result Storage
 *
 * This class is responsible for persisting
 * the final game result after the game ends.
 *
 * Results are stored in a file so that
 * game history is not lost after exit.
 */
public class StorageService {
    
    /**
     * Saves the final outcome of the game.
     *
     * Each record contains:
     * - Player name
     * - Number of attempts used
     * - Win or loss result
     *
     * @param player   name of the player
     * @param attempts number of attempts used
     * @param win      true if the player won, false otherwise
     */
    public static void saveResult(String player,int attempts, boolean isWon) {
        
        /**
         * try with resource ensures
         * that the writer is closed automatically
         * after the operation completes
         */
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("game_result.txt",true))){

            writer.write("Player : " +player + ", Attempts : "+attempts + ", Result : "+ (isWon ? "Won" : "Lose"));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Unable to Save the Game result.");
        }
    }
}
