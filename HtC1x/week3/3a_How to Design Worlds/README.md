# Week 3a: How to Design Worlds

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