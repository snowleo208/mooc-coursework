# 3b: Compound Data

In this module you will learn how to design compound data definitions to represent information that consists of two or more naturally connected values, as well as how to use such data as a world state in HtDW problems.

## Learning Goals

- Be able to identify domain information that should be represented as compound data.
- Be able to read and write define-struct definitions.
- Be able to design functions that consume and/or produce compound data.
- Be able to design world programs that use compound world state.

## Notes

### define structure

```racket
(define-struct pos(x y))

(define P1 (make-pos 3 6)) ;constructor
(define P2 (make-pos 2 8)) ;constructor

(pos-x P1) ;selector: 3
(pos-y P2) ;selector: 8

(pos? P1) ;predicate: true
(pos? "hello") ;predicate: false

```
