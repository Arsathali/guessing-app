package com.guessapp.model;

import java.util.Random;

public class GameConfig {
    
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPS = 7;
    private final int MAX_HINTS = 3;

    int targetNumber;

    /**
    * Constructor is automatically called when a GameConfig object is created.
    * It initializes the random target number for the game.
    */
    public GameConfig(){
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN) - MIN;
    }

    public int getTargetNumber(){ return targetNumber; }

    public int getMaxAttempts(){ return MAX_ATTEMPS; }

    public int getMaxHints(){ return MAX_HINTS; }

    public void showRules(){
        System.out.println("Guess a number between " + MIN +  " and "+ MAX);
        System.out.println("You have " + MAX_ATTEMPS + " Attempts");
        System.out.println("Hints Will be provided after wrong guesses.\n");
    }


}
