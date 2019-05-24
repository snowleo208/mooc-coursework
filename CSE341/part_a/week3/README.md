# Week 3

We will start with the basics of passing and returning functions from other functions and learn some syntax for defining functions without `fun` bindings. We will see two of the most common such functions -- map and filter -- one of which is actually in our course logo, and we will see the relationship between first-class functions and polymorphic types. We will then focus on lexical scope, the key aspect of the semantics of a function that uses variables defined outside the function itself. We will then study several idioms using first-class functions that demonstrate their usefulness.

**All exmaples are from course materials.**

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

- Many higher-order functions are polymorphic because they are so reusable that some types, “can be anything”

```ml

(* higher-order functions are often polymorphic based on "whatever
type of function is passed" but not always: *)
fun times_until_zero (f,x) =
    (* note: a better implementation would be tail-recursive *)
    if x=0 then 0 else 1 + times_until_zero(f, f x)

(* conversely, we have seen polymorphic functions that are not higher-order *)
fun len xs =
    case xs of
       [] => 0
      | x::xs' => 1 + len xs'
```

### Using anonymous functions

- Most common use: Argument to a higher-order function
- Don’t need a name just to pass a function

```ml
fun triple x = 3 * x
val triple = fn y => 3 * y  (* anonymous function *)
```

#### Cannot use an anonymous function for a recursive function

- Because there is no name for making recursive calls
- If not for recursion, `fun` bindings would be syntactic sugar for val bindings and anonymous functions

### Map & Filter

```ml
(* here is a very, very useful and common example *)
fun map (f,xs) =
    case xs of
	[] => []
      | x::xs' => (f x)::(map(f,xs'))

val x1 = map ((fn x => x+1), [4,8,12,16])

val x2 = map (hd, [[1,2],[3,4],[5,6,7]])

(* another very, very useful and common example *)
fun filter (f,xs) =
    case xs of
	[] => []
      | x::xs' => if f x
		  then x::(filter (f,xs'))
		  else filter (f,xs')

fun is_even v =
    (v mod 2 = 0)

fun all_even xs =
    filter(is_even,xs)

fun all_even_snd xs =
    filter((fn (_,v) => is_even v), xs)

```

### Lexical Scope

- Function bodies can use any bindings in scope
- How can functions be evaluated in old environments that aren’t around anymore?
- The language implementation keeps them around as necessary

#### Closure

Can define the semantics of functions as follows:

- A function value has two parts
- The code (obviously)
- The environment that was current when the function was defined

### Why lexical scope

Lexical scope:  use environment where function is defined

Dynamic scope: use environment where function is called

1. Function meaning does not depend on variable names used

Example: Can change body of f to use q everywhere instead of x
Lexical scope: it cannot matter
Dynamic scope: depends how result is used

2.  Functions can be type-checked and reasoned about where defined

Example: Dynamic scope tries to add a string and an unbound variable to 6

3. Closures can easily store the data they need

### Fold and More Closures

fold(and synonyms / close relatives reduce, inject, etc.) is another very famous iterator over recursive structuresAccumulates an answer by repeatedly applying fto answer so far

```ml
(* note this is "fold left" if order matters 
   can also do "fold right" *)
fun fold (f,acc,xs) =
    case xs of 
	[] => acc
      | x::xs' => fold (f,f(acc,x),xs')
```

This pattern separates recursive traversal from data processing
- Can reuse same traversal for different data processing
- Can reuse same data processing for different data structures
- In both cases, using common vocabulary concisely communicates inten

Functions like map, filter, and foldare muchmore powerful thanks to closures and lexical scope
- Function passed in can use any “private” data in its environment
- Iterator "doesn't even know the data is there" or what type it has

### Combine functions

```ml
fun compose (f,g) = fn x => f (g x)
```

Creates a closure that "remembers" what `f` and `g` are bound to Type `('b -> 'c) * ('a -> 'b) -> ('a -> 'c)` 
ML standard library provides this as infix operator `o`

```ml
fun sqrt_of_abs i = Math.sqrt(Real.fromInt (abs i))
fun sqrt_of_abs i = (Math.sqrt o Real.fromInt o abs) i
val sqrt_of_abs = Math.sqrt o Real.fromInt o abs
```

As in math, function composition is "right to left"
- "take absolute value, convert to real, and take square root"
- "square root of the conversion to real of absolute value”

"Pipelines" of functions are common in functional programming and many programmers prefer left-to-right
- Can define our own infix operator
- This one is very popular (and predefined) in F#

### Combine functions

```ml
(* old way to get the effect of multiple arguments *)
fun sorted3_tupled (x,y,z) = z >= y andalso y >= x

val t1 = sorted3_tupled (7,9,11)

(* new way: currying *)
val sorted3 = fn x => fn y => fn z => z >= y andalso y >= x

(* alternately: fun sorted3 x = fn y => fn z => z >= y andalso y >= x *)

val t2 = ((sorted3 7) 9) 11

(* syntactic sugar for calling curried functions: optional parentheses *)
val t3 = sorted3 7 9 11 
```
Example: 
Calling `(sorted3 7)` returns a closure with:
Code `fn y => fn z => z >= y andalso y >= x`
Environment maps `x` to 7

Calling that closure with 9 returns a closure with:
Code fn `z => z >= y andalso y >= x`
Environment maps `x` to 7, `y` to 9

Calling that closure with 11 returns `true`
