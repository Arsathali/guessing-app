package com.guessapp.service;

import java.util.Scanner;

/**
 * Handles game lifecycle decisions.
 *
 * This class is responsible for deciding
 * whether the game should restart or exit
 * based on user choice.
 */
public class GameController {
    
    /**
     * Asks the player if they want to
     * restart the game after completion.
     *
     * @param scanner Scanner instance for reading user input
     * @return true if the game should restart,
     *         false if the application should exit
     */
    public static boolean restartGame(Scanner sc){
        System.out.println("Do you want to play Again (Yes/No)");
       return sc.nextLine().equalsIgnoreCase("yes");
    }
}
