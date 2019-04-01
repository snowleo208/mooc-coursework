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

lettersGuessed = ['e', 'i', 'k', 'p', 'r', 's']
print(getAvailableLetters(lettersGuessed))
# abcdfghjlmnoqtuvwxyz