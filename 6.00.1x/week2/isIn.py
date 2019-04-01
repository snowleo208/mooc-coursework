def isIn(char, aStr):
    '''
    char: a single character
    aStr: an alphabetized string
    
    returns: True if char is in aStr; False otherwise
    '''
    # Your code here
    if aStr == '':
        return False
    elif char == aStr[0]:
        return char == aStr[0]
    else:
        if len(aStr) == 1 and char != aStr[0]:
            return False
        elif char > aStr[int(len(aStr) / 2)]:
            aStr = aStr[int(len(aStr) / 2):]
            return isIn(char, aStr)
        elif char < aStr[int(len(aStr) / 2)]:
            aStr = aStr[0:int(len(aStr) / 2)]
            return isIn(char, aStr)
        elif char == aStr[int(len(aStr) / 2)]:
            return True
