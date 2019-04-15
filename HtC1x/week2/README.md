# Week 2 - How to Design Data

In this module we begin learning how to design data representations of problem domain information. While systems tend to have more function designs than data designs, the design of the data turns out to drive the design of the functions. So data design is a critical part of program design.

Working through the videos and practice materials for this module should take approximately 5-8 hours of dedicated time to complete.

## Learning Goals

- Be able to use the How to Design Data Definitions (HtDD) recipe to design data definitions for atomic data.
- Be able to identify problem domain information that should be represented as simple atomic data, intervals, enumerations, itemizations and mixed data itemizations.
- Be able to use the Data Driven Templates recipe to generate templates for functions operating on atomic data.
- Be able to use the How to Design Functions (HtDF) recipe to design functions operating on atomic data.

---

## Notes

### Integer

- you can use [] for a list of Integer
- use () for exceptions, for example, `[1,32)` for 1 to 31, and except 32.
> Integer means 1,2,3,... 
> Natural can means 1, 1.1, 1.2, 1.3...

```
;; SeatNumber is Integer [1 ,32]
;; interp. the number of a seat
```

### Enumerations

- no examples for enumerations, as those examples are redundant, e.g. `(define LG1 "A")` when LetterGrade means one of "A", "B" or "C", it is easy to know that `LG1`, `LG2` or `LG3` is "A", "B" and "C", so does not need to create examples.

### Itemization

- use itemization when it contains 2 or more subclasses and at least one of the item is not distinct. e.g.:

```
 - not yet started          ;distinct
 - from 10 to 1 seconds before midnight     ;Enumerations
 - complete (Happy New Year!) ;distinct
 ```

 Therefore you can use this format:

```racket
;; CountDown is one of:
;; - false
;; - Natural[1, 10]
;; - "complete"
;; interp.
;;    false means countdown has not yet started
;;    Natural[1,10] means countdown is started and how many seconds left
;;    "complete" means the countdown is over

```

In a mixed data itemization, data must be guarded from different data types, so the template should be:

```racket
(define (fr-for-count-down cd)
  cond([(false? cd) (...)]
       [(and (number? c) (<= 1 c) (<= c 10) (...c)]
  )
```

- add `(number? c)` to guard from different data types.
- if subclass is the last subclass of the type, we can reduce the guard like from `(number? c) (<= 1 c) (<= c 10)` to `(number? c)`.

## Structure of Information Flows

| Information   | Data       | Template  | Function Tests  |
| ------------- |:----------:| ---------:| ---------------:|
**----------------------- Structure --------------------------- >**

- key step is to identify structure of information
- **choosing** the structure to use is important in sophisticated problems