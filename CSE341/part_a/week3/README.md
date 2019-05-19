# Week 3

We will start with the basics of passing and returning functions from other functions and learn some syntax for defining functions without `fun` bindings. We will see two of the most common such functions -- map and filter -- one of which is actually in our course logo, and we will see the relationship between first-class functions and polymorphic types. We will then focus on lexical scope, the key aspect of the semantics of a function that uses variables defined outside the function itself. We will then study several idioms using first-class functions that demonstrate their usefulness.

## Notes

### First-Class Functions

First-class functions: Can use them wherever we use values

- Most common use is as an argument / result of another function
- Other function is called a **higher-order function**
- Powerful way to factor out common functionality

```ml
fun double x = 2*x
fun incr x = x+1
val a_tuple = (double, incr, double(incr 7))
val eighteen = (#1 a_tuple) 9
```

### Functions As Arguments
