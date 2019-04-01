def fib_dict(i, d):
    """ 
    Get Fibonacci Sequence using dictionary 
    which is more efficient than using recursion
    i - get n of Fibonacci Sequence
    d - dictionary that store Fibonacci Sequence
    """
    if (i == 0 or i == 1) and i not in d:
        d[i] = 1
        return d[i]
    if i in d:
        return d[i]
    else:
        fib = fib_dict(i-1, d) + fib_dict(i-2, d)
        d[i] = fib
        return fib

dictionary = {}
fib_dict(9, dictionary)

print('Fibonacci Sequence: ')
print(dictionary.values())