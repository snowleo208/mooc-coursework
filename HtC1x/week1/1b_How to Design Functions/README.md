# How to Design Functions

This module is where this course starts to differ from other introductory programming courses—we are going to start learning the design method, and this should be new material even for people who have programmed before.


## Learning Goals

- Be able to use the How to Design Functions (HtDF) recipe to design functions that operate on primitive data.
- Be able to read a complete function design and identify its different elements.
- Be able to evaluate the different elements for clarity, simplicity and consistency with each other.
- Be able to evaluate the entire design for how well it solves the given problem.


### How To Design Functions (HtDF)

- Signature, purpose and stub.
- Define examples, wrap each in check-expect.
- Template and inventory.
- Code the function body.
- Test and debug until correct

#### Notes

- not waterfall process, i.e. can change later, like signature or template can change while developing
- need to write purpose clearly, like defining what is tall means, e.g. tall means (height > width)
- should have complete code coverage, no unexecuted code inside func
- tests should think of boundary cases