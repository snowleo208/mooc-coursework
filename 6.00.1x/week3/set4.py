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



secretWord = 'apple'
hangman(secretWord)