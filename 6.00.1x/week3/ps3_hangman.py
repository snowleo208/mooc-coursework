# Hangman game
#

# -----------------------------------
# Helper code
# You don't need to understand this helper code,
# but you will have to know how to use the functions
# (so be sure to read the docstrings!)

import random

WORDLIST_FILENAME = "words.txt"

def loadWords():
    """
    Returns a list of valid words. Words are strings of lowercase letters.
    
    Depending on the size of the word list, this function may
    take a while to finish.
    """
    print("Loading word list from file...")
    # inFile: file
    inFile = open(WORDLIST_FILENAME, 'r')
    # line: string
    line = inFile.readline()
    # wordlist: list of strings
    wordlist = line.split()
    print("  ", len(wordlist), "words loaded.")
    return wordlist

def chooseWord(wordlist):
    """
    wordlist (list): list of words (strings)

    Returns a word from wordlist at random
    """
    return random.choice(wordlist)

# end of helper code
# -----------------------------------

# Load the list of words into the variable wordlist
# so that it can be accessed from anywhere in the program
wordlist = loadWords()

def isWordGuessed(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: boolean, True if all the letters of secretWord are in lettersGuessed;
      False otherwise
    '''
    # FILL IN YOUR CODE HERE...
    guessed = 0
    for c in secretWord:
      if c in lettersGuessed:
        guessed += 1
    return guessed == len(secretWord)



def getGuessedWord(secretWord, lettersGuessed):
    '''
    secretWord: string, the word the user is guessing
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters and underscores that represents
      what letters in secretWord have been guessed so far.
    '''
    # FILL IN YOUR CODE HERE...
    final = list(secretWord)
    count = 0
    while (count < len(secretWord)):
      if final[count] not in lettersGuessed:
        final[count] = '_'
      count += 1
    return "".join(final)



def getAvailableLetters(lettersGuessed):
    '''
    lettersGuessed: list, what letters have been guessed so far
    returns: string, comprised of letters that represents what letters have not
      yet been guessed.
    '''
    # FILL IN YOUR CODE HERE...
    import string
    allChar = list(string.ascii_lowercase)

    for c in lettersGuessed:
        if c in allChar:
            allChar.remove(c)
    return "".join(allChar)

def hangman(secretWord):
    '''
    secretWord: string, the secret word to guess.

    Starts up an interactive game of Hangman.

    * At the start of the game, let the user know how many 
      letters the secretWord contains.

    * Ask the user to supply one guess (i.e. letter) per round.

    * The user should receive feedback immediately after each guess 
      about whether their guess appears in the computers word.

    * After each round, you should also display to the user the 
      partially guessed word so far, as well as letters that the 
      user has not yet guessed.

    Follows the other limitations detailed in the problem write-up.
    '''
    # FILL IN YOUR CODE HERE...
    guess = 8
    correct = False
    guessedList = []
    currentGuess = ''

    print('Welcome to the game, Hangman!')
    print('I am thinking of a word that is ' + str(len(secretWord)) + ' letters long.')
    print('-------------')

    while (isWordGuessed(secretWord, guessedList) == False):
      if guess == 0:
        break
      print('You have ' + str(guess) + ' guesses left.')
      print('Available letters: ' + getAvailableLetters(guessedList))
      currentGuess = str(input('Please guess a letter: '))

      ''' continue ask for input if already guessed that letter '''
      if currentGuess in guessedList or currentGuess == '':
        print("Oops! You've already guessed that letter: " + getGuessedWord(secretWord, guessedList))
        print('-------------')
        continue

      guessedList.append(currentGuess)
      if currentGuess in secretWord:
        print('Good guess: ' + getGuessedWord(secretWord, guessedList))
      else:
        print('Oops! That letter is not in my word: ' + getGuessedWord(secretWord, guessedList))
        guess -= 1
      print('-------------')

    if isWordGuessed(secretWord, guessedList) == True:
      print('Congratulations, you won!')
    else:
      print('Sorry, you ran out of guesses. The word was '+ secretWord + '.')
      

# When you've completed your hangman function, uncomment these two lines
# and run this file to test! (hint: you might want to pick your own
# secretWord while you're testing)

secretWord = chooseWord(wordlist).lower()
# secretWord = 'sea'
hangman(secretWord)
