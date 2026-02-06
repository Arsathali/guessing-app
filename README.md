# Guessing App

A Java console-based number guessing game that demonstrates clean
application flow, input validation, result persistence, and game
restart/exit handling.

---

## 🚀 Features

- Random number generation for each game
- Safe user input validation using custom exceptions
- Hint generation for each guess (higher / lower)
- Persistent storage of game results in a file
- Option to restart the game or exit gracefully

---

## 📂 Project Structure

com/guessapp
├── app
│ └── GuessingApp.java # Main application entry point
│
├── controller
│ └── GameController.java # Handles restart / exit logic
│
├── service
│ └── ValidationService.java # Validates user input
│
├── repository
│ └── StorageService.java # Stores game results
│
└── exception
└── InvalidInputException.java


---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Arsathali/guessing-app.git
Navigate into the project:

cd guessing-app
Compile the source code:

javac -d out src/**/*.java
Run the application:

java -cp out com.guessapp.app.GuessingApp
🎮 Game Flow
The game generates a random number.

The player guesses within a limited number of attempts.

Hints are displayed for incorrect guesses.

After completion, the game result is saved to game_result.txt.

The player can choose to restart or exit.

📁 Result Storage
Game results are stored persistently in a text file:

Player: Alex, Attempts: 4, Result: Won
🧠 Learning Objectives
This project demonstrates:

Clean package separation

Custom exception handling

File I/O using BufferedWriter

Console-based application design

Use-case driven development
