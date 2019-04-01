def fib(n):
    """ Get Fibonacci Sequence """
    if n == 0 or n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)

""" Get n Fibonacci numbers """
count = 0
end = 10
while(count < end):
    if count == end-1:
        print(str(fib(count)) + '.')
        count += 1
    elif count == 0:
        print('Fibonacci Sequence: ')
        print(str(fib(count)) + ', ', end="")
        count += 1
    else:
        print(str(fib(count)) + ', ', end="")
        count += 1