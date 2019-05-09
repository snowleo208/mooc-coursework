# Week 4a: Self Reference

We are going to explore one of the most beautiful concepts in Computer Science: well formed self-reference. Of course just the name doesn't mean much. But what it will allows us to do is represent arbitrarily large amounts of information. You may not have noticed, but so far we can't do that. We can represent a single city name, but not all the cities on the Weird Sisters Summer 2013 Tour. We can make one cow walk back and forth across the screen, but not a whole group of cows (much less a herd).

Arbitrary-sized information is information that we don't know the size of in advance. A program that can display any number of cows is operating with abitrary-sized information.

The videos this module range in length. But there isn't a half hour one! As before, the longer ones are mostly just a step-by-step working through of a problem, so while it takes time to watch, it isn't all new content.

## Learning Goals

- Be able to use list mechanisms to construct and destruct lists.
- Be able to identify problem domain information of arbitrary size that should be represented using lists and lists of structures.
- Be able to use the HtDD, HtDF and Data Driven Templates recipes with such data.
- Be able to explain what makes a self-referential data definition well formed and identify whether a particular self-referential data definition is well-formed.
- Be able to design functions that consume and produce lists and lists of structures.
- Be able to predict and identify the correspondence between self-references in a data definition and natural recursions in functions that operate on the data.

## Notes

### Lists

```racket
empty
(define L1 (cons "Flame" empty))                    ; a list of 1 element
(define L2 (cons "Leaf" (cons "Flame" empty)))      ; a list of 2 elements

(first L1) ;"Flame"
(first L2) ;"Leaf"
(rest L2)  ;"(cons "Flame" '())
(first (rest L2))  ;get the second element "Flame"
```

### Recipe for Lists

An arbitrary amount of information

- requires arbitrary-sized data

Well-formed self-reference:

- at least one base case
- at least one self-reference case

Examples should included base and self-reference cases.

> Use the template and trust natural recursions :)
