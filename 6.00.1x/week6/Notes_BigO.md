# Week 6: Program Efficiency: BIG O

**All examples in the following are in course handouts.**

## How to evaluate?

- measure with timer

  > not very useful
  > time may varies based on user input
  > cannot show relationship between input and time

- count the operations

  > assumes steps take constant time and count the qty of operations
  > shows relationship between input and time
  > no real definitio of what operation to count
  > need a better way to evaluate algo, scalability and in terms of input size

- abstract notion of order of growth

### type of order of growth

- constant: O(1)
- linear: O(n)
- logarithmic O(log n)
- log-linear: O(n log n)
- polynomial: O(![alt text](https://latex.codecogs.com/gif.latex?n^c 'n^c'))
- exponential: O(![alt text](https://latex.codecogs.com/gif.latex?C^n 'C^n'))
  (great to be linear or n log n?)

---

# Big O

- Measures upper bound on the asymptotic growth (order of growth)
- Describes the worse case
- Express rate of growth of program relative to the input size
  > find the dominant terms, e.g. ![alt text](https://latex.codecogs.com/gif.latex?n^2+2n+2 "n^2"n^2 + 2n + 2"), this case, the dominant terms is ![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2'), so it is O(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2'))

### Law of Addition of Big O

- use for sequential statements

For example:

```
''' this is O(n) '''
for i in range(n):
    print('a')

''' this is O(n^2)'''
for j in range(n*n):
    print('b')
```

So the big O is: O(n) + O(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2')) = O(n + ![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2')) = o(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2'))

![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2') is the dominant terms finally, so it is O(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2')).

### Law of Multiplication of Big O

Used with nested statement or loops. For example:

```
''' this is O(n) '''
for i in range(n):

    ''' this is O(n) '''
    for j in range(n):
        print('a')
```

Means: O(n) \* O(n) = O(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2')), because inner and outer loops also go for n times.

## Explanation:

Remember the following rules when determining the complexity order of a function:

> If running time is a sum of multiple terms, keep one with the largest growth rate (so n**3 + 100n**2 + 500,000 is O(n**3)).
> If the remaining term is a product (eg ![alt text](https://latex.codecogs.com/gif.latex?3n**2 '3n**2')), drop any multiplicative constants (so ![alt text](https://latex.codecogs.com/gif.latex?3n**2 '3n**2') is O(![alt text](https://latex.codecogs.com/gif.latex?n**2 'n\*\*2'))).

It's also good to note that if you have a function that takes a constant number of steps - regardless of the size of the input - the function is O(1), even if it takes 3,000,000 steps every time! This is because the function does not take any additional time as the input grows large.

Finally, pay attention to the fact that Programs 1, 2, and 3 were all O(n**2). This is important! Generally, a nested loop structure has O(![alt text](https://latex.codecogs.com/gif.latex?n**2 'n\*\*2')) complexity. This is not the best, as we'll discover in the next lectures in this sequence.

## Type of complexity

### Constant: O(1)

- independent of inputs
- can also have loops or recursive inside, but that calls are independent of size of input

### Logarithmic O(log n)

- complexity grows as log of size of input
- usually will divide space of search in half in each step
- e.g. bisection search, binary search of a list

Example:

```
def intToStr(i):
    digits = '0123456789'
    if i == 0:
        return '0'
    res = ''
    while(i > 0):
        res = digits[i%10] + res
        i = i//10
        return res
```

- Only need to look at loops with no func calls
- only constant number of steps in while loop
- How many times can be one divide i by 10? O(log(i))
  > It is linear in the **number of digits in n**,
  > but log in the **size of n**.

### Linear: O(n)

- search a list of sequence to see if element exists
- can depend on number of recursive calls, still O(n) because number of function call is linear

Example:

```
def fact_recur(n):
    ''' assume n = 0 '''
    if n <= 1:
        return 1
    else:
        return n*fact_recur(n-1)

```

- the recursive version maybe slower than normal iterative ver.
- but it is still O(n)

### Log-linear: O(n log n)

- many algo are in this category, e.g. merge sort

### Polynomial: O(![alt text](https://latex.codecogs.com/gif.latex?n^c 'n^c'))

- mostly are quadratic, e.g. complexity grows with square of size of input
- usually are nested loops or recursive calls

Example:

```
def isSubset(L1, L2):
    for e1 in L1:
        matched = False
        for e2 in L2:
            if e1 == e2:
                matched = True
                break
        if not matched:
            return False
    return True
```

- A nested loop here
- In the worse case, this func needs to go through all two lists to get the answer `matched`
  > O(len(L1) \* len(L2))

### Exponential: O(![alt text](https://latex.codecogs.com/gif.latex?C^n 'C^n'))

- recursive func where more that one recursive call for each size of problem, e.g. Tower of Hanoi

  Example:

```
def genSubsets(L):
    res = []
    if len(L) == 0:
        return [[]] #list of empty list
    smaller = genSubsets(L[:-1]) # all subsets without last element
    extra = L[-1:] # create a list of just last element
    new = []
    for small in smaller:
        new.append(small+extra)  # for all smaller solutions, add one with last element
    return smaller+new  # combine those with last element and those without

test = [1,2,3,4]

super = genSubsets(test)

```

- assume append is constant time
- needs time to solve smaller problem and create copy of all elements in smaller problem
- smaller problem has size of k, then it has ![alt text](https://latex.codecogs.com/gif.latex?2^k '2^k') of cases
