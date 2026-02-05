package com.guessapp.app;

import com.guessapp.model.GameConfig;

public class GuessingApp {
    
     public static void main(String[] args) {
        
        System.out.println("Welcome to the Guessing App");
        GameConfig gc = new GameConfig();
        gc.showRules();
     }
}
