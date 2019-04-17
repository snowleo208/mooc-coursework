# Week 1

This module purposely starts with very simple programs that will likely look strange to you: nothing but "variables", "numbers", and "conditionals". We focus on "scope" and "shadowing" before building on these concepts with "functions". We then use "pairs" and "lists" as two complementary ways to build compound data. Next we consider "let expressions" for "local bindings", including "nested functions" and the importance of bindings for efficiency. We finish with a couple other specific language features used in the homeworks -- "options" and "booleans" and then some more general perspective on the benefits of programming without mutation and the different aspects of a programming language. 

## Notes

### Type-checking

> e1 is bool
> e2 and e3 needs to be in the same type

```ml
if e1 then e2 else e3
```

> no type for val if it is getting errors, e.g. `val z = if y then 34 (int) else x < 4 (boolean)`, no type for `z` in this case as no type-check

> can only use `~` for negative number and `-5` is not acceptable, minus can only used by binary operation, e.g. `10 - 5`

> no `/` for division, use `div`, e.g. `10 div 5`

### Shadowing

- no way to assign to a variable in ML
- can only shadow it in later environment

### Functions

- function is a **value**

> add function to environment so can call it later
> function call semantics also allowed recursion

Type-checking:

e.g. `e0 (e1,…,en)`

If:
`e0`  has some type `(t1 * … * tn) -> t`
`e1` has type `t1`,   …,    en has type `tn`

Then:
`e0(e1,…,en)` has type t

### Turples and Lists

use `#` to access turple, e.g. 

```ml
fun swap (pr : int*bool) =
    (#2 pr, #1 pr)
```