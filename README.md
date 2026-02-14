# 🎮 Guess The Number – Java GUI Game

![Java](https://img.shields.io/badge/Java-17+-blue)
![GUI](https://img.shields.io/badge/GUI-Swing-orange)
![Type](https://img.shields.io/badge/Application-Desktop-brightgreen)
![Difficulty](https://img.shields.io/badge/Level-Beginner--Friendly-blueviolet)
![Status](https://img.shields.io/badge/Project-Completed-success)
![License](https://img.shields.io/badge/License-Educational-lightgrey)

---

## 📌 Project Overview

**Guess The Number** is a Java-based desktop game developed using **Java Swing**.

The system generates a random number between **1 and 100**, and the player must guess the correct number within a limited number of attempts. After each guess, the system provides feedback whether the guess is too high, too low, or correct.

This project demonstrates:

* Object-Oriented Programming (OOP)
* GUI Development using Swing
* Event-Driven Programming
* Random Number Generation
* Score Calculation Logic
* Input Validation Handling

---

## 🎯 Game Features

* 🎲 Random number generation (1–100)
* 🔢 Limited attempts (7 attempts per round)
* 📉 High / Low hints
* 🏆 Score calculation based on remaining attempts
* 🔁 Multiple rounds support
* ⚠ Input validation for incorrect entries
* 🎨 Attractive and colorful GUI
* 🚫 Prevents invalid inputs
* 📊 Score tracking system

---

## 🕹️ How the Game Works

1. The system generates a random number between **1 and 100**.
2. The player enters a guess in the input field.
3. The system provides feedback:

   * "Too High"
   * "Too Low"
   * "Correct"
4. The player has a maximum of **7 attempts** per round.
5. Points are awarded based on remaining attempts.
6. Player can start a new round after completion.

---

## 🏗️ Project Structure

```
Guess-The-Number/
├── GuessTheNumberGame.java
└── README.md
```

---

## 🛠️ Technologies Used

| Technology   | Purpose           |
| ------------ | ----------------- |
| Java         | Core Programming  |
| Swing        | GUI Development   |
| AWT          | Event Handling    |
| Random Class | Number Generation |

---

## ▶️ How to Run

### Step 1: Compile

```
javac GuessTheNumberGame.java
```

### Step 2: Run

```
java GuessTheNumberGame
```

---

## 🎯 Concepts Implemented

* Classes & Objects
* Encapsulation
* ActionListener Interface
* Swing Components:

  * JFrame
  * JPanel
  * JButton
  * JLabel
  * JTextField
* Layout Management
* Exception Handling (NumberFormatException)
* Random Number Logic

---

## 📊 Scoring System

* Player earns points based on remaining attempts.
* Formula:

```
Points = Remaining Attempts × 10
```

Higher accuracy results in higher score.

---

## 🔒 Limitations

* No database integration
* No persistent high score storage
* Single-player game only
* Not designed for multiplayer

---

## 🚀 Future Enhancements

* High score file saving
* Difficulty levels (Easy / Medium / Hard)
* Timer-based challenge mode
* Sound effects
* Improved UI with JavaFX
* Multiplayer mode
