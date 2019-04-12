# Week 6: Program Efficiency: Searching and Sorting Algorithms

**All codes are provided by course and belong to MIT**

# Searching

### Linear search

- brute force search
- list is ok to be not sorted

### Bisection search

- list **must** be sorted

# Sorting

## Bubble Sort

- swap element in pair
- loop again when not sorted
- stop when no more swaps have been made
- O(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2')) for minimum

```
def bubble_sort(L):
    swap = False
    while not swap:
        swap = True
        print(L)
        for j in range(1, len(L)):
            if L[j-1] > L[j]:
                swap = False
                temp = L[j]
                L[j] = L[j-1]
                L[j-1] = temp


test = [1, 5, 3, 8, 4, 2, 9, 6]
```

## Selection Sort

- select minimum element and swap it with index 0
- compare minimum element with full list
- choose the smallest one as index 0
-
- O(![alt text](https://latex.codecogs.com/gif.latex?n^2 'n^2'))

```
def selection_sort(L):
    suffixStart = 0
    while suffixStart != len(L):
        print(L)
        for i in range(suffixStart, len(L)):
            if L[i] < L[suffixStart]:
                L[suffixStart], L[i] = L[i], L[suffixStart]
        suffixStart += 1

test = [1, 5, 3, 8, 4, 9, 6, 2]

```
