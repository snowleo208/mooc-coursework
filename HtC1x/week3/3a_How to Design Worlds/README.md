# Week 3a: How to Design Worlds

In this module you will learn how to design interactive programs that use the DrRacket big-bang functionality. We will make simple animations of animals walking across the screen that can be controlled by the keyboard and the mouse. In learning this process we also cover basic techniques for systematizing your work on larger programs. This module is complemented by the Compound module, which allows us to create more complex data definitions, that in turn support more complex world programs.

## Learning Goals

- Be able to explain the inherent structure of interactive graphical programs.
- Be able to use the How to Design Worlds (HtDW) recipe to design interactive programs with atomic world state.
- Be able to read and write big-bang expressions.

## Notes

### The big-bang Mechanism

1. initial state: expression that evaluates to initial world state
2. each time call `next-cat` with the current world state, to get the next world state
3. each time call `render-cat` with the current world state, to draw the current world state

```racket
(big bang 0                           ;1 Cat
    (on-tick next-cat)                ;2 Cat -> Cat
    (to-draw render-cat))             ;3 Cat -> Image

```

Big-bang is **polymorphic**, works for any type of state

> all the x in big-bang needs to be in the same type, i.e. Cat
> have to be consistant

### Domain analysis

- work on the paper first
- get all requirements and write constants (variables) and requirements clearly
- domain analysis is the model of the program
- correctly describes the structure of the program, but it has less details, we can plan our work on the program by marking up the analysis
- thus we can change or add requirements easily

## Large enumerations

- for **normal** enumerations, we need to do all test cases
- for **large enumerations**, we only need to do white-box testing, create tests based on knowledge of how the function is coded, not what it is supposed to do
  > no need to create all test cases
