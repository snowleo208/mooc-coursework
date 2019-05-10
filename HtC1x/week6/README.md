# Week 6: Binary Search Trees

In this module we will investigate how the structure of data affects performance, especially when it comes to the time required to find an element in a large data store. As part of that we will discover a new self-referential form of data, the binary search tree or BST.

We will also learn to design data definitions and functions for BSTs. We will not need any new design techniques for this; we already know enough to do it. In fact, the recipe rules we have already covered can work with a wide range of self-referential data.

The programs are bit longer again in this module. To avoid feeling overwhelmed by the new form of data it is really important to let the design recipe help you focus your attention. Don't try to think about the whole problem at once - focus on the current step of the recipe only.

Also be sure to trust the natural recursion! That's the key to making it easy to design functions that operate on data that has self-reference in its definition.

## Learning Goals

- Be able to reason informally about the time required to search data.
- Be able to identify problem domain information that should be represented using binary search trees.
- Be able to check whether a given tree conforms to the binary search tree invariants.
- Be able to use the design recipes to design with binary search trees.

### Notes

```racket
(define L1 (list "b" "c"))
(define L1 (list "d" "e" "f"))
(cons "a" L1)  ; return (list "a" "b" "c")
(list "a" L1)  ; return (list "a" (list "b" "c"))
```

- use `cons` if you want to add elements
- use list when you want to create a new list

```racket
(append L1 L2) ;return (list "b" "c" "d" "e" "f")
```

`append` combine multiple lists into one new list

### Binary Search Tree (BST)

- at each level, all items in left sub-tree is less than root
- at each level, all items in right sub-tree is larger than root
- on average, log(n) for searching tree node
