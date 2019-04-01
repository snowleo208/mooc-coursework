# Week 4: Problem Set - Hangman Word Game

## Requirements

Here are the requirements for the game:

- The computer must select a word at random from the list of available words that was provided in words.txt. The functions for loading the word list and selecting a random word have already been provided for you in ps3_hangman.py.

- The game must be interactive; the flow of the game should go as follows:

1. At the start of the game, let the user know how many letters the computer's word contains.

2. Ask the user to supply one guess (i.e. letter) per round.

3. The user should receive feedback immediately after each guess about whether their guess appears in the computer's word.

4. After each round, you should also display to the user the partially guessed word so far, as well as letters that the user has not yet guessed.

### Some additional rules of the game:

- A user is allowed 8 guesses. Make sure to remind the user of how many guesses s/he has left after each round. Assume that players will only ever submit one character at a time (A-Z).

- A user loses a guess only when s/he guesses incorrectly.

- If the user guesses the same letter twice, do not take away a guess - instead, print a message letting them know they've already guessed that letter and ask them to try again.

- The game should end when the user constructs the full word or runs out of guesses. If the player runs out of guesses (s/he "loses"), reveal the word to the user when the game ends.

## How to run Hangman?

Clone this repo and enter `python ps3_hangman.py` in terminal for my solutions. The set1-4.py is for my own testing purposes, all are grouped into ps3_hangman.py after finished.
